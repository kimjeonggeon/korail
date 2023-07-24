package com.example.korail.dao;

import com.example.korail.entity.Station;

import java.util.List;

public interface StationDao {

    List<Station> findAll();

    Station findById(int theId);

    Station save(Station theStation);

    void deleteById(int theId);

   List<Station> findByCategory(String category);
}
