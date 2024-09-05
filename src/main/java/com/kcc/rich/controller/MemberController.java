package com.kcc.rich.controller;

import com.kcc.rich.auth.PrincipalDetail;
import com.kcc.rich.domain.member.MemberDto;
import com.kcc.rich.domain.member.MemberVO;
import com.kcc.rich.dto.UpdatedMemberInfoDTO;
import com.kcc.rich.service.member.MemberService;
import com.kcc.rich.util.jina.FileStore;
import com.kcc.rich.util.jina.UploadImage;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final FileStore fileStore;

    // DTO => VO로 변환
    private MemberVO dtoToVO(MemberDto memberDto) {
        MemberVO member = new MemberVO();
        member.setUsername(memberDto.getUsername());
        member.setPassword(memberDto.getPassword());
        member.setMember_name(memberDto.getMember_name());
        member.setMember_nick(memberDto.getMember_nick());
        member.setMember_address(memberDto.getMember_address());
        member.setMember_phone(memberDto.getMember_phone());
        member.setMember_img(memberDto.getFull_path());
        return member;
    }

    private MemberVO updateDtoToVO(MemberDto memberDto) {
        MemberVO member = new MemberVO();
        member.setUsername(memberDto.getUsername());
        member.setMember_nick(memberDto.getMember_nick());
        member.setMember_explain(memberDto.getMember_explain());
        member.setMember_address(memberDto.getMember_address());
        member.setMember_phone(memberDto.getMember_phone());
        member.setMember_img(memberDto.getFull_path());
        return member;
    }

    @GetMapping("/join")
    public String join(@ModelAttribute MemberDto memberDto) {
        return "members/join";
    }

    @PostMapping("/join")
    public String joinMember(@ModelAttribute("memberDto") @Valid MemberDto memberDto, BindingResult bindingResult, Model model) {
        MultipartFile file = memberDto.getMember_img();

        // 파일 업로드 여부 확인
        if (file == null || file.isEmpty()) {
            System.out.println("파일이 선택되지 않았습니다.");
            memberDto.setFull_path("/resources/img/members/profile.png"); // 기본 이미지 경로 설정
        } else {
            System.out.println("파일 이름: " + file.getOriginalFilename());
            System.out.println("파일 크기: " + file.getSize());
            // 파일이 있을 경우 업로드 처리
            UploadImage uploadImage = fileStore.storeFile(file);

            if (uploadImage == null) {
                System.out.println("파일 업로드 중 문제가 발생했습니다.");
                memberDto.setFull_path("/resources/img/members/profile.png"); // 업로드 실패 시 기본 이미지
            } else {
                memberDto.setFull_path(uploadImage.getFullPath());
            }
        }

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

        // 비밀번호 암호화
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
    public void login() {
    }

    @GetMapping("/confirm-myInfo")
    public String confirmMyInfo(@AuthenticationPrincipal PrincipalDetail principalDetail, Model model) {
        MemberVO loginMember = principalDetail.getMember();
        System.out.println(loginMember);
        int countReservation = memberService.countReservation(loginMember.getUsername());
        int countReview = memberService.countReview(loginMember.getUsername());
        UpdatedMemberInfoDTO memberImg = memberService.getMemberImg(loginMember.getUsername());
        String img = memberImg.getMember_img();

        System.out.println(memberImg.toString());

        loginMember.setMember_nick(memberImg.getMember_nick());

        System.out.println(loginMember);
        model.addAttribute("loginMember", loginMember);
        model.addAttribute("countReservation", countReservation);
        model.addAttribute("countReview", countReview);

        System.out.println("파일 이름 검사");
        String fileName =null;
        if(img == null || img.contains("profile.png") || "".equals(img)){
            fileName = "C:\\Users\\KOSA\\Desktop\\abv\\profile.png";
        }else{
            fileName = img;
        }
        System.out.println(fileName);

        model.addAttribute("fileName", fileName);

        return "members/confirmMyInfo";
    }

    @GetMapping("/update-info")
    public String updateMyInfo(@AuthenticationPrincipal PrincipalDetail principalDetail, Model model) {
        String username = principalDetail.getUsername();
        MemberVO loginMember = memberService.findByEmail(username);

        String memberImg = loginMember.getMember_img();
        int lastSlashIndex = memberImg.lastIndexOf('\\');
        //String fileName = (lastSlashIndex != -1) ? memberImg.substring(lastSlashIndex + 1) : memberImg;
        System.out.println("fileName = " + memberImg);

        model.addAttribute("fileName", memberImg);
        model.addAttribute("loginMember", loginMember);

        return "members/updateMyInfo";
    }

    @PostMapping("/update-info")
    public String updateInfo(@ModelAttribute("loginMember") MemberDto memberDto, @AuthenticationPrincipal PrincipalDetail principalDetail) {
        String username = principalDetail.getUsername();
        memberDto.setUsername(username);
        System.out.println("memberDto = " + memberDto);
        MultipartFile file = memberDto.getMember_img();

        if (file == null || file.isEmpty()) {
            System.out.println("파일이 선택되지 않았습니다.");
            memberDto.setFull_path("/resources/img/members/profile.png"); // 기본 이미지 경로 설정
        } else {
            System.out.println("파일 이름: " + file.getOriginalFilename());
            System.out.println("파일 크기: " + file.getSize());
            // 파일이 있을 경우 업로드 처리
            UploadImage uploadImage = fileStore.storeFile(file);
            System.out.println("uploadImage = " + uploadImage);
            if (uploadImage == null) {
                System.out.println("파일 업로드 중 문제가 발생했습니다.");
                memberDto.setFull_path("/resources/img/members/profile.png"); // 업로드 실패 시 기본 이미지
            } else {
                memberDto.setFull_path(uploadImage.getFullPath());
            }
        }
        System.out.println("memberDto = " + memberDto);
        System.out.println("updateDtoToVO(memberDto) = " + updateDtoToVO(memberDto));
        memberService.updateInfo(updateDtoToVO(memberDto));
        return "redirect:/members/confirm-myInfo";
    }


}