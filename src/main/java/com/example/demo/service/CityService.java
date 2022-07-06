package com.example.demo.service;

import com.example.demo.entity.City;

import java.util.List;

public interface CityService {

    List<City> listCitys();

    List<City> listCityByCondition(City city);

    int addCity(City city);

    City getCityById(Integer id);

    int deleteCity(Integer id);



}
