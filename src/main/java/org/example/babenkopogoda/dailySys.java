package org.example.babenkopogoda;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class dailySys {
    public String pod;

    public dailySys(String pod) {
        this.pod = pod;
    }
}
