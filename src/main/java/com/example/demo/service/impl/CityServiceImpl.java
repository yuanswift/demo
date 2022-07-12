package com.example.demo.service.impl;

import com.example.demo.dao.CityDao;
import com.example.demo.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.service.CityService;

import java.util.ArrayList;
import java.util.List;
/**
 * 继承service、dao具体的实现类
 * */

/**
 *getBean的类名
 * */
@Service
/*implements 一个类实现一个接口用的关键字*/
public class CityServiceImpl implements CityService {

    /**
     * 当Spring发现@Autowired注解时，将自动在代码上下文中找到和其匹配(默认是类型匹配)的Bean，并自动注入到相应的地方去
     * */
    @Autowired
    CityDao cityDao;

    /**
     * 验证方法是否父级所有
     * */
    @Override
    public List<City> listCity() {
        return cityDao.findAll();
    }

    @Override
    public List<City> listCityByCondition(City city) {
//        return cityDao.findCityByCondition(user);
        return new ArrayList<>();
    }

    @Override
    public int addCity(City city) {
        return cityDao.addCity(city);
    }

    /**
     * 与dao和service验证
     * */
    @Override
    public City getCityById(Integer id) {
        return cityDao.getCityById(id);
    }

    @Override
    public int deleteCity(Integer id) {
        return cityDao.deleteCity(id);
    }

    /**
     * try catch 捕捉异常
     * */
    @Override
    public boolean updateCity(City city) {
        boolean flag=false;
        try{
            cityDao.updateCity(city);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;}
}
