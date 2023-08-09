package shelter.disaster.domain.weather;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class Weather {
    private String main;
    private String icon;
}
