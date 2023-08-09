package shelter.disaster.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import shelter.disaster.domain.Member;
import shelter.disaster.domain.Volunteer;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class VolunteerRepository {

    private final EntityManager em;

    //Volunteer 등록
    public void save(Volunteer volunteer) {
        if(volunteer.getId() == null) {
            em.persist(volunteer);
        } else {
            em.merge(volunteer);
        }
    }

    //모든 Volunteer 조회
    public List<Volunteer> findAll() {
        return em.createQuery("select v from Volunteer v", Volunteer.class)
                .getResultList();
    }

    //Member 엔티티가 속한 Volunteer 엔티티 조회
    public List<Volunteer> findByMember(Member member) {
        String jpqlQuery = "SELECT v FROM Volunteer v " +
                "JOIN FETCH v.member_has_volunteers mhv " +
                "WHERE mhv.member = :member";

        TypedQuery<Volunteer> query = em.createQuery(jpqlQuery, Volunteer.class);
        query.setParameter("member", member);

        return query.getResultList();
    }
}
