package com.example.demo.dao;

import com.example.demo.pojo.CityDTO;
import org.apache.ibatis.annotations.*;

import javax.swing.text.Position;
import java.util.List;

@Mapper
public interface PositionDao {

    @Select("select * from city limit #{curPage}, #{pageSize}")
    List<CityDTO> getAllpositionlimit(@Param("curPage") Integer curPage, @Param("pageSize") Integer pageSize);

}
