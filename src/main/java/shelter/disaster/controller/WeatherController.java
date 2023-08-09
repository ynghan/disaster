package shelter.disaster.controller;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import shelter.disaster.domain.weather.WeatherInfo;
import shelter.disaster.service.WeatherService;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/get-weather")
    public List<WeatherResponse> getWeather() {
        double latitude = 44.34;
        double longitude = 10.99;

        List<WeatherResponse> weatherResponses = new ArrayList<>();

        List<WeatherInfo> weatherInfo = weatherService.getWeather(latitude, longitude);


        for (WeatherInfo info : weatherInfo) {

            String curr_icon = info.getCurrents().get(0).getWeathers().get(0).getIcon();
            String curr_main = info.getCurrents().get(0).getWeathers().get(0).getMain();
            double curr_temp = info.getCurrents().get(0).getTemp();

            String hour_icon = info.getHourlies().get(0).getWeathers().get(0).getIcon();
            String hour_main = info.getHourlies().get(0).getWeathers().get(0).getMain();
            double hour_temp = info.getHourlies().get(0).getTemp();

            WeatherResponse weatherResponse = new WeatherResponse(curr_icon, curr_main, curr_temp, hour_icon, hour_main, hour_temp);
            weatherResponses.add(weatherResponse);

        }

        return weatherResponses;
    }

    @Data
    @AllArgsConstructor
    static class WeatherResponse {
        private String curr_icon;
        private String curr_main;
        private double curr_temp;

        private String hour_icon;
        private String hour_main;
        private double hour_temp;

    }

}

//        WeatherInfo weatherInfo = weatherService.getWeather(latitude, longitude);
//        String icon = weatherInfo.getWeather().get(0).getIcon();
//        String main = weatherInfo.getWeather().get(0).getMain();
//        double temp = weatherInfo.getMain().getTemp()
//
//        return new WeatherResponse(icon, main, temp);
//        return weatherInfoMono.map(weatherInfo -> new WeatherResponse(weatherInfo.getWeather().get(0).getIcon(), weatherInfo.getWeather().get(0).getMain(), weatherInfo.getMain().getTemp()));
//    }