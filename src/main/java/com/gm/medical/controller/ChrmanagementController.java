package com.gm.medical.controller;


import com.gm.medical.entity.Chrmanagement;
import com.gm.medical.result.Result;
import com.gm.medical.result.ResultFactory;
import com.gm.medical.service.ChrmanagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChrmanagementController {
    @Autowired
    ChrmanagementService chrmanagementService;

    @GetMapping("/api/admin/chrmanagement/list")
    public Result listChrmanagements() {
        return ResultFactory.buildSuccessResult(chrmanagementService.list());
    }

    @GetMapping("/api/admin/chrmanagements/list")
    public Result listChrmanagement() {
        return null;
    }

    @PutMapping("/api/admin/chrmanagement/editChrmanagement")
    public Result editChrmanagement(@RequestBody Chrmanagement requestChrmanagement) {
        chrmanagementService.editChronicmanagement(requestChrmanagement);
        return ResultFactory.buildSuccessResult("修改用户信息成功");
    }

    @DeleteMapping("/api/admin/chrmanagement/deleteChrmanagement/{id}")
    public Result deleteChrmanagement(@PathVariable("id") int id) {
        chrmanagementService.delete(id);
        return ResultFactory.buildSuccessResult("删除成功");
    }

    @PostMapping("/api/admin/chrmanagement/addChrmanagement")
    public Result addChrmanagement(@RequestBody Chrmanagement requestChrmanagement) {
        chrmanagementService.addChrmanagement(requestChrmanagement);
        return ResultFactory.buildSuccessResult("修改用户成功");
    }
}
