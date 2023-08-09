package shelter.disaster.controller;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.httpclient.HttpConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import shelter.disaster.domain.weather.MainInfo;
import shelter.disaster.domain.weather.Weather;
import shelter.disaster.domain.weather.WeatherInfo;
import shelter.disaster.service.WeatherService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/get-weather")
    public WeatherResponse getWeather() {
        double latitude = 44.34;
        double longitude = 10.99;

        WeatherInfo weatherInfo = weatherService.getWeather(latitude, longitude);

        return new WeatherResponse(weatherInfo.getWeather().get(0).getIcon(), weatherInfo.getWeather().get(0).getMain(), weatherInfo.getMain().getTemp());
//        return weatherInfoMono.map(weatherInfo -> new WeatherResponse(weatherInfo.getWeather().get(0).getIcon(), weatherInfo.getWeather().get(0).getMain(), weatherInfo.getMain().getTemp()));
    }

    @Data
    @AllArgsConstructor
    static class WeatherResponse {
        private String icon;
        private String main;
        private double temp;

    }


}

