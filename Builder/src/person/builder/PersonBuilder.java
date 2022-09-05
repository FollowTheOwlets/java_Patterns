package person.builder;

import person.Person;

public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age;
    protected String address;

    public PersonBuilder() {
        this.name = "";
        this.surname = "";
        this.age = -1;
        this.address = "";
    }

    public PersonBuilder setName(String name) {
        if (name.trim().length() == 0) {
            throw new IllegalArgumentException("Некоректное имя.");
        }
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if (surname.trim().length() == 0) {
            throw new IllegalArgumentException("Некоректная фамилия.");
        }
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Некоректный возраст");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        if (address.trim().length() == 0) {
            throw new IllegalArgumentException("Некоректный адрес.");
        }
        this.address = address;
        return this;
    }

    public Person build() {
        if (this.name.length() != 0 && this.surname.length() != 0) {
            if (this.age != -1 && this.address.length() != 0) {
                return new Person(this.name, this.surname, this.age, this.address);
            } else if (this.age != -1) {
                return new Person(this.name, this.surname, this.age);
            } else if (this.address.length() == 0) {
                return new Person(this.name, this.surname, this.address);
            } else {
                return new Person(this.name, this.surname);
            }
        } else {
            throw new IllegalStateException ("Отсутствует имя или фамилия человека. Невозможно построить класс Person.");
        }
    }
}
