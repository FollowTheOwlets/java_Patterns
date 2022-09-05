import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);
    private static final Logger logger = Logger.getInstance();

    public static void main(String[] args) {
        List<Integer> list;
        Filter filter;
        String answer;
        int size;
        int maxValue;
        int treshold;

        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");

        System.out.println("Введите размер списка: ");
        answer = scan.nextLine();
        try {
            size = Integer.parseInt(answer);
        } catch (NumberFormatException e) {
            logger.log("Неверный ввод размера");
            logger.log("Прекращение работы программы");
            return;
        }

        System.out.println("Введите верхнюю границу для значений: ");
        answer = scan.nextLine();
        try {
            maxValue = Integer.parseInt(answer);
        } catch (NumberFormatException e) {
            logger.log("Неверный ввод границы для значений");
            logger.log("Прекращение работы программы");
            return;
        }

        logger.log("Создаем и наполняем список");
        list = generateList(size, maxValue);

        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.println("Введите порог для списка: ");
        answer = scan.nextLine();

        try {
            treshold = Integer.parseInt(answer);
        } catch (NumberFormatException e) {
            logger.log("Неверный ввод порога для фильтра");
            logger.log("Прекращение работы программы");
            return;
        }

        filter = new Filter(treshold);
        list = filter.filterOut(list);

        System.out.print("Отфильтрованный список: ");
        list.forEach(e -> {
            System.out.print(e + " ");
        });
        System.out.println();

        logger.log("Завершаем программу");
    }

    private static List<Integer> generateList(int size, int maxValue) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(maxValue));
        }

        return list;
    }
}
