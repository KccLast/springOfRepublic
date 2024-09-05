package com.kcc.rich.mapper.member;


import com.kcc.rich.domain.member.MemberVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;


@Mapper
public interface MemberMapper {
    public void insertMember(MemberVO member);
    public MemberVO loginMember(@RequestParam String username, @RequestParam String password);
    public int checkEmailExists(String username);
    public boolean findPwd(String member_name, String username);
    public MemberVO findByEmail(String username);
    public int countReservation(String username);
    public int countReview(String username);
    public void updateInfo(MemberVO member);
}
