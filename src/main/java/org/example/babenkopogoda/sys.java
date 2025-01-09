package org.example.babenkopogoda;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

@Getter
@Setter
@Log

public class sys {
    public String country;
    public long sunrise;
    public long sunset;

    public sys(final String country,final long sunrise,final long sunset) {
        this.country = country;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

}
