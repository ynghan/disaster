package shelter.disaster.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Member_has_Volunteer {

    @Id @GeneratedValue
    @Column(name = "member_has_volunteer_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "volunteer_id")
    private Volunteer volunteer;

    /**
     * 봉사 회원 생성
     */


    /**
     * 봉사 회원 등록
     */
    public void registerMember_has_Volunteer(Member member) {
        Member_has_Volunteer member_has_volunteer = new Member_has_Volunteer();
        member_has_volunteer.setMember(member);
    }

    public void cancle(){
    }

}
