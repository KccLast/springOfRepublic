package com.kcc.rich.service.member;

import com.kcc.rich.domain.member.MemberVO;
import com.kcc.rich.dto.UpdatedMemberInfoDTO;

import java.lang.reflect.Member;

public interface MemberService {
    public void join(MemberVO member);
    public MemberVO login(String username, String password);
    public int checkEmailExist(String username);
    public boolean findMember(String member_name, String username);
    public MemberVO findByEmail(String username);
    public int countReservation(String username);
    public int countReview(String username);
    public void updateInfo(MemberVO member);

    UpdatedMemberInfoDTO getMemberImg(String memberId);
}
