package com.gm.medical.service;

import com.gm.medical.dao.AdminUserRoleDAO;
import com.gm.medical.dao.PersonDAO;
import com.gm.medical.dao.PolicyDAO;
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
public class PolicyService {
    @Autowired
    PolicyDAO policyDAO;

    public List<Policy> list() {
        return policyDAO.findAll();
    }

    public void editPolicy(Policy policy) {

        Policy PInDB = policyDAO.findById(policy.getId());
        PInDB.setMaxline(policy.getMaxline());
        PInDB.setRemark(policy.getRemark());
        PInDB.setRunyear(policy.getRunyear());
        PInDB.setStatus(policy.getStatus());
        PInDB.setRate(policy.getRate());
        policyDAO .save(PInDB);
    }

    public void delete(int id) {
        policyDAO.deleteById(id);
    }

    public void addPolicy(Policy policy){
        policyDAO.save(policy);
    }
}
