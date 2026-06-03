import org.example.savemyback.User;
import org.example.savemyback.UserDataSetter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UserDataSetterTest {
    String dirName = "user_info.ser";

    @Test
    public void testCheckFolder() {
        Path newDir = Paths.get(dirName);
        try {
            Files.createFile(newDir);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        Assertions.assertTrue(UserDataSetter.checkFile());
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
