package shelter.disaster.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import shelter.disaster.domain.weather.WeatherInfo;

@Service
public class WeatherService {

    private final String API_KEY = "19318cb65865407552d0831ae51d9afb"; // OpenWeatherMap API Key

    public WeatherInfo getWeather(double latitude, double longitude) {
        WebClient webClient = WebClient.create("https://api.openweathermap.org/data/2.5/weather");

        WeatherInfo weatherInfo = webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("lat", latitude)
                        .queryParam("lon", longitude)
                        .queryParam("appid", API_KEY)
                        .build())
                .retrieve()
                .bodyToMono(WeatherInfo.class)
                .block();

        return weatherInfo;
    }
}