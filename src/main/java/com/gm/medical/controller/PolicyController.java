package com.gm.medical.controller;

import com.gm.medical.entity.Person;
import com.gm.medical.entity.Policy;
import com.gm.medical.entity.User;
import com.gm.medical.result.Result;
import com.gm.medical.result.ResultFactory;
import com.gm.medical.service.AdminUserRoleService;
import com.gm.medical.service.PersonService;
import com.gm.medical.service.PolicyService;
import com.gm.medical.service.UserService;
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
public class PolicyController {
    @Autowired
    PolicyService policyService;

    @GetMapping("/api/admin/policy/list")
    public Result listPolicy() {
        return ResultFactory.buildSuccessResult(policyService.list());
    }

    @PutMapping("/api/admin/policy/editPolicy")
    public Result editPolicy(@RequestBody Policy requestPolicy) {
        policyService.editPolicy(requestPolicy);
        return ResultFactory.buildSuccessResult("修改信息成功");
    }

    @DeleteMapping("/api/admin/policy/deletePolicy/{id}")
    public Result deletePolicy(@PathVariable("id") int id) {
        policyService.delete(id);
        return ResultFactory.buildSuccessResult("删除成功");
    }

    @PostMapping("/api/admin/policy/addPolicy")
    public Result addPolicy(@RequestBody Policy requestPolicy) {
        policyService.addPolicy(requestPolicy);
        return ResultFactory.buildSuccessResult("添加成功");
    }

}
