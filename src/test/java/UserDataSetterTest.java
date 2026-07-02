import org.example.savemyback.notification.TimePeriods;
import org.example.savemyback.model.User;
import org.example.savemyback.model.UserDataSetter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UserDataSetterTest {
    String dirName = "user_info.ser";

    @Test
    public void testCheckFile() {
        Path newDir = Paths.get(dirName);
        try {
            Files.createFile(newDir);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        Assertions.assertTrue(UserDataSetter.checkFile());
    }

    @Test
    public void testSaveAndRetrieveUserData() {
        User savedUser = new User("Michal", TimePeriods.MINUTES30, true);
        UserDataSetter.saveUserData(savedUser);
        User retrievedUser = UserDataSetter.retrieveUserData();

        Assertions.assertTrue(savedUser.equals(retrievedUser));
    }

    @AfterEach
    public void cleanUp() {
        Path dir = Paths.get(dirName);
        try {
            Files.delete(dir);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
