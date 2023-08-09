package shelter.disaster.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import shelter.disaster.domain.Shelter;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ShelterJpaRepository {

    private final EntityManager em;

    public List<Shelter> findAll() {
        return em.createQuery("select s from Shelter s ", Shelter.class)
                .getResultList();
    }

    public List<Shelter> findByLocation(double latitude, double longitude, double distance) {
        // 지정된 위도와 경도를 기준으로 일정 거리 내에 속해있는 Shelter를 찾는 JPQL 쿼리를 작성합니다.
        // ST_DISTANCE 함수는 MySQL과 같은 몇몇 데이터베이스에서 공간 관련 기능을 지원하는 함수입니다.
        // 주의: 사용하는 데이터베이스에 맞는 함수를 사용해야 합니다.
        String jpqlQuery = "SELECT s FROM Shelter s " +
                "WHERE FUNCTION('ST_DISTANCE', FUNCTION('POINT', s.longitude, s.latitude), FUNCTION('POINT', :longitude, :latitude)) <= :distanceInKilometers";

        TypedQuery<Shelter> query = em.createQuery(jpqlQuery, Shelter.class);
        query.setParameter("latitude", latitude);
        query.setParameter("longitude", longitude);
        query.setParameter("distanceInKilometers", distance);

        return query.getResultList();
    }
}
