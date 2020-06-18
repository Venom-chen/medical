package com.gm.medical.controller;

import com.gm.medical.entity.Area;

import com.gm.medical.entity.Chronicdis;
import com.gm.medical.result.Result;
import com.gm.medical.result.ResultFactory;

import com.gm.medical.service.ChronicdisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class ChronicdisController {
    @Autowired
    ChronicdisService chronicdisService;

    @GetMapping("/api/admin/chronicdis/list")
    public Result listChronicdis() {
        return ResultFactory.buildSuccessResult(chronicdisService.list());
    }

    @PutMapping("/api/admin/chronicdis/editChronicdis")
    public Result editChronicdis(@RequestBody Chronicdis requestChronicdis) {
        chronicdisService.editChronicdis(requestChronicdis);
        return ResultFactory.buildSuccessResult("修改用户信息成功");
    }

    @DeleteMapping("/api/admin/chronicdis/deleteChronicdis/{id}")
    public Result deleteChronicdis(@PathVariable("id") int id) {
        chronicdisService.delete(id);
        return ResultFactory.buildSuccessResult("删除成功");
    }

    @PostMapping("/api/admin/chronicdis/addChronicdis")
    public Result addChronicdis(@RequestBody Chronicdis requestChronicdis) {
        chronicdisService.addChronicdis(requestChronicdis);
        return ResultFactory.buildSuccessResult("修改用户成功");
    }
}
