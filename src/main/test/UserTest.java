import com.sun.source.tree.AssertTree;
import org.example.savemyback.TimePeriods;
import org.example.savemyback.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    public void equalsTest() {
        User user1 = new User("Johnson", TimePeriods.MINUTES30, true);
        User user2 = new User("Johnson", TimePeriods.MINUTES30, true);
        Assertions.assertTrue(user1.equals(user2));
    }
}
