package com.example.korail.service;

import com.example.korail.entity.Station;

import java.util.List;

public interface StationService {

    List<Station> findAll();

    Station findById(int theId);

    Station save(Station theStation);

    void deleteById(int theId);

    List<String> getHistory();

}
