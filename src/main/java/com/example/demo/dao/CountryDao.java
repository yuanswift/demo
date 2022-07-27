package com.example.demo.dao;

import com.example.demo.entity.City;
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
    //分页查询
    @Select("select * from country limit #{index},#{pageSize};")
    List<Country> findPage(Integer index, Integer pageSize);

    /*添加country*/
    @Insert("insert into country(code,name,continent,region,surfaceArea,inDepYear,population,lifeExpectancy,gnp,gnpOld,localName,governmentForm,headOfState,capital,code2) values(#{code},#{name},#{continent},#{region},#{surfaceArea},#{inDepYear},#{population},#{lifeExpectancy},#{gnp},#{gnpOld},#{localName},#{governmentForm},#{headOfState},#{capital},#{code2})")
    boolean addCountry(Country country);

    /*修改country*/
    @Update("update country set Name=#{name},Continent=#{continent},Region=#{region},SurfaceArea=#{surfaceArea},InDepYear=#{inDepYear},Population=#{population},LifeExpectancy=#{lifeExpectancy},Gnp=#{gnp},GnpOld=#{gnpOld},LocalName=#{localName},GovernmentForm=#{governmentForm},HeadOfState=#{headOfState},Capital=#{capital},Code2=#{code2} where Code=#{code}")
    void updateCountry(Country country);

    /*删除country*/
    @Delete("delete from country where code=#{code}")
    boolean deleteCountry(String code);
}
