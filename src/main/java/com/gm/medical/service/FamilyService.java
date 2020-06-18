package com.gm.medical.service;



import com.gm.medical.dao.FamilyDAO;

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
public class FamilyService {
    @Autowired
    FamilyDAO familyDAO;

    public List<Family> list() {
        return familyDAO.findAll();
    }

    public void editFamily(Family family) {

        Family fInDB = familyDAO.findByFamicode(family.getFamicode());
        fInDB.setTown(family.getTown());
        fInDB.setPopunum(family.getPopunum());
        fInDB.setAgrinum(family.getAgrinum());
        fInDB.setCreattime(family.getCreattime());
        fInDB.setHousepro(family.getHousepro());
        fInDB.setVillage(family.getVillage());
        fInDB.setAddress(family.getAddress());
        familyDAO .save(fInDB);
    }

    public void delete(int id) {
        familyDAO.deleteById(id);
    }

    public void addFamily(Family family){
        familyDAO.save(family);
    }

    public void addNum(String famicode) {
        familyDAO.addNum(famicode);
    }
    public void addNums(String famicode) {
        familyDAO.addNums(famicode);
    }
}
