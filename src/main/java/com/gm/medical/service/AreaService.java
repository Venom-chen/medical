package com.gm.medical.service;

import com.gm.medical.dao.AreaDAO;

import com.gm.medical.entity.Area;

import com.gm.medical.entity.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 */
@Service
public class AreaService {

    @Autowired
    AreaDAO areaDAO;

    public List<Area> list() {
        return areaDAO.findAll();
    }

    public void editArea(Area area) {

        Area areaInDB = areaDAO.findByAreacode(area.getAreacode());
        areaInDB.setAreaname(area.getAreaname());
        areaInDB.setGrade(area.getGrade());
        areaDAO.save(areaInDB);
    }

    public void delete(int id) {
        areaDAO.deleteById(id);
    }

    public void addArea(Area area){
        areaDAO.save(area);
    }
}
