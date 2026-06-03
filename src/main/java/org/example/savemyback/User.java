package org.example.savemyback;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
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

    public boolean getCanWalk() {
        return canWalk;
    }

    @Override
    public boolean equals(Object obj) {
        User user;
        if(obj != null && this.getClass() == obj.getClass()) {
            user = (User) obj;
            if(user.name.equals(this.name) && user.timePeriod == this.timePeriod && user.canWalk == this.canWalk) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, timePeriod, canWalk);
    }
}
