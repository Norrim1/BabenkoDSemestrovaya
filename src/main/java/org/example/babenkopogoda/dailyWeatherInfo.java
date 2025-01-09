package org.example.babenkopogoda;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class dailyWeatherInfo {

    public long dt;
    public temp main;
    public weatherDesc[] weather;
    public clouds clouds;
    public wind wind;
    public int visibility;
    public double pop;
    public rain rain;
    public dailySys sys;
    public String dt_txt;

    public dailyWeatherInfo(long dt, temp main, weatherDesc[] weather, org.example.babenkopogoda.clouds clouds, org.example.babenkopogoda.wind wind, int visibility, double pop, org.example.babenkopogoda.rain rain, dailySys sys, String dt_txt) {
        this.dt = dt;
        this.main = main;
        this.weather = weather;
        this.clouds = clouds;
        this.wind = wind;
        this.visibility = visibility;
        this.pop = pop;
        this.rain = rain;
        this.sys = sys;
        this.dt_txt = dt_txt;
    }
}
