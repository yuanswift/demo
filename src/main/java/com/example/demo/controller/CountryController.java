package com.example.demo.controller;
import com.example.demo.entity.Country;
import com.example.demo.service.CountryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
    /*添加country*/
    @ApiOperation(value = "post")
    @RequestMapping(method = RequestMethod.POST)
    public boolean addCountry(@RequestBody Country country){
        return countryService.addCountry(country);
    }
    /*修改country*/
    @ApiOperation(value = "put")
    @RequestMapping(method = RequestMethod.PUT)
    public boolean updateCountry(@RequestBody Country country){
        return countryService.updateCountry(country);

    }
    /*删除country*/
    @ApiOperation(value = "delete")
    @RequestMapping(method = RequestMethod.DELETE)
    public boolean deleteCountry(@RequestParam(value = "countryName",required = true)String countryCode){
        return countryService.deleteCountry(countryCode);
    }



}
