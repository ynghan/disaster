package shelter.disaster.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shelter.disaster.domain.Shelter;
import shelter.disaster.repository.ShelterRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ShelterService {

    private final ShelterRepository shelterRepository;

    //대피소 조회(조건:거리,위도,경도)
//    public List<Shelter> findByLocation(double latitude, double longitude, double distance) {
//        return shelterRepository.findByLocation(latitude, longitude, distance);
//    }

    public List<Shelter> findAll() {
        return shelterRepository.findAll();
    }
}
