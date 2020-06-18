package com.gm.medical.service;

import com.gm.medical.dao.AdminUserRoleDAO;
import com.gm.medical.dao.MedicalDAO;
import com.gm.medical.dao.PersonDAO;
import com.gm.medical.dao.UserDAO;
import com.gm.medical.dto.UserDTO;
import com.gm.medical.entity.*;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 */
@Service
public class PersonService {
    @Autowired
    PersonDAO personDAO;

    public List<Person> list() {
        return personDAO.findAll();
    }

    public void editPerson(String persname, String Date, String chid, int chinvoice) {

        personDAO.updateCode(persname,Date,chid,chinvoice);
    }

    public void delete(int id) {
        personDAO.deleteById(id);
    }

    public void addPerson(Person person){
        personDAO.save(person);
    }

    public Person findByPersname(String persname) {
        return personDAO.findByPersname(persname);
    }

    public List<Person> Search(String persname) {

        return personDAO.findAllByPersname(persname);
    }

    public Person Searchx(String cardid) {
        return personDAO.getIschByCardid(cardid);
    }

    public void editPersons(Person person) {
        Person PInDB = personDAO.findByPersname(person.getPersname());
        PInDB.setFamicode(person.getFamicode());
        PInDB.setRelation(person.getRelation());
        PInDB.setSex(person.getSex());
        PInDB.setBirthday(person.getBirthday());
        PInDB.setAge(person.getAge());
        PInDB.setCardid(person.getCardid());
        personDAO .save(PInDB);
    }
}
