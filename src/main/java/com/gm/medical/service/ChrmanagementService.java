package com.gm.medical.service;

import com.gm.medical.dao.ChrmanagementDAO;
import com.gm.medical.entity.Chrmanagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 */
@Service
public class ChrmanagementService {
    @Autowired
    ChrmanagementDAO chrmanagementDAO;

    public List<Chrmanagement> list() {
        return chrmanagementDAO.findAll();
    }

    public void editChronicmanagement(Chrmanagement chrmanagement) {

        Chrmanagement chInDB = chrmanagementDAO.findByChronid(chrmanagement.getChronid());
        chInDB.setCardid(chrmanagement.getCardid());
        chInDB.setRuralcard(chrmanagement.getRuralcard());
        chInDB.setIllname(chrmanagement.getIllname());
        chInDB.setStarttime(chrmanagement.getStarttime());
        chInDB.setEndtime(chrmanagement.getEndtime());
        chrmanagementDAO .save(chInDB);
    }

    public void delete(int id) {
        chrmanagementDAO.deleteById(id);
    }

    public void addChrmanagement(Chrmanagement chrmanagement){
        chrmanagementDAO.save(chrmanagement);
    }

    public Chrmanagement findByCardidAndIllname(String cardid, String illname) {
       return chrmanagementDAO.findByCardidAndIllname(cardid,illname);
    }
}
