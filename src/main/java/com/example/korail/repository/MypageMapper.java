package com.example.korail.repository;

import com.example.korail.dto.MemberDto;

import com.example.korail.dto.MemberaddDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface MypageMapper {

    int count(String UserId);

    List<MemberDto> getInfo(String UserId);

    int getPassupdate(HashMap<String, String> param);

    int getPnumberUpdate(HashMap<String, String> param);

    int getWithresult(String id);

    int update (MemberaddDto memberaddDto);

}
