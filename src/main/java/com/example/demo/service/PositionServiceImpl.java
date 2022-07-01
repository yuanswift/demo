package com.example.demo.service;

import com.example.demo.dao.PositionDao;
import com.example.demo.service.impl.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.Position;
import java.util.List;

@Service(value = "PositionService")
public class PositionServiceImpl implements PositionService {
    @Autowired
    PositionDao positionDao;

    @Override
    public List<Position> getallpositionlimit(Integer curPage, Integer pageSize) {
        return positionDao.getallpositionlimit(curPage,pageSize);
    }





}
