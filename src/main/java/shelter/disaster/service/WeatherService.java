package shelter.disaster.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import shelter.disaster.domain.weather.WeatherInfo;

import java.util.Map;


@Service
@Slf4j
public class WeatherService {

    private final String API_KEY = "19318cb65865407552d0831ae51d9afb"; // OpenWeatherMap API Key
    double latitude = 44.34;
    double longitude = 10.99;

    public Mono<WeatherInfo> getWeather() {
        WebClient webClient = WebClient.create("https://api.openweathermap.org/data/2.5/weather");

        Mono<WeatherInfo> weatherInfoMono = webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("lat", latitude)
                        .queryParam("lon", longitude)
                        .queryParam("appid", API_KEY)
                        .build())
                .retrieve()
                .bodyToMono(WeatherInfo.class);

        return weatherInfoMono;
    }
}