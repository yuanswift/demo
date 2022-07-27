package com.example.demo.dao;

import com.example.demo.entity.City;
import com.example.demo.entity.Country;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
*
* 对city数据库访问进行封装
* */

/**
 * Spring->生成dao中的bean->注入到ServiceImpl
* */
/*使用@Mapper 不在Spring中获取扫描地址，通过mapper.xml(namespace属性)对应相关的mapper类*/
@Repository
public interface CityDao {
    /*查询所有city*/
    @Select("select * from city;")
    List<City> findAll();
    //分页查询
    @Select("select * from city limit #{index},#{pageSize};")
    List<City> findPage(Integer index,Integer pageSize);
    /*更具cityID查询*/
    @Select("select * from city where id= #{id}")
    City getCityById(Integer id);
    /*City新增*/
    /**
     * 返回自增主键
     * */
    @Insert("insert into city(Name,CountryCode,District,Population) values (#{city.name},#{city.countryCode},#{city.district},#{city.population}) ")
    int addCity(@Param("city") City city);
//    List<User> findUsersByCondition(User user);
    /*City数据删除*/
    @Delete("delete from city where id = #{id}")
    int deleteCity(@Param("id") Integer id);
    /*City数据修改*/
    @Update("update city set Name=#{name},CountryCode=#{countryCode},District=#{district},Population=#{population} where id=#{id}")
    void updateCity(City city);
    /*外键删除city*/
    @Delete("delete from city where countryCode=#{countryCode}")
    boolean deleteByCountryCode(String countryCode);

}

