package com.example.korail.repository;

import com.example.korail.dto.MemberDto;
import com.example.korail.dto.SessionDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    int join(MemberDto memberDto);
    int emailCheck(String email);
    int idCheck(String id);
    SessionDto loginCheck(MemberDto memberDto);
}
