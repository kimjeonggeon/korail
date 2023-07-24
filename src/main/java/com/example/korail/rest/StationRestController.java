package com.example.korail.rest;

import com.example.korail.dto.PageDto;
import com.example.korail.entity.Station;
import com.example.korail.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ktx")
public class StationRestController {

    private StationService stationService;

    // inject station dao (use constructor injection)

    @Autowired
    public StationRestController(StationService theStationService) {
        stationService = theStationService;
    }

    // expose "/stations" and return a list of stations
    @GetMapping("/stations")
    public List<Station> findAll() {
        return stationService.findAll();
    }

    // add mapping for GET /stations/{stationId}
    @GetMapping("/stations/{stationId}")
    public Station getStation(@PathVariable int stationId) {

        Station theStation = stationService.findById(stationId);

        if(theStation == null) {
            throw new RuntimeException("Station id not found - " + stationId);
        }

        return theStation;
    }

    // add mapping for POST /stations - add new station
    @PostMapping("/stations")
    public Station addStation(@RequestBody Station theStation) {

        theStation.setId(0);

        Station dbStation = stationService.save(theStation);

        return dbStation;
    }

    @GetMapping("/route_info_json/{page}")
    public Map route_info_json(@PathVariable String page) {
        Map map = new HashMap();
        PageDto pageDto = new PageDto(page, "train_info");
        List<Station> slist = stationService.findAll();
        //System.out.println(slist);

        map.put("slist", slist);
        map.put("page", pageDto);

        return map;
    }

}
