package org.example.babenkopogoda;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

@Getter
@Setter
@Log

public class clouds {
    public int all;

    public clouds(int all) {
        this.all = all;
    }

}
