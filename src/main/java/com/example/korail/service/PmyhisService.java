package com.example.korail.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.korail.dto.OrderDto;
import com.example.korail.repository.PmyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PmyhisService{

    @Autowired
    private PmyMapper pmyMapper;

    public OrderDto getInfo(String reservnum) {
        return pmyMapper.getInfo(reservnum);
    }

    public ArrayList<OrderDto> getSelect(HashMap<String, String> param) {
        return pmyMapper.getSelect(param);
    }

    public int preferential( HashMap<String, String> param) {
        return pmyMapper.preferential(param);
    }

    public String oldfile (String name) {
        return pmyMapper.oldfile(name);
    }

}
