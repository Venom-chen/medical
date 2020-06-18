package com.gm.medical.controller;


import com.gm.medical.entity.Institution;

import com.gm.medical.result.Result;
import com.gm.medical.result.ResultFactory;

import com.gm.medical.service.InstitutionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class InstitutionController {
    @Autowired
    InstitutionService institutionService;

    @GetMapping("/api/admin/institution/list")
    public Result listInstitution() {
        return ResultFactory.buildSuccessResult(institutionService.list());
    }

    @PutMapping("/api/admin/institution/editInstitution")
    public Result editInstitution(@RequestBody Institution requestInstitution) {
        institutionService.editInstitution(requestInstitution);
        return ResultFactory.buildSuccessResult("修改用户信息成功");
    }

    @DeleteMapping("/api/admin/institution/deleteInstitution/{id}")
    public Result deleteInstitution(@PathVariable("id") int id) {
        institutionService.delete(id);
        return ResultFactory.buildSuccessResult("删除成功");
    }

    @PostMapping("/api/admin/institution/addInstitution")
    public Result addInstitution(@RequestBody Institution requestInstitution) {
        institutionService.addInstitution(requestInstitution);
        return ResultFactory.buildSuccessResult("修改用户成功");
    }
}
