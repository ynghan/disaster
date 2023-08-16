package shelter.disaster.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shelter.disaster.domain.shelter.Shelter;
import shelter.disaster.repository.ShelterJpaRepository;
import shelter.disaster.repository.ShelterRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ShelterService {

    private final ShelterRepository shelterRepository;
    private final ShelterJpaRepository shelterJpaRepository;


    //대피소 조회(조건:거리,위도,경도)
//    public List<Shelter> findByLocation(double latitude, double longitude, double distance) {
//        return shelterRepository.findByLocation(latitude, longitude, distance);
//    }

    public List<Shelter> findAll() {
        return shelterRepository.findAll();
    }

    public List<Shelter> findByLocation(double latitude, double longitude, double distance) {

        return shelterJpaRepository.findByLocation(latitude, longitude, distance);

    }
}
