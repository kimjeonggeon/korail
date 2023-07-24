package com.example.korail.service;

import com.example.korail.dao.StationDao;
import com.example.korail.entity.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StationServiceImpl implements StationService {

    private StationDao stationDao;

    @Autowired
    public StationServiceImpl(StationDao theStationDao) {
        stationDao = theStationDao;
    }

    @Override
    public List<Station> findAll() {
        return stationDao.findAll();
    }

    @Override
    public Station findById(int theId) {
        return stationDao.findById(theId);
    }

    @Transactional
    @Override
    public Station save(Station theStation) {
        return stationDao.save(theStation);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        stationDao.deleteById(theId);
    }

    @Override
    public List<Station> findByCategory(String category) {
        return stationDao.findByCategory(category);
    }
}
