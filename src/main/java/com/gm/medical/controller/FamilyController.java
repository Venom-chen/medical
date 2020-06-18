package com.gm.medical.controller;


import com.gm.medical.dao.FamilyDAO;
import com.gm.medical.entity.Family;

import com.gm.medical.entity.Person;
import com.gm.medical.result.Result;
import com.gm.medical.result.ResultFactory;

import com.gm.medical.service.FamilyService;

import com.gm.medical.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
public class FamilyController {
    @Autowired
    FamilyService familyService;
    @Autowired
    PersonService personService;
    @Autowired
    FamilyDAO familyDAO;
    @GetMapping("/api/admin/family/list")
    public Result listFamily() {
        return ResultFactory.buildSuccessResult(familyService.list());
    }

    @PutMapping("/api/admin/family/editFamily")
    public Result editFamily(@RequestBody Family requestFamily) {
        familyService.editFamily(requestFamily);
        return ResultFactory.buildSuccessResult("修改用户信息成功");
    }

    @DeleteMapping("/api/admin/family/deleteFamily/{id}")
    public Result deleteFamily(@PathVariable("id") int id) {
        familyService.delete(id);
        return ResultFactory.buildSuccessResult("删除成功");
    }

    @PostMapping("/api/admin/family/addFamily")
    public Result addFamily(@RequestBody Family requestFamily) {
        String fc =familyDAO.getFamicode();
        BigInteger famicode= new BigInteger(fc);
        BigInteger fcd=famicode.add(new BigInteger("1"));
        String Famicode=fcd.toString();
        System.out.println(Famicode);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String Date =formatter.format(date);
        requestFamily.setFamicode(Famicode);
        requestFamily.setCreattime(Date);
        familyService.addFamily(requestFamily);
        return ResultFactory.buildSuccessResult("修改用户成功");
    }
}
