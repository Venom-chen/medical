package com.gm.medical.dao;

import com.gm.medical.entity.Family;
import com.gm.medical.entity.Institution;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Evan
 * @date 2019/4
 */
public interface InstitutionDAO extends JpaRepository<Institution,Integer> {

    Institution findByAreacode(String Areacode);

}
