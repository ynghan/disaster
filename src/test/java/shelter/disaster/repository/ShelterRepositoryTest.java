package shelter.disaster.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import shelter.disaster.domain.shelter.Shelter;

import javax.transaction.Transactional;

import java.util.List;

@SpringBootTest
@Transactional

class ShelterRepositoryTest {

    @Autowired ShelterRepository shelterRepository;


    @Test
    public void testShelter() {

        List<Shelter> all = shelterRepository.findAll();

    }

}