package com.example.korail.repository;

import com.example.korail.dto.OrderDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;
@Mapper
public interface PmyMapper {

    OrderDto getInfo(String reservnum);

    ArrayList<OrderDto> getSelect(HashMap<String, String> param);

    int preferential( HashMap<String, String> param);

    String oldfile(String name);

    int mileage (String id);
}
