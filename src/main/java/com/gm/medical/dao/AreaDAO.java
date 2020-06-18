package com.gm.medical.dao;

import com.gm.medical.entity.Area;
import com.gm.medical.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Evan
 * @date 2019/4
 */
public interface AreaDAO extends JpaRepository<Area,Integer> {


    Area findByAreacode(String areacode);
}
