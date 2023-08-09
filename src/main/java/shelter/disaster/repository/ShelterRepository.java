package shelter.disaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shelter.disaster.domain.Shelter;

import java.util.List;

public interface ShelterRepository extends JpaRepository<Shelter, Long> {

    @Override
    List<Shelter> findAll();

}
