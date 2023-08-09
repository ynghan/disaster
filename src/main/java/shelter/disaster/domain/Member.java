package shelter.disaster.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;

    private int age;

    private String sex;

    private String social_security_number;

    private String address;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Member(String name, int age, String sex, String social_security_number, String address) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.social_security_number = social_security_number;
        this.address = address;
    }

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<Member_has_Volunteer> member_has_volunteers = new ArrayList<>();

    public void addMember_has_Volunteer(Member_has_Volunteer member_has_volunteer) {
        member_has_volunteers.add(member_has_volunteer);
        member_has_volunteer.setMember(this);
    }

    /**
     * 봉사팀 취소 ::
     */

}
