import java.io.*;
import java.util.Random;

public class Exercise_1 {
    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Необхідно вказати ім'я файлу, нижню межу, верхню межу та кількість чисел у командному рядку.");
            System.out.println("Формат команди для запису: java RandomNumberWriterReader write <ім'я_файлу> <нижня_межа> <верхня_межа> <кількість_чисел>");
            System.out.println("Формат команди для читання: java RandomNumberWriterReader read <ім'я_файлу>");
            return;
        }

        String operation = args[0];
        String fileName = args[1];

        if (operation.equals("write")) {
            if (args.length < 5) {
                System.out.println("Необхідно вказати нижню межу, верхню межу та кількість чисел у командному рядку.");
                System.out.println("Формат команди для запису: java RandomNumberWriterReader write <ім'я_файлу> <нижня_межа> <верхня_межа> <кількість_чисел>");
                return;
            }

            int lowerBound = Integer.parseInt(args[2]);
            int upperBound = Integer.parseInt(args[3]);
            int count = Integer.parseInt(args[4]);

            try {
                FileWriter fileWriter = new FileWriter(fileName, true);

                Random random = new Random();
                for (int i = 0; i < count; i++) {
                    int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
                    fileWriter.write(randomNumber + "\n");
                }

                fileWriter.close();
                System.out.println("Дані успішно записані у файл " + fileName);
            } catch (IOException e) {
                System.out.println("Виникла помилка при записі у файл " + fileName);
                e.printStackTrace();
            }
        } else if (operation.equals("read")) {
            try {
                FileReader fileReader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line;
                System.out.println("Вміст файлу " + fileName + ":");
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }

                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Виникла помилка при читанні файлу " + fileName);
                e.printStackTrace();
            }
        } else {
            System.out.println("Невідома операція: " + operation);
            System.out.println("Доступні операції: write, read");
        }
    }
}
//write Roman.txt 1 10 5
//read Roman.txt 1 10 5

