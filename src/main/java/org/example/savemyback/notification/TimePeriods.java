package org.example.savemyback.notification;

public enum TimePeriods {
    MINUTES30(30),
    MINUTES40(40),
    MINUTES50(50),
    MINUTES60(60),
    MINUTES70(70),
    MINUTES80(80),
    MINUTES90(90);

    private final int minutes;

    TimePeriods(int minutes) {
        this.minutes = minutes;
    }

    public int getMinutes() {
        return minutes;
    }

    public static TimePeriods parseToTimePeriods(String minutes) {
        switch (minutes) {
            case "30":
                return MINUTES30;
            case "40":
                return MINUTES40;
            case "50":
                return MINUTES50;
            case "60":
                return MINUTES60;
            case "70":
                return MINUTES70;
            case "80":
                return MINUTES80;
            case "90":
                return MINUTES90;
            default:
                break;
        }
        return null;
    }
}
