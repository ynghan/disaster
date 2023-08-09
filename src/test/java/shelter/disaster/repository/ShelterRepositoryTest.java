package shelter.disaster.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import shelter.disaster.domain.Shelter;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional

class ShelterRepositoryTest {

    @Autowired ShelterRepository shelterRepository;


    @Test
    public void testShelter() {

        List<Shelter> all = shelterRepository.findAll();

    }

}