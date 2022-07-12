package com.example.demo.dao;

import com.example.demo.entity.Country;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 数据调用，传递
* */
@Repository
public interface CountryDao {
    /*查询所有country*/
    @Select("select * from country;")
    List<Country> findAll();

    /*添加country*/
    @Insert("insert into country(code,name,continent,region,surfaceArea,inDepYear,population,lifeExpectancy,gnp,gnpOld,localName,governmentForm,headOfState,capital,code2) values(#{code},#{name},#{continent},#{region},#{surfaceArea},#{inDepYear},#{population},#{lifeExpectancy},#{gnp},#{gnpOld},#{localName},#{governmentForm},#{headOfState},#{capital},#{code2})")
    boolean addCountry(Country country);

    /*修改country*/
    @Update("update country set code=#{code},name=#{name},continent=#{continent},region=#{region},surfaceArea=#{surfaceArea},inDepYear=#{inDepYear},population=#{population},lifeExpectancy=#{lifeExpectancy},gnp=#{gnp},gnpOld=#{gnpOld},localName=#{localName},governmentForm=#{governmentForm},headOfState=#{headOfState},capital=#{capital},code2=#{code2}")
    void updateCountry(Country country);

    /*删除country*/
    @Delete("delete from country where code=#{code}")
    boolean deleteCountry(String code);
}
