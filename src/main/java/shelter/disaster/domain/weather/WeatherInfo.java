package shelter.disaster.domain.weather;

import lombok.Data;

import javax.persistence.Entity;
import java.util.List;

@Data
public class WeatherInfo {
    private List<Current> currents;
    private List<Hourly> hourlies;
}
