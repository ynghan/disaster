package shelter.disaster.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import shelter.disaster.domain.Member;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
class MemberRepositoryTest {


    @Autowired MemberRepository memberRepository;

//    @Test
//    public void testMember() {
//        Member member = new Member("memberA", 20);
//        Member savedMember = memberRepository.save(member);
//        Member findMember = memberRepository.findById(savedMember.getId()).get();
//
//        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
//    }
}