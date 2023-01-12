package thread;

import java.util.Arrays;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Runnable firstTask = () -> System.out.println("Suma liczb wynosi: " + integers.stream()
                .mapToInt(Integer::intValue).sum());

        Runnable secondTask = () -> {

            int sum = integers.stream().mapToInt(Integer::intValue).sum();
            int numberOfNumbers = integers.size();
            System.out.println("Średnia liczb wynosi: " + (double) sum / (double) numberOfNumbers);

        };

        Thread firstThread = new Thread(firstTask);
        Thread secondThread = new Thread(secondTask);

        firstThread.start();
        secondThread.start();
    }
}

