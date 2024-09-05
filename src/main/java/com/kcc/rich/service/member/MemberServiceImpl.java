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
    public MemberVO login(String username, String password) {
        MemberVO member = mapper.loginMember(username, password);

        return member;
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

    @Override
    public int countReservation(String username) {
        int countReservation = mapper.countReservation(username);
        System.out.println("serviceImpl: " + countReservation);
        return countReservation;
    }

    @Override
    public int countReview(String username) {
        return mapper.countReview(username);
    }

    @Override
    public void updateInfo(MemberVO member) {
        mapper.updateInfo(member);
    }

    @Override
    public String getMemberImg(String memberId) {
        return mapper.selectMemberImg(memberId);
    }
}