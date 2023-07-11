package com.example.korail.service;

import com.example.korail.dto.MemberDto;
import com.example.korail.dto.SessionDto;
import com.example.korail.repository.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    MemberMapper memberMapper;

    public int getJoinResult(MemberDto memberDto){

        return memberMapper.join(memberDto);
    }
    public int getEmailCheckResult(String email){

        return memberMapper.emailCheck(email);
    }

    public int getIdCheckResult(String id){

        return memberMapper.idCheck(id);
    }
    public SessionDto getLoginResult(MemberDto memberDto){

        return memberMapper.loginCheck(memberDto);
    }
}
