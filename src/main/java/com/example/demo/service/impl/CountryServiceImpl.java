package com.example.demo.service.impl;

import com.example.demo.dao.CityDao;
import com.example.demo.dao.CountryDao;
import com.example.demo.dao.CountryLanguageDao;
import com.example.demo.entity.City;
import com.example.demo.entity.Country;
import com.example.demo.service.CountryService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * 继承service、dao具体的实现类
 */
@Service
public class CountryServiceImpl implements CountryService {

    @Resource
    private CountryDao countryDao;
    @Resource
    private CityDao cityDao;
    @Resource
    private CountryLanguageDao countryLanguageDao;

    //验证父级
    @Override
    public List<Country> listCountry() {
        return countryDao.findAll();
    }

    @Override
    public boolean addCountry(Country country) {
        boolean flag = false;
        try {
            countryDao.addCountry(country);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    //try catch：自己处理异常
    //  try {
    //  可能出现异常的代码
    //  } catch（异常类名A e）{
    //  如果出现了异常类A类型的异常，那么执行该代码
    //  }
    @Override
    public boolean deleteCountry(String code) {
        boolean flag = false;
        try {
            cityDao.deleteByCountryCode(code);
            countryLanguageDao.deleteByCountryCode(code);
            countryDao.deleteCountry(code);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
    /*@Override
    public boolean addCountry(Country country) {
        return countryDao.addCountry(country);
    }

    @Override
    public boolean deleteCountry(String code) {
        return countryDao.deleteCountry(code);
    }*/

    @Override
    public boolean updateCountry(Country country) {
        boolean flag = false;
        try {
            countryDao.updateCountry(country);
            cityDao.updateByCountryCode(country);
            countryLanguageDao.updateByCountryCode(country);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
