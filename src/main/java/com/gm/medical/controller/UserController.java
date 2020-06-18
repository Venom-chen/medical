package com.gm.medical.controller;

import com.gm.medical.entity.Policy;
import com.gm.medical.entity.User;
import com.gm.medical.service.AdminUserRoleService;
import com.gm.medical.service.UserService;
import com.gm.medical.result.Result;
import com.gm.medical.result.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * User controller.
 *
 * @author Evan
 * @date 2019/11
 */

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    AdminUserRoleService adminUserRoleService;

    @GetMapping("/api/admin/user")
    public Result listUsers() {
        return ResultFactory.buildSuccessResult(userService.list());
    }

    @PutMapping("/api/admin/user/status")
    public Result updateUserStatus(@RequestBody @Valid User requestUser) {
        userService.updateUserStatus(requestUser);
        return ResultFactory.buildSuccessResult("用户状态更新成功");
    }

    @PutMapping("/api/admin/user/password")
    public Result resetPassword(@RequestBody @Valid User requestUser) {
        userService.resetPassword(requestUser);
        return ResultFactory.buildSuccessResult("重置密码成功");
    }

    @PutMapping("/api/admin/user")
    public Result editUser(@RequestBody @Valid User requestUser) {
        userService.editUser(requestUser);
        return ResultFactory.buildSuccessResult("修改用户信息成功");
    }
    @DeleteMapping("/api/admin/user/deleteUser/{id}")
    public Result deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
        return ResultFactory.buildSuccessResult("删除成功");
    }
    @PostMapping("/api/admin/user/addUser")
    public Result addUser(@RequestBody User requestuser) {
        userService.addUser(requestuser);
        return ResultFactory.buildSuccessResult("添加成功");
    }
}
