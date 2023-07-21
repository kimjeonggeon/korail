package com.example.korail.restcontroller;

import com.example.korail.dto.MileageDto;
import com.example.korail.service.MileageService;
import com.example.korail.service.PmyhisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class MileageRestController {

    @Autowired
    MileageService mileageService;

        @GetMapping("mileage_list_json_data/{memberId}")
        public Map mileage_list(@PathVariable String memberId) {
            Map map = new HashMap();
            List<MileageDto> list =  mileageService.getMileageInfo(memberId);
            System.out.println(list.get(0).getTotalmileage());
            map.put("list",list);
            return map;
        }
}
