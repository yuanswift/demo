package com.example.demo.service.impl;

import org.apache.ibatis.annotations.Param;

import javax.swing.text.Position;
import java.util.List;

public interface PositionService {
    List<Position> getallpositionlimit(Integer curPage , Integer pageSize);
}
