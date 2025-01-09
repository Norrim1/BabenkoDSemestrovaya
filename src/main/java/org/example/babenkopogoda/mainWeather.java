package org.example.babenkopogoda;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

@Getter
@Setter
@Log

public class mainWeather {
    @Getter @Setter public double temp;
    @Getter @Setter public double feels_like;
    @Getter @Setter public double temp_min;
    @Getter @Setter public double temp_max;
    @Getter @Setter public int pressure;
    @Getter @Setter public int humidity;
    @Getter @Setter public int seaLevel;
    @Getter @Setter public int groundLevel;

    public mainWeather(double temp, double feels_like, double temp_min, double temp_max, int pressure, int humidity, int seaLevel, int groundLevel) {
        this.temp = temp;
        this.feels_like = feels_like;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.pressure = pressure;
        this.humidity = humidity;
        this.seaLevel = seaLevel;
        this.groundLevel = groundLevel;
    }

    public void temperature()
    {System.out.println(temp);
    }

}
