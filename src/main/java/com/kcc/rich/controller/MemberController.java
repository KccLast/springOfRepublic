package com.kcc.rich.controller;


import com.kcc.rich.domain.member.MemberDto;
import com.kcc.rich.domain.member.MemberVO;
import com.kcc.rich.service.member.MemberService;
import com.kcc.rich.service.member.MemberServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    // DTO => VO로 변환
    private MemberVO dtoToVO(MemberDto memberDto) {
        MemberVO member = new MemberVO();
        member.setUsername(memberDto.getUsername());
        member.setPassword(memberDto.getPassword());
        member.setMember_name(memberDto.getMember_name());
        member.setMember_nick(memberDto.getMember_nick());
        member.setMember_address(memberDto.getMember_address());
        member.setMember_phone(memberDto.getMember_phone());

        return member;
    }

    @GetMapping("/join")
    public String join(@ModelAttribute MemberDto memberDto) {
        return "members/join";
    }

    @PostMapping("/join")
    public String joinMember(@Valid MemberDto memberDto, BindingResult bindingResult, Model model) {
        // 비밀번호와 비밀번호 확인 일치 확인
        if (!memberDto.getPassword().equals(memberDto.getPassword_confirm())) {
            bindingResult.rejectValue("password_confirm", "passwordMismatch", "비밀번호가 일치하지 않습니다.");
        }

        if (bindingResult.hasErrors()) {
            // 유효성 검사 실패
            model.addAttribute("memberDto", memberDto);

            for (FieldError error : bindingResult.getFieldErrors()) {
                System.out.println("valid_" + error.getField() + " " + error.getDefaultMessage());
            }

            return "members/join";
        }

        String rawPassword = memberDto.getPassword();
        String encryptedPassword = bCryptPasswordEncoder.encode(rawPassword);
        memberDto.setPassword(encryptedPassword);

        memberService.join(dtoToVO(memberDto));

        return "members/login";
    }

    @GetMapping("/{email}")
    @ResponseBody
    public int findMember(@PathVariable String email) {
        return memberService.checkEmailExist(email);
    }

    @GetMapping("/login")
    public void login() {}

//    @PostMapping("/login")
//    public String loginMember(@RequestParam String username, @RequestParam String password, Model model) {
////        try {
////            boolean loginSuccess = memberServiceImpl.login(username, password);
////            System.out.println(loginSuccess);
////            if (loginSuccess) {
////                System.out.println("로그인 성공");
////                model.addAttribute("email", username);
////                return "redirect:/members/join";
////            } else {
////                System.out.println("로그인 실패");
////                return "redirect:/members/login";
////            }
////        } catch (Exception e) {
////            System.out.println("a");
////            model.addAttribute("error", e.getMessage());
////            return "members/login";
////        }
//        return "login";
//    }

    @GetMapping("/find-pwd")
    public String findPwd() {
        return "members/findPwd";
    }

    @PostMapping("/find-pwd")
    public boolean findMemberByPwd(String member_name, String username) {
        return memberService.findMember(member_name, username);
    }

    @GetMapping("/change-pwd")
    public String changePwd() {
        return "members/changePwd";
    }

    @GetMapping("/confirm-myInfo")
    public String confirmMyInfo() {
        return "members/confirmMyInfo";
    }

    @GetMapping("/update-info")
    public String updateMyInfo() {
        return "members/updateMyInfo";
    }

}