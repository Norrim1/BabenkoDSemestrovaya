package org.example.babenkopogoda;

import lombok.Getter;
import lombok.Setter;

import static java.lang.Math.max;
import static java.lang.Math.min;

@Setter
@Getter
public class dailyWeather {
    public String cod;
    public double message;
    public int cnt;
    public dailyWeatherInfo[] list;
    public city city;

    public dailyWeather(String cod, double message, int cnt, dailyWeatherInfo[] list, org.example.babenkopogoda.city city) {
        this.cod = cod;
        this.message = message;
        this.cnt = cnt;
        this.list = list;
        this.city = city;
    }

    public int daily1_temp()
    {
        return ((int) list[8].main.temp_max + (int)list[8].main.temp_min - 273 - 273)/2;
    }
    public int daily2_temp()
    {
        return ((int) list[16].main.temp_max + (int)list[16].main.temp_min - 273 - 273)/2;
    }
    public int daily3_temp()
    {
        return ((int) list[24].main.temp_max + (int)list[24].main.temp_min - 273 - 273)/2;
    }
    public int daily4_temp()
    {
        return ((int) list[32].main.temp_max + (int)list[32].main.temp_min - 273 - 273)/2;
    }
    public int daily1_max_temp()
    {
        return (int) max(max(max(list[8].main.temp_max - 273,list[9].main.temp_max - 273),max(list[10].main.temp_max - 273,list[11].main.temp_max - 273)),max(max(list[12].main.temp_max - 273,list[13].main.temp_max - 273),max(list[14].main.temp_max - 273,list[15].main.temp_max - 273))) ;
    }
    public int daily2_max_temp()
    {
        return (int) max(max(max(list[16].main.temp_max - 273,list[17].main.temp_max - 273),max(list[18].main.temp_max - 273,list[19].main.temp_max - 273)),max(max(list[20].main.temp_max - 273,list[21].main.temp_max - 273),max(list[22].main.temp_max - 273,list[23].main.temp_max - 273))) ;
    }
    public int daily3_max_temp()
    {
        return (int) max(max(max(list[24].main.temp_max - 273,list[25].main.temp_max - 273),max(list[26].main.temp_max - 273,list[27].main.temp_max - 273)),max(max(list[28].main.temp_max - 273,list[29].main.temp_max - 273),max(list[30].main.temp_max - 273,list[31].main.temp_max - 273))) ;
    }
    public int daily4_max_temp()
    {
        return (int) max(max(max(list[32].main.temp_max - 273,list[33].main.temp_max - 273),max(list[34].main.temp_max - 273,list[35].main.temp_max - 273)),max(max(list[36].main.temp_max - 273,list[37].main.temp_max - 273),max(list[38].main.temp_max - 273,list[39].main.temp_max - 273))) ;
    }
    public int daily1_min_temp()
    {
        return (int) min(min(min(list[8].main.temp_max - 273,list[9].main.temp_max - 273),min(list[10].main.temp_max - 273,list[11].main.temp_max - 273)),min(min(list[12].main.temp_max - 273,list[13].main.temp_max - 273),min(list[14].main.temp_max - 273,list[15].main.temp_max - 273))) ;
    }
    public int daily2_min_temp()
    {
        return (int) min(min(min(list[16].main.temp_max - 273,list[17].main.temp_max - 273),min(list[18].main.temp_max - 273,list[19].main.temp_max - 273)),min(min(list[20].main.temp_max - 273,list[21].main.temp_max - 273),min(list[22].main.temp_max - 273,list[23].main.temp_max - 273))) ;
    }
    public int daily3_min_temp()
    {
        return (int) min(min(min(list[24].main.temp_max - 273,list[25].main.temp_max - 273),min(list[26].main.temp_max - 273,list[27].main.temp_max - 273)),min(min(list[28].main.temp_max - 273,list[29].main.temp_max - 273),min(list[30].main.temp_max - 273,list[31].main.temp_max - 273))) ;
    }
    public int daily4_min_temp()
    {
        return (int) min(min(min(list[32].main.temp_max - 273,list[33].main.temp_max - 273),min(list[34].main.temp_max - 273,list[35].main.temp_max - 273)),min(min(list[36].main.temp_max - 273,list[37].main.temp_max - 273),min(list[38].main.temp_max - 273,list[39].main.temp_max - 273))) ;
    }
    public String daily1_status()
    {
        return list[8].weather[0].description;
    }
    public String daily2_status()
    {
        return list[16].weather[0].description;
    }
    public String daily3_status()
    {
        return list[24].weather[0].description;
    }public String daily4_status()
    {
        return list[32].weather[0].description;
    }



}
