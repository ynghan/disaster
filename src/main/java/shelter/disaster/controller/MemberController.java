package shelter.disaster.controller;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import shelter.disaster.domain.Member;
import shelter.disaster.service.MemberService;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;


    @GetMapping("/api/v1/members")
    public List<Member> membersV1() { return memberService.findMembers();}

    @GetMapping("/api/v2/members")
    public Result<MemberDto> membersV2() {
        List<Member> findMembers = memberService.findMembers();

        List<MemberDto> collect = findMembers.stream().map(m -> new MemberDto(m.getName(), m.getAge())).collect(Collectors.toList());

        return new Result(collect);
    }

    @PostMapping("/api/v2/members")
    public CreateMemberResponse membersV2(@RequestBody @Valid CreateMemberRequest request) {
        Member member = new Member(request.getName(), request.getAge());
        memberService.join(member);
        return new CreateMemberResponse(request.getName(), request.getAge());
    }

    @Data
    static class CreateMemberRequest {
        private String name;
        private int age;
    }

    @Data
    static class CreateMemberResponse {
        private Long id;
        private String name;
        private int age;

        public CreateMemberResponse(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }


    @Data
    @AllArgsConstructor
    static class MemberDto {

        private String name;
        private int age;

    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
    }
}
