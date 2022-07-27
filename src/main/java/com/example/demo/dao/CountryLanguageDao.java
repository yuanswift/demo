package com.example.demo.dao;


import com.example.demo.entity.Country;
import com.example.demo.entity.CountryLanguage;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 数据调用
* */
@Repository
public interface CountryLanguageDao {

    /*查询所有countrylanguage*/
    @Select("select * from countryLanguage;")
    List<CountryLanguage> findAll();

    /*添加countrylanguage*/
    @Insert("insert into countryLanguage(countryCode,language,lsOfficial,percentage),values(#{countryLanguage.countryCode},#{countryLanguage.language},#{countryLanguage.lsOfficial},#{countryLanguage.percentage})")
    boolean addCountryLanguage (CountryLanguage countryLanguage);

    /*删除countryLanguage*/
    @Delete("delete from countryLanguage where countryCode=#{countrycode}")
    boolean deleteByCountryCode(String countryCode);
}









