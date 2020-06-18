package com.gm.medical.dao;

import com.gm.medical.entity.Area;
import com.gm.medical.entity.Chronicdis;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Evan
 * @date 2019/4
 */
public interface ChronicdisDAO extends JpaRepository<Chronicdis,Integer> {

    Chronicdis findByIllcode(String illcode);
}
