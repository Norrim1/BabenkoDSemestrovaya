package org.example.babenkopogoda;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

public class rain {
    @Getter @Setter
    @SerializedName("3h")
    public double h;

    public rain(double h) {

        this.h = h;
    }
}
