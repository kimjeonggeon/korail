package com.example.korail.service;

import com.example.korail.dto.MileageDto;
import com.example.korail.dto.PageDto;
import com.example.korail.repository.MileageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MileageService {

    @Autowired
    private MileageMapper mileageMapper;

    public int setMileage(String Id, String source,int amount) { return mileageMapper.setMileage(Id, source, amount);}

    public List<MileageDto> getMileageInfo(Map tempMap) {
        return mileageMapper.getMileageInfo((HashMap) tempMap);
    }

    public String getMileage(String memberId) {
        return mileageMapper.getMileage(memberId);
    }
}
