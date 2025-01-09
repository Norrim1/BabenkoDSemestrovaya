package org.example.babenkopogoda;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

@Getter
@Setter
@Log

public class wind {
    public double speed;
    public int deg;
    public double gust;

    public wind(double speed, int deg, double gust) {
        this.speed = speed;
        this.deg = deg;
        this.gust = gust;
    }

}
