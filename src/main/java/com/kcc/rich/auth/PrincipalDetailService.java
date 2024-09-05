package com.kcc.rich.auth;

import com.kcc.rich.domain.member.MemberVO;
import com.kcc.rich.service.member.MemberService;
import com.kcc.rich.service.member.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailService implements UserDetailsService {
    private final MemberService memberService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberVO member = memberService.findByEmail(username);

        if(member != null) {
            return new PrincipalDetail(member);
        }

        return null;
    }
}
