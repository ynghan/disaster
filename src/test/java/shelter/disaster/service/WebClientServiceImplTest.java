package shelter.disaster.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Rollback(false)
class WebClientServiceImplTest {

    @Autowired private WebClientServiceImpl webClientService;

    @Test
    void get() {
        webClientService.get();
    }

    @Test
    void post() {webClientService.post();}
}