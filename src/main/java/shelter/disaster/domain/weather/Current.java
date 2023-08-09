package shelter.disaster.domain.weather;

import lombok.Data;

import java.util.List;


@Data
public class Current {
    private List<Weather> weathers;
    private double temp;
}
