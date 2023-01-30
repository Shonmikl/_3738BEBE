package _30_01_2023.mockClasses.reactor;

import lombok.Setter;

public class Sensor {
    @Setter
    private boolean blocked;

    public boolean isBlocked() {
        return blocked;
    }
}