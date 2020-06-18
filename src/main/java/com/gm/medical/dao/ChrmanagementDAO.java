package com.gm.medical.dao;

import com.gm.medical.entity.Bs;
import com.gm.medical.entity.Chrmanagement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Evan
 */
public interface ChrmanagementDAO extends JpaRepository<Chrmanagement,Integer> {


    Chrmanagement findByChronid(String chronid);

    List<Chrmanagement> findAllByCardid(String cardid);

    Chrmanagement findByCardidAndIllname(String cardid, String illname);
}
