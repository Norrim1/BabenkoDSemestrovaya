package org.example.babenkopogoda;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class city {
    public int id;
    public String name;
    public cord coord;
    public String country;
    public int population;
    public int timezone;
    public long sunrise;
    public long sunset;

    public city(int id, String name, cord coord, String country, int population, int timezone, long sunrise, long sunset) {
        this.id = id;
        this.name = name;
        this.coord = coord;
        this.country = country;
        this.population = population;
        this.timezone = timezone;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }
}
