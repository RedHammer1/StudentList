package com.example;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    // Метод для обработки студентов: перевод на следующий курс и удаление
    // студентов, которые закончили обучение
    public static void processStudents(List<Student> students) {
        System.out.println("Студенты переводятся на следующий курс, если у них средняя оценка не менее 3\n");
        Iterator<Student> iterator = students.iterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            // Проверка на среднюю оценку
            if (student.getAverageGrade() < 3) {
                iterator.remove(); // Удаляем студента, если средняя оценка ниже 3
            } else {
                student.toNextCourse(); // Переводим студента на следующий курс
            }

            // Проверка на окончание обучения
            if (student.getCourse() > 4) {
                System.out.println(student + " закончил обучение");
                iterator.remove(); // Удаляем студента, если он закончил обучение
            }
        }
    }

    // Метод для вывода студентов определенного курса
    public static void printStudents(List<Student> students, int course) {
        System.out.println("Студенты " + course + "-го курса:");
        boolean found = false; // Флаг для проверки наличия студентов

        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student); // Выводим информацию о студенте
                found = true; // Устанавливаем флаг, если нашли студента
            }
        }

        if (!found) {
            System.out.println("Нет студентов на данном курсе."); // Сообщение, если студентов нет
        }
    }

    public static int getInteger(Scanner scanner, String s) {
        try {
            System.out.print(s);
            int a = Integer.parseInt(scanner.nextLine());

            // Дополнительные проверки: значение должно быть положительным
            if (a <= 0) {
                throw new NumberFormatException();
            }
            return a; // Возвращаем корректное значение
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ввод. Пожалуйста, введите целое число.");
            return getInteger(scanner, s);
        }
    }

    public static void main(String[] args) throws UnsupportedEncodingException {

        Scanner scanner = new Scanner(System.in, "Windows-1251");

        List<Student> students = new ArrayList<Student>();

        int count = getInteger(scanner, "Введите кол-во студентов:");

        for (int i = 0; i < count; i++) {
            if(i<0) System.out.print("Введите данные о следующем студенте: ");
            System.out.print("Имя: ");
            String name = scanner.nextLine();

            String name_encoded = new String(name.getBytes("Windows-1251"), Charset.forName("cp866")); // Преобразуем в кодировку консоли

            System.out.print("Группа: ");
            String group = scanner.nextLine();
            String group_encoded = new String(group.getBytes("Windows-1251"), Charset.forName("cp866")); // Преобразуем в кодировку консоли

            int course = getInteger(scanner, "Курс:");

            List<Integer> grades = new ArrayList<>();

            int numberOfGrades = getInteger(scanner, "Введите количество оценок:");
            for (int j = 0; j < numberOfGrades; j++) {
                int grade = getInteger(scanner, "Оценка " + (j + 1) + ": ");
                grades.add(grade); // Добавляем оценку в список
            }

            students.add(new Student(name_encoded, group_encoded, course, grades)); // Добавляем студента в список
        }

        processStudents(students); // Обрабатываем студентов

        int courseForPrint = getInteger(scanner, "Введите номер курса для вывода студентов: ");
        printStudents(students, courseForPrint); // Выводим студентов определенного курса

        scanner.close(); // Закрываем сканер
    }
}