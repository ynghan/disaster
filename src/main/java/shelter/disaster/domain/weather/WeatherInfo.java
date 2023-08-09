package shelter.disaster.domain.weather;

import lombok.Data;

import javax.persistence.Entity;
import java.util.List;

@Data
public class WeatherInfo {
    private MainInfo main;
    private List<Weather> weather;
}
