import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskTest {
    String setupQuery = "таблетки";


    @Test
    public void shouldTestMatchesForSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(8, "Принять таблетки");

        boolean expected = true;
        boolean actual = simpleTask.matches(setupQuery);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldTestMatchesForEpic() {
        String[] subtasks = {"вода", "таблетки", "масло"};
        Epic epic = new Epic(76, subtasks);

        boolean expected = true;
        boolean actual = epic.matches(setupQuery);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTestMatchesForMeeting() {
        Meeting meeting = new Meeting(
                9,
                "Обсудить зарплату",
                "Приложение Кошелек",
                "13:30 в пятницу"
        );

        boolean expected = false;
        boolean actual = meeting.matches(setupQuery);
    }

}