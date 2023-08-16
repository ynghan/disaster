package shelter.disaster.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import shelter.disaster.domain.shelter.DistanceCalculator;
import shelter.disaster.domain.shelter.Shelter;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.ArrayList;
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
        List<Shelter> allShelters = findAll();// 모든 대피소 가져오는 로직

        List<Shelter> sheltersWithinDistance = new ArrayList<>();
        for (Shelter shelter : allShelters) {
            double shelterDistance = DistanceCalculator.haversineDistance(
                    shelter.getLatitude().doubleValue(), shelter.getLongitude().doubleValue(),
                    latitude, longitude);

            if (shelterDistance <= distance) {
                sheltersWithinDistance.add(shelter);
            }
        }

        return sheltersWithinDistance;
    }

}
