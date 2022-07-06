package com.example.demo.controller;

import com.example.demo.entity.City;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.CityService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//为springmvc提供 定义类可以被浏览器访问
@RestController
//post方式询问
@RequestMapping(value = "users")
//表示swagger资源，用在类上
@Api
public class CityController {
    @Autowired
    CityService cityService;

    /**
     * 获取所有的城市
     *
     * @return
     */
    @ApiOperation(value = "todo")
    @GetMapping(value = "list", produces = {"application/json;charset=UTF-8"})
    public List<City> getAllUsers() {
        return cityService.listCitys();
    }

    /**
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "todo")
    @PostMapping(value = "/getUsers", produces = {"application/json;charset=UTF-8"})
    public List<City> getUsersByCondition(@RequestBody City user) {
        return cityService.listCityByCondition(user);
    }

    /**
     *
     * @return
     */
    @ApiOperation(value = "todo")
    @GetMapping("/init")
    public String init() {
        System.out.println("启动成功");
        return "启动成功";
    }

    /**
     * 新增城市
     * @param id 城市的主键
     * @param name 城市名称
     * @param countryCode
     * @param district
     * @param population 城市人口，单位为个
     * @return
     */
    @ApiOperation(value="add")
    @PutMapping("/add")
    public Object addCity(@RequestParam(value = "ID") Integer id, @RequestParam(value = "name") String name, @RequestParam(value = "CountryCode") String countryCode, @RequestParam(value = "District") String district, @RequestParam(value = "Population") Integer population) {
        Map<String, Object> map = new HashMap<>();
        if (id == null || name == null || countryCode == null) {
            map.put("code", 101);
            map.put("msg", "");
            return map;
        }
        City city = new City();
        city.setID(id);
        city.setName(name);
        city.setCountryCode(countryCode);
        city.setDistrict(district);
        city.setPopulation(population);
        int getCode = cityService.addCity(city);
        if (getCode == 1) {
            map.put("code", 200);
            map.put("msg", "添加数据成功");
            return map;
        }
        map.put("code", 100);
        map.put("msg", "添加数据失败");
        return map;
    }

    /**
     * 删除城市
     * @param id
     * @return
     */
    @ApiOperation(value = "todo")
    @DeleteMapping("delete")
    public Object deleteCity(@RequestParam(value = "ID") Integer id) {
        Map<String, Object> map = new HashMap<>();
        City city = cityService.getCityById(id);
        if (city == null) {
            map.put("code", 101);
            map.put("msg", "不存在该数据");
            return map;
        }
        int deleteCode = cityService.deleteCity(id);
        if (deleteCode == 1) {
            map.put("code", 200);
            map.put("msg", "删除数据成功");
            return map;
        }
        map.put("code", 100);
        map.put("msg", "删除数据失败");
        return map;
    }
}
