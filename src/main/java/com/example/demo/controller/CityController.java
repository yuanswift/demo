package com.example.demo.controller;

import com.example.demo.entity.City;
import com.example.demo.entity.Country;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.CityService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *city CRUD的逻辑
 * */

/**
 * @RestController = @Controller(表示这个类是一个控制类，) + @ResponseBody(表示方法的返回值是以指定的格式写入Http response body中)
 * */
@RestController
/**
 * 表示共享映射，如果没有指定请求方式，将接收所有的HTTP请求方式。“value”值可有可无，值指定了需要被映射到处理方法参数的请求参数。
 * */
@RequestMapping(value = "city")
/**
 * 用于Controller类上，表示对类的说明，两个参数：value、tags
 * tags：说明该类的作用，可以在UI界面上看到
 * value: 说明该类作用，但在UI界面上看不到
 * */
@Api
public class CityController {

    /**
     * 当Spring发现@Autowired注解时，将自动在代码上下文中找到和其匹配(默认是类型匹配)的Bean，并自动注入到相应的地方去
     * */
    @Autowired
    CityService cityService;

    /**
     * 获取所有的城市
     *
     * @return
     */

    /**
     * 用来构建Api文档
     * value = “接口说明”, httpMethod = “接口请求方式”, response =“接口返回参数类型”, notes = “接口发布说明”
     * */
    @ApiOperation(value = "todo")

    /**
     * 用于将HTTP GET请求映射到特定处理程序方法
     * */
    @GetMapping(value = "list", produces = {"application/json;charset=UTF-8"})
    public List<City> getAllCity() {
        return cityService.listCity();
    }

    /**
     * @param user
     * @return
     */
    @ApiOperation(value = "todo")

    /**
     * 用于将HTTP POST请求映射到特定处理程序方法
     * */
    @PostMapping(value = "/getUsers", produces = {"application/json;charset=UTF-8"})
    public List<City> getUsersByCondition(@RequestBody City user) {
        return cityService.listCityByCondition(user);
    }

    /**
     * 新增城市
     *
     * @param id          城市的主键
     * @param name        城市名称
     * @param countryCode
     * @param district
     * @param population  城市人口，单位为个
     * @return
     */
    @ApiOperation(value = "add")
    @PutMapping("/add")

    /**
     * 将请求参数绑定到你控制器的方法参数上,value：参数名
     * */
    public Map<String,?> addCity(@RequestParam(value = "id") Integer id, @RequestParam(value = "name") String name, @RequestParam(value = "countryCode") String countryCode, @RequestParam(value = "district") String district, @RequestParam(value = "population") Integer population) {
        Map<String, Object> map = new HashMap<>();
        if (id == null || name == null || countryCode == null) {
            map.put("code", 101);
            map.put("msg", "");
            return map;
        }
        City city = new City();
        city.setId(id);
        city.setName(name);
        city.setCountryCode(countryCode);
        city.setDistrict(district);
        city.setPopulation(population);
        int getCode =  cityService.addCity(city);
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
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "todo")
    @DeleteMapping("delete")
    public Object deleteCity(@RequestParam(value = "id") Integer id) {
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

    /**
     * 修改city
     */
    @ApiOperation(value = "put")
    @RequestMapping(method = RequestMethod.PUT)
    public boolean cityCountry(@RequestBody City city){
        return cityService.updateCity(city);

    }
}