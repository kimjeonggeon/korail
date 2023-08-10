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

    public int setMileage_Reduce(String reservnum) { return mileageMapper.setMileage_Reduce(reservnum);}

    public int setMileage(String Id, int changeAmount, String specifics) { return mileageMapper.setMileage(Id, changeAmount, specifics);}

    public List<MileageDto> getMileageInfo(Map tempMap) {
        return mileageMapper.getMileageInfo((HashMap) tempMap);
    }

    public int getMileage(String memberId) {
        return mileageMapper.getMileage(memberId);
    }
}
