package com.example.demo.controller;
import com.example.demo.entity.City;
import com.example.demo.entity.Country;
import com.example.demo.service.CountryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "country")
@Api
public class CountryController {

    @Resource
    private CountryService countryService;
    /*查找所有country*/
    @ApiOperation(value = "get")
    @RequestMapping (value = "/all" ,method = RequestMethod.GET)
    public List<Country> getAllCountry(){
            return countryService.listCountry();
    }
    @ApiOperation(value = "to")
    @PostMapping(value = "list_page",produces = {"application/json;charset=UTF-8"})
    public List<Country> getPageCity(@RequestBody Map<String,Object> map){
        Integer index = (Integer) map .get("index");
        Integer pageSize = (Integer) map.get("pageSize");
        return countryService.listCountry_page(index,pageSize);
    }
    /*添加country*/
    @ApiOperation(value = "新增")
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public boolean addCountry(@RequestBody Country country){
        return countryService.addCountry(country);
    }
   /* public Map<String, ?> addCountry( @RequestParam(value = "code") String code, @RequestParam(value = "name") String name, @RequestParam(value = "continent") String continent,@RequestParam("region")String region, @RequestParam(value = "surfaceArea") Integer surfaceArea,@RequestParam(value = "inDepYear")Integer inDepYear,@RequestParam(value = "population") Integer population,@RequestParam(value = "lifeExpectancy") Float lifeExpectancy,@RequestParam(value = "gnp")Float gnp,@RequestParam("gnpOld")Float gnpOld,@RequestParam("localName") String localName,@RequestParam("governmentForm") String governmentForm,@RequestParam("headOfState")String headOfState,@RequestParam("capital")Integer capital,@RequestParam("code2") String code2) {
        Map<String, Object> map = new HashMap<>();
        if (code == null || name == null) {
            map.put("code", 101);
            map.put("msg", "");
            return map;
        }
        Country country = new Country();
        country.setCode(code);
        country.setName(name);
        country.setContinent(continent);
        country.setRegion(region);
        country.setSurfaceArea(surfaceArea);
        int getCode = countryService.addCountry(country);
        if (getCode == 1) {
            map.put("code", 200);
            map.put("msg", "添加数据成功");
            return map;
        }
        map.put("code", 100);
        map.put("msg", "添加数据失败");
        return map;
    }
*/
    /*修改country*/
    @ApiOperation(value = "修改")
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public boolean updateCountry(@RequestBody Country country){
        System.out.println(country);
        return countryService.updateCountry(country);

    }
    /*删除country*/
    @ApiOperation(value = "delete")
    @RequestMapping(value = "delete",method = RequestMethod.DELETE)
    public boolean deleteCountry(@RequestParam(value = "code") String countryCode){
        return countryService.deleteCountry(countryCode);
    }



}
