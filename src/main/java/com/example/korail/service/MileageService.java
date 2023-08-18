package com.example.korail.service;

import com.example.korail.dto.MileageDto;
import com.example.korail.dto.OrderDto;
import com.example.korail.dto.PageDto;
import com.example.korail.repository.MileageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MileageService {

    @Autowired
    private MileageMapper mileageMapper;

    public int setMileage_Reduce(String reservnum) { return mileageMapper.setMileage_Reduce(reservnum);}

    public int setMileage(String Id, int changeAmount, String specifics, Date DepPlandTime, String reservnum) { return mileageMapper.setMileage(Id, changeAmount, specifics, DepPlandTime, reservnum);}

    public List<MileageDto> getMileageInfo(Map tempMap) {
        return mileageMapper.getMileageInfo((HashMap) tempMap);
    }

    public int getMileage(String memberId) {
        return mileageMapper.getMileage(memberId);
    }

    //public int deleteProc(String id, String reservnum) { return mileageMapper.deleteProc(id, reservnum); }

    public int updateProc(String specifics, String id, String reservnum) { return mileageMapper.updateProc(specifics, id, reservnum); }

    public List<OrderDto> getStation (String id, String reservnum) { return mileageMapper.getStation(id, reservnum); }

    public void prepareUpdateProc (String id, String reservnum) { mileageMapper.prepareUpdateProc(id, reservnum); }

    public int cancleMileage (String changeamount, String id, String reservnum) { return mileageMapper.cancleMileage(changeamount, id, reservnum); }
}
