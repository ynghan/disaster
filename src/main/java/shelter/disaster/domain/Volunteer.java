package shelter.disaster.domain;

import lombok.Getter;
import lombok.Setter;
import shelter.disaster.exception.NotEnoughPeopleNumException;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static shelter.disaster.domain.VolunteerStatus.END;

@Entity
@Getter @Setter
public class Volunteer {

    @Id @GeneratedValue
    @Column(name = "volunteer_id")
    private Long id;

    private String name;

    private LocalDateTime date;

    private String disaster;

    private int people_num;

    @Enumerated(EnumType.STRING)
    private VolunteerStatus status;

    @OneToMany(mappedBy = "volunteer", cascade = CascadeType.ALL)
    private List<Member_has_Volunteer> member_has_volunteers = new ArrayList<>();

    public void addMember_has_Volunteer(Member_has_Volunteer member_has_volunteer) {
        member_has_volunteers.add(member_has_volunteer);
        member_has_volunteer.setVolunteer(this);
    }

    //== 생성 메소드 ==//

    public Volunteer createVolunteer(String name, String disaster, int people_num) {
        Volunteer volunteer = new Volunteer();
        volunteer.setName(name);
        volunteer.setDate(LocalDateTime.now());
        volunteer.setDisaster(disaster);
        volunteer.setPeople_num(people_num);
        volunteer.setStatus(VolunteerStatus.ONGOING);

        return volunteer;
    }

    //== 비지니스 로직 ==//
    /**
     * 봉사팀 등록 :: Member_has_Volunteer 등록
     */
    public void ResisterMhV(Member_has_Volunteer... member_has_volunteers) {

        int restPeopleNum = this.people_num - 1;
        if(people_num < 0) {
            throw new NotEnoughPeopleNumException("need more people number");
        }
        this.people_num = restPeopleNum;

        for (Member_has_Volunteer member_has_volunteer : member_has_volunteers) {
            this.addMember_has_Volunteer(member_has_volunteer);
        }
    }

    /**
     * 봉사팀 취소 :: 인원 증가
     */
    public void cancle() {
        if(this.status == END) {
            throw new IllegalStateException("이미 끝난 모집입니다.");
        }
        for (Member_has_Volunteer member_has_volunteer : member_has_volunteers) {
            member_has_volunteer.cancle();
        }
    }




}
