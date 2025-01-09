package org.example.babenkopogoda;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

@Getter
@Setter
@Log

public class weatherDesc {
    @Getter @Setter public int id;
    @Getter @Setter public String main;
    @Getter @Setter public String description;
    @Getter @Setter public String icon;

    public weatherDesc(int id, String main, String description, String icon) {
        this.id = id;
        this.main = main;
        this.description = description;
        this.icon = icon;
    }

}
