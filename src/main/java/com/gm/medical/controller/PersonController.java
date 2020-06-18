package com.gm.medical.controller;

import com.gm.medical.dao.FamilyDAO;
import com.gm.medical.dao.PersonDAO;
import com.gm.medical.entity.*;
import com.gm.medical.result.Result;
import com.gm.medical.result.ResultFactory;
import com.gm.medical.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User controller.
 *
 */

@RestController
public class PersonController {

    @Autowired
    PersonService personService;
    @Autowired
    FamilyService familyService;
    @Autowired
    PersonDAO personDAO;
    @Autowired
    FamilyDAO familyDAO;
    @GetMapping("/api/admin/person/list")
     public Result listPerson() {
        return ResultFactory.buildSuccessResult(personService.list());
    }

    @GetMapping("/api/admin/pers/list")
    public Result listPersons() {
        return null;
    }


    @PutMapping("/api/admin/person/editPerson")
    public Result editPersons(@RequestBody Person requestPerson) {
        personService.editPersons(requestPerson);
        return ResultFactory.buildSuccessResult("修改用户信息成功");
    }

    @DeleteMapping("/api/admin/person/editPersons/{persname}")
    public Result editPerson(@PathVariable("persname") String persname) {
        Person p =personService.findByPersname(persname);
        if (p.getIsch()==null) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String Date =formatter.format(date);
        String chid=p.getCardid();
        int chinvoice= (int) (Math.random()*1000);
        System.out.println(chinvoice);
        personService.editPerson(persname,Date,chid,chinvoice);
        return ResultFactory.buildSuccessResult("参合成功");
        }
        else return ResultFactory.buildFailResult("您已参合");
    }

    @DeleteMapping("/api/admin/person/deletePerson/{id}")
    public Result deletePerson(@PathVariable("id") int id) {
        personService.delete(id);
        return ResultFactory.buildSuccessResult("删除成功");
    }

    @PostMapping("/api/admin/person/addPerson")
    public Result addPerson(@RequestBody Person requestPerson) {
        //自动生成家庭编号和个人编码
        String fc =familyDAO.getFamicode();
        BigInteger Famicode= new BigInteger(fc);
        BigInteger fcd=Famicode.add(new BigInteger("1"));
        String famicode=fcd.toString();
        String str="1";
        String str2="00";
        requestPerson.setRelation(str);//户主
        requestPerson.setFamicode(famicode);//家庭编号
        String pc=famicode+str2;
        BigInteger psc=new BigInteger(pc);
        BigInteger pscd=psc.add(new BigInteger("1"));
        String Personcode=pscd.toString();
        requestPerson.setPerscode(Personcode);
        personService.addPerson(requestPerson);
        String isrural =requestPerson.getIsrural();
        familyService.addNum(famicode);
        if (isrural.equals(str)){
            familyService.addNums(famicode);
        }
        return ResultFactory.buildSuccessResult("修改用户成功");
    }
    @PostMapping("/api/admin/persons/addPerson")
    public Result addPersons(@RequestBody Person requestPerson) {
        String famicode =requestPerson.getFamicode();
        String str2="01";
        String pc=famicode+str2;
        BigInteger psc=new BigInteger(pc);
        BigInteger pscd=psc.add(new BigInteger("1"));
        String Personcode=pscd.toString();
        requestPerson.setPerscode(Personcode);
        requestPerson.setFamicode(famicode);
        personService.addPerson(requestPerson);
        System.out.println(famicode);
        System.out.println(Personcode);
        String isrural =requestPerson.getIsrural();
        String str="1";
        if (isrural.equals(str)){
            familyService.addNums(famicode);
        }
        familyService.addNum(famicode);
        return ResultFactory.buildSuccessResult("修改用户成功");
    }

    @GetMapping("/api/search")
    public Result searchResult(@RequestParam("persname") String persname) {
        if ("".equals(persname)) {
            return ResultFactory.buildSuccessResult(personService.list());
        } else {
            System.out.println(personService.Search(persname));
            return ResultFactory.buildSuccessResult(personService.Search(persname));
        }
    }
}
