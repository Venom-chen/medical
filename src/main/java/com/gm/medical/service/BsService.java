package com.gm.medical.service;

import com.gm.medical.dao.BsDAO;
import com.gm.medical.dao.ChrmanagementDAO;
import com.gm.medical.entity.Area;
import com.gm.medical.entity.Bs;
import com.gm.medical.entity.Chrmanagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 */
@Service
public class BsService {

    @Autowired
    BsDAO bsDAO;
    @Autowired
    ChrmanagementDAO chrmanagementDAO;
    public List<Chrmanagement> list(String cardid) {
        return chrmanagementDAO.findAllByCardid(cardid);
    }
    public List<Bs> lists() {
        return bsDAO.findAll();
    }
    public void editBs(Bs bs) {

        Bs bsInDB = bsDAO.findByIllness(bs.getIllness());
        bsInDB.setExpenses(bs.getExpenses());
        bsInDB.setClinicaltime(bs.getClinicaltime());
        bsInDB.setInvoiceno(bs.getInvoiceno());
        bsInDB.setCardid(bs.getCardid());
        bsDAO.save(bsInDB);
    }

    public void delete(int id) {
        bsDAO.deleteById(id);
    }

    public void addBs(Bs bs){
        bsDAO.save(bs);
    }


    public void updateBs(double amount, String cardid) {
        Bs bsInDB = bsDAO.findByCardid(cardid);
        bsInDB.setAmount(amount);
        bsDAO.save(bsInDB);
    }
}
