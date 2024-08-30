package com.kcc.rich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
    @GetMapping("/members/join")
    public String join() {
        return "members/join";
    }

    @GetMapping("/members/login")
    public void login() {}

    @GetMapping("/members/find-pwd")
    public String findPwd() {
        return "members/findPwd";
    }

    @GetMapping("/members/change-pwd")
    public String changePwd() {
        return "members/changePwd";
    }

}