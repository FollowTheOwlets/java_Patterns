package person;

import person.builder.PersonBuilder;

import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    // Сначала подумал, что можно в возрасте держать -1 (если не указано), но это противоречит логике
    protected int age;
    protected boolean hasAge;
    protected String address;
    protected boolean hasAddress;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.hasAddress = false;
        this.hasAge = false;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.hasAge = true;
        this.hasAddress = false;
    }

    public Person(String name, String surname, String address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.hasAddress = true;
        this.hasAge = false;
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.hasAge = true;
        this.address = address;
        this.hasAddress = true;
    }

    public boolean hasAge() {
        return this.hasAge;
    }

    public boolean hasAddress() {
        return this.hasAddress;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public OptionalInt getAge() {
        if (this.hasAge) {
            return OptionalInt.of(this.age);
        } else {
            throw new IllegalStateException("Попытка получения информации о возрасте. Причина ошибки: Возраст не установлен.");
        }
    }

    public String getAddress() {
        if (this.hasAge) {
            return this.address;
        } else {
            throw new IllegalStateException("Попытка получения информации об адресе. Причина ошибки: Адрес не установлен.");
        }
    }

    public void setAddress(String address) {
        if (address.trim().length() == 0) {
            throw new IllegalArgumentException("Некоректный адрес.");
        }
        this.address = address;
        this.hasAddress = true;
    }

    public void happyBirthday() {
        if (this.hasAge) {
            this.age++;
        } else {
            throw new IllegalStateException("Попытка изменения возраста. Причина ошибки: Возраст не установлен.");
        }
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setAge(0).setSurname(this.surname);
    }

    @Override
    public String toString() {
        return "\nИнформация о человеке:\nИмя: " + this.name + "\nФамилия: " + this.surname +
                "\nВозраст: " +
                (this.hasAge ? this.age : "не указан") +
                "\nАдрес: " +
                (this.hasAddress ? this.address : "не указан") + "\n";
    }

    @Override
    public int hashCode() {
        int hash = this.name.hashCode() * 100 + this.surname.hashCode();
        hash += this.hasAge ? this.age * 1000 : 0;
        hash += this.hasAddress ? this.address.hashCode() * 10000 : 0;
        return hash;
    }
}
