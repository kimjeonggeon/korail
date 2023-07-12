package com.example.korail.service;

import java.util.HashMap;
import java.util.List;

import com.example.korail.dto.MemberDto;
import com.example.korail.dto.OrderDto;
import com.example.korail.repository.MypageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MypageService {

	@Autowired
	private MypageMapper mypageMapper;

	public int getCount(String userId) {
		return mypageMapper.count(userId);
	}

	public List<MemberDto> getInfo(String userId) {
		return mypageMapper.getInfo(userId);
	}

	public int getPassupdate(HashMap<String, String> param) {
		System.out.println("Service pass");
		return mypageMapper.getPassupdate(param);
	}

	public int getPnumberUpdate(HashMap<String, String> param) {
		return mypageMapper.getPnumberUpdate(param);
	}

	public int getWithresult(String id) {
		return mypageMapper.getWithresult(id);
	}

}
