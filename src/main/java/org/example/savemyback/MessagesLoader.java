package org.example.savemyback;

import java.util.ArrayList;
import java.util.TreeMap;

public class MessagesLoader {
    private static TreeMap<Integer, ArrayList<String>> treeMap = new TreeMap<>();

    static {
        treeMap.put(1, new ArrayList<>());
        treeMap.put(2, new ArrayList<>());
        treeMap.put(3, new ArrayList<>());

        treeMap.get(1).add("Hey there!\n" +
                "Your screen loves you, but your posture doesn't.\n" +
                "How about a quick 3-minute stretch?");
        treeMap.get(1).add("I think it’s about time for You to stand up\n" +
                "and go for a short walk.\n" +
                "We suggest about 2 - 5 minutes.");
        treeMap.get(1).add( "Fun fact: your chair isn't actually part of \n" +
                "your body. Let's prove it by standing up\n" +
                "for 2 to 5 minutes.");
        treeMap.get(2).add("Warning: Your couch-potato mode is currently\n" +
                "loading. Defeat it by taking a short\n" +
                "4-minute walk right now!");
        treeMap.get(2).add("Rumor has it there is a whole world outside\n" +
                "of this monitor. Go check if it’s still there\n" +
                "for 5 minutes. I'll wait :)");
        treeMap.get(2).add("Your eyes called. They miss seeing things\n" +
                "that aren't made of pixels. Give them\n" +
                "a 3-minute break, okay?");
        treeMap.get(3).add("Look, we need to talk. You and that chair\n" +
                "are getting way too close. Break up with it for\n" +
                "just 5 minutes.");
        treeMap.get(3).add("If you stay seated any longer, you might\n" +
                "actually evolve into a gaming chair. Stand up an\n" +
                "save your humanity! 2-5 minutes should do.");
        treeMap.get(3).add("Error 404: Human activity not found. You look\n" +
                "like a statue. Get up, unplug yourself, and\n" +
                "walk around before you forget how to use your legs.");
    }

    public static String getCorrespondingMessge(int minutes) {
        int lowActivityScale;
        if(minutes >= 0 && minutes <=120) {
            lowActivityScale = 1;
        } else if(minutes > 120 && minutes <= 360) {
            lowActivityScale = 2;
        } else {
            lowActivityScale = 3;
        }

        int messageNumber = (int) (Math.random() * 3);
        return treeMap.get(lowActivityScale).get(messageNumber);
    }
}
