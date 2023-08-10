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

    @GetMapping("/stations")
    public List<Station> findAll() {
        return stationService.findAll();
    }

    @GetMapping("/stations/{stationId}")
    public Station getStation(@PathVariable int stationId) {

        Station theStation = stationService.findById(stationId);

        if(theStation == null) {
            throw new RuntimeException("Station id not found - " + stationId);
        }

        return theStation;
    }

    @GetMapping("/route_info_json_data/{category}/{station}")
    public Map route_info_json(@PathVariable String category, @PathVariable String station) {
        List<Station> slist = stationService.findAll();

        Map map = new HashMap();
        ArrayList<String> list = new ArrayList<String>();
        List<String> historyData = stationService.historyListByStationAndCategory(station, category);
        for (int i = 0; i < historyData.size(); i++) {
            StringTokenizer st = new StringTokenizer(historyData.get(i), "]");
            while(st.hasMoreTokens()) {
                list.add(i, (String) st.nextElement());
            }
        }

            map.put("list", list);
            map.put("slist", slist);

            return map;
        }

    }