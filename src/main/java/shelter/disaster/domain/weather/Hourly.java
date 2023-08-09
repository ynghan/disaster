package shelter.disaster.domain.weather;

import lombok.Data;

import java.util.List;

@Data
public class Hourly {

    private List<Weather> weathers;
    private double temp;

}
