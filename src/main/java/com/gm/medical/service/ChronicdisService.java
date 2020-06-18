package com.gm.medical.service;

import com.gm.medical.dao.AdminUserRoleDAO;
import com.gm.medical.dao.AreaDAO;
import com.gm.medical.dao.ChronicdisDAO;
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
public class ChronicdisService {
    @Autowired
    ChronicdisDAO chronicdisDAO;

    public List<Chronicdis> list() {
        return chronicdisDAO.findAll();
    }

    public void editChronicdis(Chronicdis chronicdis) {

        Chronicdis areaInDB = chronicdisDAO.findByIllcode(chronicdis.getIllcode());
        areaInDB.setIllname(chronicdis.getIllname());
        areaInDB.setPycode(chronicdis.getPycode());
        areaInDB.setWbcode(chronicdis.getWbcode());
        chronicdisDAO .save(areaInDB);
    }

    public void delete(int id) {
        chronicdisDAO.deleteById(id);
    }

    public void addChronicdis(Chronicdis chronicdis){
        chronicdisDAO.save(chronicdis);
    }
}
