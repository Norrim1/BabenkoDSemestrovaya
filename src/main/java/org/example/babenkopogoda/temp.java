package org.example.babenkopogoda;

import lombok.Getter;
import lombok.Setter;

public class temp {
    @Getter @Setter public double temp;
    @Getter @Setter public double feels_like;
    @Getter @Setter public double temp_min;
    @Getter @Setter public double temp_max;
    @Getter @Setter public int pressure;
    @Getter @Setter public int sea_level;
    @Getter @Setter public int grnd_level;
    @Getter @Setter public int humidity;
    @Getter @Setter public double temp_kf;


    public temp(double temp, double feels_like, double temp_min, double temp_max, int pressure, int sea_level, int grnd_level, int humidity, double temp_kf) {
        this.temp = temp;
        this.feels_like = feels_like;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.pressure = pressure;
        this.sea_level = sea_level;
        this.grnd_level = grnd_level;
        this.humidity = humidity;
        this.temp_kf = temp_kf;
    }
}
