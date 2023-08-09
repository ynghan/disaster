package shelter.disaster.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ApiController {


    @GetMapping("/api/get")
    public ResponseEntity<Map<String, Object>> handleApiGet() {
        // 여기에 요청을 처리하는 로직을 추가
        // 예시로 응답 메시지를 생성
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("message", "GET request handled successfully");

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @PostMapping("/api/post")
    public ResponseEntity<Map<String, Object>> handleApiPost(@RequestBody Map<String, Object> requestBody) {
        // 여기에 요청을 처리하는 로직을 추가
        // requestBody를 사용하여 원하는 동작을 수행

        // 예시로 응답 메시지를 생성
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("message", "API request handled successfully");

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }
}
