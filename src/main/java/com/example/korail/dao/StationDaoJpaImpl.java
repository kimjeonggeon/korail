package com.example.korail.dao;

import com.example.korail.entity.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class StationDaoJpaImpl implements StationDao {

    // define field for entitymanager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public StationDaoJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Station> findAll() {

        // create a query
        TypedQuery<Station> theQuery = entityManager.createQuery("from Station", Station.class);

        // execute query and get result list
        List<Station> stations = theQuery.getResultList();

        // return the results
        return stations;
    }

    @Override
    public Station findById(int theId) {

        // get station
        Station theStation = entityManager.find(Station.class, theId);

        // return station
        return theStation;
    }

    @Override
    public Station save(Station theStation) {

        // save station
        Station dbStation = entityManager.merge(theStation);

        // return the dbStation
        return dbStation;
    }

    @Override
    public void deleteById(int theId) {

        // find station by id
        Station theStation = entityManager.find(Station.class, theId);

        // remove station
        entityManager.remove(theStation);

    }

    @Override
    public List<Station> findByCategory(String category) {

        TypedQuery<Station> theQuery = entityManager.createQuery("from Station ", Station.class);

        List<Station> stationList = theQuery.getResultList();

        return stationList;
    }
}
