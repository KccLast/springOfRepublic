package com.kcc.rich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
    @GetMapping("/members/join")
    public String join() {
        return "members/join";  // home.jsp를 가리킴
    }
}