package org.example.babenkopogoda;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

@Getter
@Setter
@Log

public class weatherInfo {
    public cord coord;
    public weatherDesc[] weather;
    public String base;
    public mainWeather main;
    public int visibility;
    public wind wind;
    public clouds clouds;
    public long dt;
    public sys sys;
    public int timezone;
    public int id;
    public String name;
    public int cod;

    public weatherInfo(cord coord, weatherDesc[] weather, String base, mainWeather main, int visibility, wind wind, clouds clouds, long dt, sys sys, int timezone, int id, String name, int cod) {
        this.coord = coord;
        this.weather = weather;
        this.base = base;
        this.main = main;
        this.visibility = visibility;
        this.wind = wind;
        this.clouds = clouds;
        this.dt = dt;
        this.sys = sys;
        this.timezone = timezone;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

}


