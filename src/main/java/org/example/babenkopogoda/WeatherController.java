package org.example.babenkopogoda;

import com.jfoenix.controls.JFXAutoCompletePopup;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.control.Label;

import com.google.gson.Gson;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.controlsfx.control.textfield.TextFields;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.*;
import java.util.*;


public class    WeatherController {
    @FXML
    private TextField searchField;

    @FXML
    private Button searchButton;

    @FXML
    private Label MedianTempLabel;

    @FXML
    private Label MaxTempLabel;

    @FXML
    private Label MinTempLabel;

    @FXML
    private Label FeelTempLabel;

    @FXML
    private Label WindSpeedLabel;

    @FXML
    private Label WindDirectionLabel;

    @FXML
    private Label HumidityLabel;

    @FXML
    private Label CloudinessLabel;

    @FXML
    private Label PressureLabel;

    @FXML
    private Label PrecipitationLabel;

    @FXML
    private ImageView Icon;
    @FXML
    private ImageView Icon1;
    @FXML
    private ImageView Icon2;
    @FXML
    private ImageView Icon3;
    @FXML
    private ImageView Icon4;
    @FXML
    private Label Max1;
    @FXML
    private Label Max2;
    @FXML
    private Label Max3;
    @FXML
    private Label Max4;
    @FXML
    private Label Min1;
    @FXML
    private Label Min2;
    @FXML
    private Label Min3;
    @FXML
    private Label Min4;
    @FXML
    private Label Mid1;
    @FXML
    private Label Mid2;
    @FXML
    private Label Mid3;
    @FXML
    private Label Mid4;
    @FXML
    private Label Status1;
    @FXML
    private Label Status2;
    @FXML
    private Label Status3;
    @FXML
    private Label Status4;
    @FXML
    private Label cityName;


    public String convertDegreeToCardinalDirection(int directionInDegrees) {
        String cardinalDirection = null;
        if ((directionInDegrees >= 326.25) && (directionInDegrees <= 360) ||
                (directionInDegrees >= 0) && (directionInDegrees <= 33.75)) {
            cardinalDirection = "North";
        } else if ((directionInDegrees >= 33.75) && (directionInDegrees <= 56.25)) {
            cardinalDirection = "North-East";
        } else if ((directionInDegrees >= 56.25) && (directionInDegrees <= 123.75)) {
            cardinalDirection = "East";
        } else if ((directionInDegrees >= 123.75) && (directionInDegrees <= 146.25)) {
            cardinalDirection = "South-East";
        } else if ((directionInDegrees >= 146.25) && (directionInDegrees <= 213.75)) {
            cardinalDirection = "South";
        } else if ((directionInDegrees >= 213.75) && (directionInDegrees <= 236.25)) {
            cardinalDirection = "South-West";
        } else if ((directionInDegrees >= 236.255) && (directionInDegrees <= 303.75)) {
            cardinalDirection = "West";
        } else if ((directionInDegrees >= 303.75) && (directionInDegrees <= 326.25)) {
            cardinalDirection = "North-West";
        } else {
            cardinalDirection = "?";
        }

        return cardinalDirection;
    }

    public void findAndSet(String something) throws IOException, InterruptedException {
        String buildRequestBuffer = "https://api.openweathermap.org/data/2.5/weather?q=" + something + "&appid=1f1844ca48e868f68b02b7a76bff37c9";
        String buildRequest = buildRequestBuffer.replaceAll(" ", "");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(buildRequest))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        String responseString = response.body();
        Gson gson = new Gson();
        weatherInfo currentWeatherInfo = gson.fromJson(responseString, weatherInfo.class);
        try{MedianTempLabel.setText(String.valueOf((int) currentWeatherInfo.main.temp - 273) + "C°");
        MaxTempLabel.setText(String.valueOf((int) currentWeatherInfo.main.temp_max - 273) + "C°");
        MinTempLabel.setText(String.valueOf((int) currentWeatherInfo.main.temp_min - 273) + "C°");
        FeelTempLabel.setText(String.valueOf((int) currentWeatherInfo.main.feels_like - 273) + "C°");
        WindSpeedLabel.setText(String.valueOf((int) currentWeatherInfo.wind.speed) + "M/S");
        WindDirectionLabel.setText(convertDegreeToCardinalDirection(currentWeatherInfo.wind.deg));
        HumidityLabel.setText(String.valueOf((int) currentWeatherInfo.main.humidity));
        PressureLabel.setText(String.valueOf(currentWeatherInfo.main.pressure));
        CloudinessLabel.setText(currentWeatherInfo.weather[0].description);
        PrecipitationLabel.setText(String.valueOf(currentWeatherInfo.clouds.all));
        System.out.println(currentWeatherInfo.weather[0].icon + ".png");
        File file = new File("Icons/" + currentWeatherInfo.weather[0].icon + ".png");
        Image image = new Image(file.toURI().toString());
        Icon.setImage(image);
        String buildRequestDailyBuffer = "https://api.openweathermap.org/data/2.5/forecast?q=" + something + "&appid=1f1844ca48e868f68b02b7a76bff37c9";
        String buildRequestDaily = buildRequestDailyBuffer.replaceAll(" " , "");
        HttpRequest requestDaily = HttpRequest.newBuilder()
                .uri(URI.create(buildRequestDaily))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> responseDaily = HttpClient.newHttpClient().send(requestDaily, HttpResponse.BodyHandlers.ofString());
        System.out.println(responseDaily.body());
        String responseDailyString = responseDaily.body();
        dailyWeather currentDailyWeatherInfo = gson.fromJson(responseDailyString, dailyWeather.class);
        Status1.setText(currentDailyWeatherInfo.daily1_status());
        Status2.setText(currentDailyWeatherInfo.daily2_status());
        Status3.setText(currentDailyWeatherInfo.daily3_status());
        Status4.setText(currentDailyWeatherInfo.daily4_status());
        Mid1.setText(String.valueOf(currentDailyWeatherInfo.daily1_temp()));
        Mid2.setText(String.valueOf(currentDailyWeatherInfo.daily2_temp()));
        Mid3.setText(String.valueOf(currentDailyWeatherInfo.daily3_temp()));
        Mid4.setText(String.valueOf(currentDailyWeatherInfo.daily4_temp()));
        Max1.setText(String.valueOf(currentDailyWeatherInfo.daily1_max_temp()));
        Max2.setText(String.valueOf(currentDailyWeatherInfo.daily2_max_temp()));
        Max3.setText(String.valueOf(currentDailyWeatherInfo.daily3_max_temp()));
        Max4.setText(String.valueOf(currentDailyWeatherInfo.daily4_max_temp()));
        Min1.setText(String.valueOf(currentDailyWeatherInfo.daily1_min_temp()));
        Min2.setText(String.valueOf(currentDailyWeatherInfo.daily2_min_temp()));
        Min3.setText(String.valueOf(currentDailyWeatherInfo.daily3_min_temp()));
        Min4.setText(String.valueOf(currentDailyWeatherInfo.daily4_min_temp()));
        File file1 = new File("Icons/" + currentDailyWeatherInfo.list[8].weather[0].icon + ".png");
        Image image1 = new Image(file1.toURI().toString());
        Icon1.setImage(image1);
        File file2 = new File("Icons/" + currentDailyWeatherInfo.list[16].weather[0].icon + ".png");
        Image image2 = new Image(file2.toURI().toString());
        Icon2.setImage(image2);
        File file3 = new File("Icons/" + currentDailyWeatherInfo.list[24].weather[0].icon + ".png");
        Image image3 = new Image(file3.toURI().toString());
        Icon3.setImage(image3);
        File file4 = new File("Icons/" + currentDailyWeatherInfo.list[32].weather[0].icon + ".png");
        Image image4 = new Image(file4.toURI().toString());
        Icon4.setImage(image4);
            cityName.setText(something);} catch (NullPointerException error){
            cityName.setText("City not found");
        }
    }

    public String getFromDatabase() throws SQLException {
        TimeZone timeZone = TimeZone.getTimeZone("Russia/Novosibirsk");
        TimeZone.setDefault(timeZone);
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@82.179.14.185:1521:nmics", "STUD15", "STUD15");
        if (connection != null) {
            System.out.println("Connected with connection #1");
        }
        assert connection != null;
        Statement statement = connection.createStatement();
        statement.execute("SELECT * FROM CITY");
        ResultSet result = statement.getResultSet();
        result.next();
        String cityName = result.getString(1);
        System.out.println(cityName);
        connection.close();
        return cityName;
    }

    public void setDatabase(String something) throws SQLException {
        TimeZone timeZone = TimeZone.getTimeZone("Russia/Novosibirsk");
        TimeZone.setDefault(timeZone);
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@82.179.14.185:1521:nmics", "STUD15", "STUD15");
        if (connection != null) {
            System.out.println("Connected with connection #1");
        }
        assert connection != null;
        Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM CITY");
        statement.executeUpdate("INSERT INTO CITY VALUES('"+something+"')");
        connection.close();
    }

    public void initialize() throws SQLException, IOException, InterruptedException {
        findAndSet(getFromDatabase());
        cityName.setText(getFromDatabase());
    }

    String something;

    public void submit(ActionEvent event) throws IOException, InterruptedException, SQLException {
        something = searchField.getText();
        System.out.println(something);
        findAndSet(something);
        setDatabase(something);

    }
}
