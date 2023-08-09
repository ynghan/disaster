package shelter.disaster.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shelter.disaster.domain.Member;
import shelter.disaster.domain.Volunteer;
import shelter.disaster.repository.VolunteerRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class VolunteerService {

    private final VolunteerRepository volunteerRepository;

    @Transactional
    public void saveVolunteer(Volunteer volunteer) {
        volunteerRepository.save(volunteer);
    }

    public List<Volunteer> findAllVolunteers() {
        return volunteerRepository.findAll();
    }

    public List<Volunteer> findVolunteersByMember(Member member) {
        return volunteerRepository.findByMember(member);
    }


}
