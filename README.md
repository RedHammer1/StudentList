# Инструкция для пользователей
## Обзор программы
Эта программа предназначена для управления списком студентов. Она позволяет вводить данные о студентах, переводить их на следующий курс в зависимости от средней оценки, удалять студентов, которые закончили обучение, и выводить информацию о студентах определенного курса.
## Использование программы
# 1. Запуск программы
- Скачайте репозиторий и скомпилируйте файлы Main.java и Student.java.
- Запустите программу через терминал или IDE.
# 2. Ввод данных о студентах
- Введите количество студентов, которых вы хотите добавить.
- Для каждого студента введите:
- - Имя
- - Группу
- - Курс
- - Количество оценок
- - Каждую оценку
# 3. Обработка студентов
- Программа автоматически переводит студентов на следующий курс, если их средняя оценка не менее 3.
- Удаляет студентов, которые закончили обучение (т.е. находятся на курсе выше 4-го).
# 4. Вывод студентов
- Введите номер курса, для которого вы хотите вывести список студентов.
- Программа отобразит информацию о студентах указанного курса.
# Примечания
- Программа работает с кодировкой Windows-1251 для ввода и преобразует текст в cp866 для вывода в консоли.
- Вводите целые положительные числа при запросе количества студентов, курса и оценок.
# Требования
- Java Development Kit (JDK) для компиляции и запуска программы.
- Терминал или IDE для запуска программы.
# Возможные ошибки
Если при вводе данных программа выдаёт сообщение об ошибке, проверьте корректность ввода (целые положительные числа для количества студентов, курса и оценок).
