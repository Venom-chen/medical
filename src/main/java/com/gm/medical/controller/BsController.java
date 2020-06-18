package com.gm.medical.controller;



import com.gm.medical.dao.BsDAO;
import com.gm.medical.dao.PersonDAO;
import com.gm.medical.dao.PolicyDAO;
import com.gm.medical.entity.*;
import com.gm.medical.result.Result;
import com.gm.medical.result.ResultFactory;

import com.gm.medical.service.BsService;
import com.gm.medical.service.ChrmanagementService;
import com.gm.medical.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class BsController {
    @Autowired
    BsService bsService;
    @Autowired
    PersonDAO personDAO;
    @Autowired
    PersonService personService;
    @Autowired
    BsDAO bsDAO;
    @Autowired
    ChrmanagementService chrmanagementService;
    @Autowired
    PolicyDAO policyDAO;
    @GetMapping("/api/admin/bs/list")
    public Result listBss() {
        return null;//ResultFactory.buildSuccessResult(bsService.list());
    }
    @GetMapping("/api/admin/bss/list")
    public Result listBs() {
        return ResultFactory.buildSuccessResult(bsService.lists());
    }

    @PutMapping("/api/admin/bs/editBs")
    public Result editBs(@RequestBody Bs requestBs) {
        bsService.editBs(requestBs);
        return ResultFactory.buildSuccessResult("修改用户信息成功");
    }

    @DeleteMapping("/api/admin/bs/deleteBs/{id}")
    public Result deleteBs(@PathVariable("id") int id) {
        bsService.delete(id);
        return ResultFactory.buildSuccessResult("删除成功");
    }

    @PostMapping("/api/admin/bs/addBs")
    public Result addBs(@RequestBody Bs requestBs) {
        String cardid=requestBs.getCardid();
        String illname=requestBs.getIllness();
        System.out.println(cardid);
        Chrmanagement chrmanagement=chrmanagementService.findByCardidAndIllname(cardid,illname);
        if (chrmanagement==null){
            return ResultFactory.buildFailResult("不合法");
        }
        else if (chrmanagement!=null) {
             Date date = new Date();
             SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
             System.out.println(formatter.format(date));
            String runyear=formatter.format(date);
            Policy policy=policyDAO.findByRunyear(runyear);
            double maxline=policy.getMaxline();
            double rate =policy.getRate();
            double expenses=requestBs.getExpenses();
            System.out.println(maxline);
            System.out.println(rate);
            System.out.println(expenses);
            if (expenses<maxline){
                double amount = expenses * rate;
                 System.out.println(amount);
                requestBs.setAmount(amount);
                bsService.addBs(requestBs);
                // bsService.updateBs(amount, cardid);
            }
            else if (expenses>maxline){
                double amount = maxline * rate;
                System.out.println(amount);
                requestBs.setAmount(amount);
                bsService.addBs(requestBs);
                //bsService.updateBs(amount, cardid);
            }
             return ResultFactory.buildSuccessResult("添加成功");
         }
       else return ResultFactory.buildSuccessResult("添加成功");
    }

    @GetMapping("/api/searchx")
    public Result searchResult(@RequestParam("cardid") String cardid) {
        Person p= personService.Searchx(cardid);
        String isch=p.getIsch();
            System.out.println(isch);
            System.out.println(cardid);
        if ("".equals(cardid)) {
            return ResultFactory.buildFailResult("请输入");
        }
        if (isch==null) {
            return ResultFactory.buildFailResult("您未参合");
        }
        else
            return ResultFactory.buildSuccessResult(bsService.list(cardid));

    }
}
