package com.gm.medical.dao;

import com.gm.medical.entity.Bs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Evan
 * @date 2019/4
 */
public interface BsDAO extends JpaRepository<Bs,Integer> {


    Bs findByIllness(String illness);
    Bs findByCardid(String cardid);
}
