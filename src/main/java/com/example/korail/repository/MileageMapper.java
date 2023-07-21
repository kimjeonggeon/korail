package com.example.korail.repository;

import com.example.korail.dto.MileageDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MileageMapper {
    List<MileageDto> getMileageInfo(String UserId);

    String getMileage(String memberId);
}
