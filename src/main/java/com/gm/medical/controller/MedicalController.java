package com.gm.medical.controller;

import com.gm.medical.entity.Institution;
import com.gm.medical.entity.Medical;
import com.gm.medical.entity.User;
import com.gm.medical.result.Result;
import com.gm.medical.result.ResultFactory;
import com.gm.medical.service.AdminUserRoleService;
import com.gm.medical.service.InstitutionService;
import com.gm.medical.service.MedicalService;
import com.gm.medical.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class MedicalController {
    @Autowired
    MedicalService medicalService;

    @GetMapping("/api/admin/medical/list")
    public Result listMedical() {
        return ResultFactory.buildSuccessResult(medicalService.list());
    }

    @PutMapping("/api/admin/medical/editMedical")
    public Result editMedical(@RequestBody Medical requestMedical) {
        medicalService.editMedical(requestMedical);
        return ResultFactory.buildSuccessResult("修改用户信息成功");
    }

    @DeleteMapping("/api/admin/medical/deleteMedical/{id}")
    public Result deleteMedical(@PathVariable("id") int id) {
        medicalService.delete(id);
        return ResultFactory.buildSuccessResult("删除成功");
    }

    @PostMapping("/api/admin/medical/addMedical")
    public Result addMedical(@RequestBody Medical requestMedical) {
        medicalService.addMedical(requestMedical);
        return ResultFactory.buildSuccessResult("修改用户成功");
    }
}
