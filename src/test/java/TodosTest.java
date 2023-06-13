import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTestSearch() {
        SimpleTask simpleTask = new SimpleTask(8, "Принять таблетки");

        String[] subtasks = {"вода", "таблетки", "масло"};
        Epic epic = new Epic(76, subtasks);

        Meeting meeting = new Meeting(
                9,
                "Обсудить зарплату",
                "Приложение Кошелек",
                "13:30 в пятницу"
        );

        Todos searchTodo = new Todos();
        searchTodo.add(simpleTask);
        searchTodo.add(epic);
        searchTodo.add(meeting);

        Task[] expected = {simpleTask, epic};
        Task[] actual = searchTodo.search("таблетки");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldTestSearch2() {
        SimpleTask simpleTask = new SimpleTask(19, "Записаться к врачу");

        String[] subtasks = {"Купить тетради", "Купить ручки", "Купить карандаши"};
        Epic epic = new Epic(82, subtasks);

        Meeting meeting = new Meeting(
                21,
                "Запись к врачу",
                "Проверить здоровье",
                "8:45 13.07.2023"
        );

        Todos searchTodo = new Todos();
        searchTodo.add(simpleTask);
        searchTodo.add(epic);
        searchTodo.add(meeting);

        Task[] expected = {simpleTask, meeting};
        Task[] actual = searchTodo.search("врач");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldTestSearch3() {
        SimpleTask simpleTask = new SimpleTask(1, "Записаться к парикмахеру");

        String[] subtasks = {"футболка", "парик", "носки"};
        Epic epic = new Epic(12, subtasks);

        Meeting meeting = new Meeting(
                3,
                "Запись в салон",
                "подстричься у парикмахера",
                "11:00 завтра"
        );

        Todos searchTodo = new Todos();
        searchTodo.add(simpleTask);
        searchTodo.add(epic);
        searchTodo.add(meeting);

        Task[] expected = {simpleTask, meeting};
        Task[] actual = searchTodo.search("парикмахер");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldTestSearch4() {
        SimpleTask simpleTask = new SimpleTask(10, "Встреча с Катей");

        String[] subtasks = {"футболка", "шорты", "носки"};
        Epic epic = new Epic(100, subtasks);

        Meeting meeting = new Meeting(
                120,
                "Играем в футбол",
                "тренировка для сборной",
                "9:00 в воскресенье"
        );

        Todos searchTodo = new Todos();
        searchTodo.add(simpleTask);
        searchTodo.add(epic);
        searchTodo.add(meeting);

        Task[] expected = {epic, meeting};
        Task[] actual = searchTodo.search("футбол");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSearchAllTasks() {
        SimpleTask simpleTask = new SimpleTask(1, "Сходить в магазин за хлебом");

        String[] subtasks = {"хлеб", "молоко", "масло"};
        Epic epic = new Epic(20, subtasks);

        Meeting meeting = new Meeting(
                300,
                "Попросить маму купить хлеб",
                "Готовим борщ",
                "16 ч сегодня"
        );

        Todos searchTodo = new Todos();
        searchTodo.add(simpleTask);
        searchTodo.add(epic);
        searchTodo.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = searchTodo.search("хлеб");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchNoTasks() {
        SimpleTask simpleTask = new SimpleTask(2, "Сходить в магазин");

        String[] subtasks = {"хлеб", "молоко", "масло"};
        Epic epic = new Epic(21, subtasks);

        Meeting meeting = new Meeting(
                301,
                "Попросить маму купить сметанку",
                "Готовим борщ",
                "завтра"
        );

        Todos searchTodo = new Todos();
        searchTodo.add(simpleTask);
        searchTodo.add(epic);
        searchTodo.add(meeting);

        Task[] expected = {};
        Task[] actual = searchTodo.search("суп");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchOneTasks() {
        SimpleTask simpleTask = new SimpleTask(3, "зубной");

        String[] subtasks = {"блокнот", "ручка", "линейка"};
        Epic epic = new Epic(22, subtasks);

        Meeting meeting = new Meeting(
                302,
                "Совещание на работе",
                "Протезирование зубов для коллеги",
                "в пятницу после работы"
        );

        Todos searchTodo = new Todos();
        searchTodo.add(simpleTask);
        searchTodo.add(epic);
        searchTodo.add(meeting);

        Task[] expected = {simpleTask};
        Task[] actual = searchTodo.search("зубной");
        Assertions.assertArrayEquals(expected, actual);
    }

}

