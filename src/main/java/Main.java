import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
Для игры в Wordle(RU)
В словаре 2787 слов из 5 букв
Путем исключения и наличия букв в слове, уменьшаем словарь подходящих слов
Если флажок "+" после буквы, то словарь фильтруется по наличию буквы в слове
Если флажок "-" после буквы, то словарь фильтруется по отсутствию буквы в слове
 */

public class Main {
    public static void main(String[] args) throws IOException {
        // Создаем пустой список
        ArrayList<String> arrayList = new ArrayList<>();

        // Читаем файл со словами
        FileReader fileReader = new FileReader("text.txt");
        Scanner scanner = new Scanner(fileReader);

        //Добавляем в наш список все слова из файла
        while (scanner.hasNextLine()) {
            arrayList.add(scanner.nextLine());
        }

        // Создаем принимающую переменную из консоли
        Scanner whScanner = new Scanner(System.in);

        // для выхода из нашего цикла
        boolean run = true;

        while (run) {
            String charter = whScanner.next();
            // если захотим выйти
            if (charter.equals("exit")) run = false;

            //Если флаг после буквы "-", то удаляем из списка все слова с наличием этой буквы
            if (charter.substring(1).equals("-")) {
                arrayList.removeIf(word -> word.contains(charter.substring(0, 1)));
                arrayList.forEach(System.out::println);
                System.out.println("Осталось слов: - " + arrayList.size());

                //Если флаг после буквы "+", то удаляем из списка все слова с без этой буквы
            } else if (charter.substring(1).equals("+")) {
                arrayList.removeIf(word -> !word.contains(charter.substring(0, 1)));
                arrayList.forEach(System.out::println);
                System.out.println("Осталось слов: - " + arrayList.size());
            }
        }
    }
}
