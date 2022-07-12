package com.example.demo.service;

import com.example.demo.entity.Country;

import java.util.List;

public interface CountryService {
    /*查询所有country*/
    List<Country> listCountry();
    /*添加country*/
    boolean addCountry(Country country);
    /*修改country*/
    boolean updateCountry(Country country);
    /*删除country*/
    boolean deleteCountry(String code);
}
