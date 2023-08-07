package com.example.korail.rest;

import com.example.korail.entity.Station;
import com.example.korail.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class StationRestController {

    private StationService stationService;

    // inject station dao (use constructor injection)

    @Autowired
    public StationRestController(StationService theStationService) {
        stationService = theStationService;
    }


    @GetMapping("/route_info_json_data/{category}/{station}")
    public Map route_info_json(@PathVariable String category, @PathVariable String station) {
        List<Station> slist = stationService.findAll();
        List<String> hlist = stationService.historyList();
        //System.out.println(hlist);
        //System.out.println(slist);

        Map map = new HashMap();
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<hlist.size(); i++) {
            String historyData = hlist.get(i);
            StringTokenizer st = new StringTokenizer(historyData, "]");
            while (st.hasMoreTokens()) {
                list.add(i, st.nextToken());
            }
        }
        //System.out.println(list);
        map.put("list", list);
        map.put("slist", slist);

       //System.out.println(map);
        return map;
    }

}