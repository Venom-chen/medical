package com.gm.medical.dao;

import com.gm.medical.entity.Institution;
import com.gm.medical.entity.Medical;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Evan
 * @date 2019/4
 */
public interface MedicalDAO extends JpaRepository<Medical,Integer> {


    Medical findByZzjgbm(String zzjgbm);
}
