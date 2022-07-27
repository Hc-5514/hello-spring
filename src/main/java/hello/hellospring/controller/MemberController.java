package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller // ComponentScan 방식
public class MemberController {

    private final MemberService memberService;

    // 불변성, 순환 참조 방지
    @Autowired // Dependency Injection: Controller - Service 연결
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
