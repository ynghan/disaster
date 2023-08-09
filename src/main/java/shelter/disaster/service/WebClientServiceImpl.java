package shelter.disaster.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import shelter.disaster.controller.ApiController;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class WebClientServiceImpl {
    public void getMultiple() {
        String code = "myCode";

        // webClient 기본 설정
        WebClient webClient =
                WebClient
                        .builder()
                        .baseUrl("https://api.openweathermap.org/data/2.5/weather")
                        .build();

        // api 요청 - 1
        Mono<Map> responseMono1 =
                webClient
                        .get()
                        .uri(uriBuilder ->
                                uriBuilder
                                        .path("/api/get")
                                        .queryParam("code", code)
                                        .build())
                        .retrieve()
                        .bodyToMono(Map.class);

        // api 요청 - 2
        Mono<Map> responseMono2 =
                webClient
                        .get()
                        .uri(uriBuilder ->
                                uriBuilder
                                        .path("/api/get")
                                        .queryParam("code", code)
                                        .build())
                        .retrieve()
                        .bodyToMono(Map.class);

        // multiple api 요청
        Map<String, Object> response =
                Mono
                        .zip(responseMono1, responseMono2, (response1, response2) -> {
                            Map<String, Object> map = new HashMap<>();
                            map.put("response1", response1);
                            map.put("response2", response2);

                            return map;
                        })
                        .block();

        // 결과 확인
        log.info(response.toString());
    }
}