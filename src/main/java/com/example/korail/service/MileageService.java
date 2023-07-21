package com.example.korail.service;

import com.example.korail.dto.MileageDto;
import com.example.korail.repository.MileageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MileageService {

    @Autowired
    private MileageMapper mileageMapper;
    public List<MileageDto> getMileageInfo(String memberId) {
        return mileageMapper.getMileageInfo(memberId);
    }

    public String getMileage(String memberId) {
        return mileageMapper.getMileage(memberId);
    }
}
