package com.example.demo.service.impl;

import com.example.demo.dao.PositionDao;
import com.example.demo.pojo.CityDTO;
import com.example.demo.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service(value = "PositionService")
public class PositionServiceImpl implements PositionService {
    @Autowired
    PositionDao positionDao;

    @Override
    public List<CityDTO> getAllPositionLimit(Integer curPage, Integer pageSize) {
        return positionDao.getAllpositionlimit(curPage, pageSize);
    }

}
