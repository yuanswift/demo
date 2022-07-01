package com.example.demo.dao;

import com.example.demo.pojo.CityDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import javax.swing.text.Position;
import java.util.List;

@Mapper
public interface PositionDao {

    @Select("select * from city limit #{curPage}, #{pageSize}")
    List<CityDTO> getallpositionlimit(@Param("curPage") Integer curPage, @Param("pageSize") Integer pageSize);

}
