package com.example.korail.restcontroller;

import com.example.korail.dto.MileageDto;
import com.example.korail.dto.PageDto;
import com.example.korail.service.MileageService;
import com.example.korail.service.PageService;
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
    @Autowired
    PageService pageService;

        @GetMapping("mileage_list_json_data/{page}/{memberId}")
        public Map mileage_list(@PathVariable String page, @PathVariable String memberId) {
            Map map = new HashMap();
            Map tempMap = new HashMap();

            PageDto pageDto = pageService.getPageResult(new PageDto(page, "mileage"), memberId);
            tempMap.put("pageDto", pageDto); tempMap.put("memberId", memberId);
            List<MileageDto> list = mileageService.getMileageInfo(tempMap);

            map.put("list",list);
            map.put("page",pageDto);
            return map;
        }
}
