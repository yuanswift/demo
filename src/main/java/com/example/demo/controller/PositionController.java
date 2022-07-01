package com.example.demo.controller;

import com.example.demo.pojo.CityDTO;
import com.example.demo.service.PositionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.Position;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/position")
@RestController
public class PositionController {
    @Autowired
    PositionService positionService;

    @ApiOperation("todo")
    @RequestMapping("/getallpositionlimit")
    public Object getallpositionlimit(@RequestParam(value = "curPage") Integer curPage, @RequestParam(value = "pageSize") Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        List<CityDTO> data = positionService.getAllPositionLimit((curPage - 1) * pageSize, pageSize);
        if (data != null && data.size() > 0) {
            map.put("code", 200);
            map.put("msg", "获取数据成功");
            map.put("data", data);
        } else {
            map.put("code", 100);
            map.put("msg", "暂时没有数据");
        }
        return map;
    }

}
