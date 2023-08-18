package com.example.korail.repository;

import com.example.korail.dto.MileageDto;
import com.example.korail.dto.OrderDto;
import com.example.korail.dto.PageDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
@Mapper
public interface MileageMapper {

    int setMileage_Reduce(String reservnum);

    int setMileage(String Id, int changeAmount, String specifics, Date DepPlandTime, String reservnum);

    List<MileageDto> getMileageInfo(HashMap map);

    int getMileage(String memberId);

    //int deleteProc(String id, String reservnum);

    int updateProc(String specifics, String id, String reservnum);

    List<OrderDto> getStation(String id, String reservnum);

    void prepareUpdateProc(String id, String reservnum);

    int cancleMileage(String changeamount, String id, String reservnum);
}
