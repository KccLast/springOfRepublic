package com.kcc.rich.service.member;

import com.kcc.rich.domain.member.MemberVO;

public interface MemberService {
    public void join(MemberVO member);
    public boolean login(String username, String password) throws Exception;
    public int checkEmailExist(String username);
    public boolean findMember(String member_name, String username);
    public MemberVO findByEmail(String username);
}
