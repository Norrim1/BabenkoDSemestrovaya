package org.example.babenkopogoda;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

@Getter
@Setter
@Log

public class cord {
    public Float lon;
    public Float lat;

    public cord(Float newLon, Float newLat)
    {
        lon = newLon;
        lat = newLat;
    }

}
