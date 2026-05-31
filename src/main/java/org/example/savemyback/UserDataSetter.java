package org.example.savemyback;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SerializationChecker {
    public static boolean checkFolder() {
        Path folderPath = Paths.get("user_info");
        if(Files.exists(folderPath) && Files.isDirectory(folderPath)) {
            return true;
        }
        return false;
    }


}
