package com.example.demo.service;

import com.example.demo.entity.City;

import java.util.List;
/**
 * 服务层
 * 将操作封装起来
 * */
public interface CityService {
    /*查询所有city*/
    List<City> listCity();
    /*id查询city*/
    List<City> listCityByCondition(City city);
    //分页查询
    List<City> listCity_page(Integer index,Integer pageSize);
    /*city添加*/
    int addCity(City city);

    City getCityById(Integer id);
    /*删除city数据*/
    int deleteCity(Integer id);
    /*修改city*/
    boolean updateCity(City city);
    /*删除city外键*/




}
