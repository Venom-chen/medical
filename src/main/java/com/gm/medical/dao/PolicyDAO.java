package com.gm.medical.dao;

import com.gm.medical.entity.Person;
import com.gm.medical.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Evan
 * @date 2019/4
 */
public interface PolicyDAO extends JpaRepository<Policy,Integer> {
    Policy findById(int id);
    Policy findByRunyear(String runyear);
}
