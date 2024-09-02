package com.kcc.rich.mapper.member;


import com.kcc.rich.domain.member.MemberVO;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MemberMapper {
    public void insertMember(MemberVO member);
    public MemberVO loginMember(String username, String password);
    public int checkEmailExists(String username);
    public boolean findPwd(String member_name, String username);
    public MemberVO findByEmail(String username);
}
