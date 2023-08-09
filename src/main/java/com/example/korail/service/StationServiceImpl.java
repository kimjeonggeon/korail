package com.example.korail.service;

import com.example.korail.dao.StationRepository;
import com.example.korail.entity.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StationServiceImpl implements StationService {

    private StationRepository stationRepository;


    @Autowired
    public StationServiceImpl(StationRepository theStationRepository) {
        stationRepository = theStationRepository;
    }

    @Override
    public List<Station> findAll() {
        return stationRepository.findAll();
    }

    @Override
    public Station findById(int theId) {
        Optional<Station> result = stationRepository.findById(theId);

        Station theStation = null;
        if(result.isPresent()) {
            theStation = result.get();
        } else {
            throw new RuntimeException("Did not find Station id - " + theId);
        }

        return theStation;
    }

    @Override
    public Station save(Station theStation) {
        return stationRepository.save(theStation);
    }

    @Override
    public void deleteById(int theId) {
        stationRepository.deleteById(theId);
    }

    @Override
    public List<String> historyListByStationAndCategory(String station, String category) {
        return stationRepository.historyListByStationAndCategory(station, category);
    }
}
