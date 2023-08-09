package shelter.disaster.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import shelter.disaster.domain.Member;
import shelter.disaster.repository.MemberJpaRepository;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired
    MemberJpaRepository memberJpaRepository;


//    @Test
//    public void join() throws Exception {
//        //given
//        Member member = new Member("memberA", 12);
//
//        //when
//        Long savedId = memberService.join(member);
//
//        //then
//        assertEquals(member, memberJpaRepository.findOne(savedId));
//    }
//
//    @Test(expected = IllegalStateException.class)
//    public void duplication_member_exception() throws Exception {
//        //given
//        Member member1 = new Member("memberA", 12);
//
//        Member member2 = new Member("memberB", 22);
//
//        //when
//        memberService.join(member1);
//        memberService.join(member2); //예외가 발생해야 한다!
//
//        //then
//        fail("예외가 발생해야 한다.");
//    }

}