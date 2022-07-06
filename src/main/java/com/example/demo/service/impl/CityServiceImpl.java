package com.example.demo.service.impl;

import com.example.demo.dao.CityDao;
import com.example.demo.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.service.CityService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    CityDao cityDao;

    @Override
    public List<City> listCitys() {
        return cityDao.findAll();
    }

    @Override
    public List<City> listCityByCondition(City city) {
//        return cityDao.findCityByCondition(user);
        return new ArrayList<>();
    }
    @Override
    public int addCity(City city){
        return cityDao.addCity(city);
    }

    @Override
    public City getCityById(Integer id){
        return cityDao.getCityById(id);
    }
    @Override
    public  int deleteCity(Integer id){
        return cityDao.deleteCity(id);
    }

}
