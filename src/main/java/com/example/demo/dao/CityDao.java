package com.example.demo.dao;

import com.example.demo.entity.City;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CityDao {
    @Select("select * from city;")
    List<City> findAll();
    @Select("select * from city where id= #{id}")
    City getCityById(Integer id);

    @Insert("insert into city(ID,Name,CountryCode,District,Population) values (#{city.ID},#{city.Name},#{city.CountryCode},#{city.District},#{city.Population}) ")
    int addCity(@Param("city") City city);
//    List<User> findUsersByCondition(User user);
    @Delete("delete from city where ID = #{ID}")
    int deleteCity(@Param("ID") Integer ID);
}
