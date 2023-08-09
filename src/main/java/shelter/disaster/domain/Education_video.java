package shelter.disaster.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Education_video {

    @Id @GeneratedValue
    @Column(name = "education_video_id")
    private Long id;

    private String title;

    private String disaster;

}
