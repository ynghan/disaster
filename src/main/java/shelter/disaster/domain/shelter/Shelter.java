package shelter.disaster.domain.shelter;


import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Entity
@Getter
public class Shelter {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shelter_id")
    private Long id;


    @Column(columnDefinition = "DECIMAL(10,7)")
    private BigDecimal latitude;

    @Column(columnDefinition = "DECIMAL(10,7)")
    private BigDecimal longitude;

    private String address;

    private String capacity;

    private String disaster;

    private String area_code;
}
