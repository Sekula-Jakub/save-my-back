package org.example.savemyback;

public class User {
    private String name;
    private TimePeriods timePeriod;
    private boolean canWalk;

    public User(String name, TimePeriods timePeriod, boolean canWalk) {
        this.name = name;
        this.timePeriod = timePeriod;
        this.canWalk = canWalk;
    }

    public String getName() {
        return name;
    }

    public TimePeriods getTimePeriod() {
        return timePeriod;
    }

    public boolean isCanWalk() {
        return canWalk;
    }
}
