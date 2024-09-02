package com.kcc.rich.domain.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
    private int member_id;
    private String password;
    private String member_name;
    private String member_nick;
    private String username;
    private String member_address;
    private String member_phone;
    private String member_img;
    private Timestamp member_create;
    private Timestamp member_update;
}