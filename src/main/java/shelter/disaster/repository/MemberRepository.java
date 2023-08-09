package shelter.disaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import shelter.disaster.domain.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByName(@Param("name") String name);

    Member getById(@Param("id") Long id);

}
