package com.gm.medical.service;

import com.gm.medical.dao.AdminUserRoleDAO;
import com.gm.medical.dao.InstitutionDAO;
import com.gm.medical.dao.MedicalDAO;
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
public class MedicalService {
    @Autowired
    MedicalDAO medicalDAO;

    public List<Medical> list() {
        return medicalDAO.findAll();
    }

    public void editMedical(Medical medical) {

        Medical MInDB = medicalDAO.findByZzjgbm(medical.getZzjgbm());
        MInDB.setAreacode(medical.getAreacode());
        MInDB.setDqbm(medical.getDqbm());
        MInDB.setFrdb(medical.getFrdb());
        MInDB.setJgmc(medical.getJgmc());
        MInDB.setKysj(medical.getKysj());
        MInDB.setLsgx(medical.getLsgx());
        MInDB.setZczj(medical.getZczj());
        MInDB.setZgdw(medical.getZgdw());
        medicalDAO .save(MInDB);
    }

    public void delete(int id) {
        medicalDAO.deleteById(id);
    }

    public void addMedical(Medical medical){
        medicalDAO.save(medical);
    }
}
