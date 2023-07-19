package com.example.korail.restcontroller;

import com.example.korail.service.PmyhisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.Map;

public class MileageRestController {

    @Autowired
    PmyhisService pmyhisService;

    @GetMapping("mileage_list_json_data/{page}/")
    public Map mileage_list(@PathVariable String page) {
        Map map = new HashMap();


        return map;
    }
}
