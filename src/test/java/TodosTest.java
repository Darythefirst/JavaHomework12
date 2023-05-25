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
}

