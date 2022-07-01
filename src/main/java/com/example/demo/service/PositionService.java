package com.example.demo.service;

import com.example.demo.pojo.CityDTO;
import org.apache.ibatis.annotations.Param;

import javax.swing.text.Position;
import java.util.List;

public interface PositionService {
    List<CityDTO> getAllPositionLimit(Integer curPage, Integer pageSize);
}
