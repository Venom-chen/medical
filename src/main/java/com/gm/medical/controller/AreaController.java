package com.gm.medical.controller;



import com.gm.medical.entity.Area;
import com.gm.medical.result.Result;
import com.gm.medical.result.ResultFactory;
import com.gm.medical.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AreaController {
    @Autowired
    AreaService areaService;

    @GetMapping("/api/admin/area/list")
    public Result listAreas() {
        return ResultFactory.buildSuccessResult(areaService.list());
    }

    @PutMapping("/api/admin/area/editArea")
    public Result editArea(@RequestBody Area requestArea) {
        areaService.editArea(requestArea);
        return ResultFactory.buildSuccessResult("修改信息成功");
    }

    @DeleteMapping("/api/admin/area/deleteArea/{id}")
    public Result deleteArea(@PathVariable("id") int id) {
        areaService.delete(id);
        return ResultFactory.buildSuccessResult("删除成功");
    }

    @PostMapping("/api/admin/area/addArea")
    public Result addArea(@RequestBody Area requestArea) {
        areaService.addArea(requestArea);
        return ResultFactory.buildSuccessResult("添加成功");
    }
}
