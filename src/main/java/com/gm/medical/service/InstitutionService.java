package com.gm.medical.service;


import com.gm.medical.dao.InstitutionDAO;

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
public class InstitutionService {
    @Autowired
    InstitutionDAO institutionDAO;

    public List<Institution> list() {
        return institutionDAO.findAll();
    }

    public void editInstitution(Institution institution) {

        Institution InDB = institutionDAO.findByAreacode(institution.getAreacode());
        InDB.setAgencode(institution.getAgencode());
        InDB.setAgenname(institution.getAgenname());
        institutionDAO .save(InDB);
    }

    public void delete(int id) {
        institutionDAO.deleteById(id);
    }

    public void addInstitution(Institution institution){
        institutionDAO.save(institution);
    }
}
