package com.kcc.rich.service.member;

import com.kcc.rich.domain.member.MemberVO;
import com.kcc.rich.mapper.member.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberMapper mapper;

    @Override
    public void join(MemberVO member) {
        mapper.insertMember(member);
    }

    @Override
    public boolean login(String username, String password) throws Exception {
        MemberVO member = mapper.loginMember(username, password);
        System.out.println(member);
        if(member == null) {
            throw new Exception("존재하지 않는 이메일입니다.");
        }

        return true;
    }

    @Override
    public int checkEmailExist(String username) {
        int memberCnt = mapper.checkEmailExists(username);
        return memberCnt;
    }

    @Override
    public boolean findMember(String member_name, String username) {
        return mapper.findPwd(member_name, username);
    }

    @Override
    public MemberVO findByEmail(String username) {
        MemberVO member = mapper.findByEmail(username);
        System.out.println(member);
        return member;
    }
}