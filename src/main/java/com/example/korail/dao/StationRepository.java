package com.example.korail.dao;

import com.example.korail.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StationRepository extends JpaRepository<Station, Integer> {
    @Query(value="select HISTORY from KTX_STATION where KTX_STATION.STATION=?1", nativeQuery = true)
    List<String> historyListByStation(String station);

}
