package shelter.disaster.controller;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import shelter.disaster.domain.weather.Current;
import shelter.disaster.domain.weather.Hourly;
import shelter.disaster.domain.weather.Weather;
import shelter.disaster.domain.weather.WeatherInfo;
import shelter.disaster.service.WeatherService;


@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;


    @GetMapping("/get-weather")
    public WeatherResponse getWeather() {
        WeatherInfo weatherInfo = weatherService.getWeather().block(); // block() is used for simplicity; consider reactive alternatives

        if (weatherInfo != null
                && weatherInfo.getCurrents() != null
                && !weatherInfo.getCurrents().isEmpty()
                && weatherInfo.getCurrents().get(0).getWeathers() != null
                && !weatherInfo.getCurrents().get(0).getWeathers().isEmpty()) {

            Current current = weatherInfo.getCurrents().get(0);
            Weather currentWeather = current.getWeathers().get(0);

            Hourly hourly = weatherInfo.getHourlies().get(0);
            Weather hourlyWeather = hourly.getWeathers().get(0);

            return new WeatherResponse(
                    currentWeather.getIcon(),
                    currentWeather.getMain(),
                    current.getTemp(),
                    hourlyWeather.getIcon(),
                    hourlyWeather.getMain(),
                    hourly.getTemp()
            );
        } else {
            // Handle the case where data is missing or incomplete
            return new WeatherResponse("defaultIcon", "defaultMain", 0, "defaultIcon", "defaultMain", 0);
        }
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
