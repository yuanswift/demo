package com.example.demo.controller;

import com.example.demo.entity.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.IUserService;

import java.util.List;

@RestController//为springmvc提供 定义类可以被浏览器访问
@RequestMapping(value = "users")/*post方式询问*/
@Api//表示swagger资源，用在类上
public class UserController {
    @Autowired
    IUserService IUserService;

    @ApiOperation(value = "todo")
    @GetMapping(value = "", produces = {"application/json;charset=UTF-8"})
    public List<User> getAllUsers() {
        List<User> users = IUserService.listUsers();
        return users;
    }

    @ApiOperation(value = "todo")
    @PostMapping(value = "/getUsers", produces = {"application/json;charset=UTF-8"})
    public List<User> getUsersByCondition(@RequestBody User user) {
        return IUserService.listUsersByCondition(user);
    }
/*分页查询*/
    /*@ApiOperation(value = "todo")
    @GetMapping(value = "", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    @RequestMapping("/findPage")
    public List<User> findPage(@RequestParam int pageNum, @RequestParam int pageSize) {
    // 设置分页查询参数
        PageHelper.startPage(pageNum, pageSize);
        List<User> listUsers =IUserService.listUsers();

        for (User user : listUsers) {
        System.out.println("element : " + user);
    }

    // 封装分页查询结果到 PageInfo 对象中以获取相关分页信息
        PageInfo pageInfo = new PageInfo(listUsers);
        System.out.println("总页数: " + pageInfo.getPages());
        System.out.println("总记录数: " + pageInfo.getTotal());
        System.out.println("当前页数: " + pageInfo.getPageNum());
        System.out.println("当前页面记录数量: " + pageInfo.getSize());

        return pageInfo.getList();
}*/

}
