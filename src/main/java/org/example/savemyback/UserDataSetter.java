package org.example.savemyback;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UserDataSetter {
    public static boolean checkFile() {
        Path filePath = Paths.get("user_info.ser");
        if(Files.exists(filePath)) {
            return true;
        }
        return false;
    }

    public static void saveUserData(User user) {
        try (ObjectOutputStream objectOutStr = new ObjectOutputStream(new FileOutputStream("user_info.ser"))){
            objectOutStr.writeObject(user);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static User retrieveUserData() {
        String filePath = "user_info.ser";
        User retirevedUser = null;

        try (ObjectInputStream objectInStr = new ObjectInputStream((new FileInputStream(filePath)))) {
            retirevedUser = (User) objectInStr.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        return retirevedUser;
    }
}
