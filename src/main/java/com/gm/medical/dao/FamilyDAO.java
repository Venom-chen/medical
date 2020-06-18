package com.gm.medical.dao;


import com.gm.medical.entity.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface FamilyDAO extends JpaRepository<Family,Integer> {

    Family findByFamicode(String famicode);

    @Modifying
    @Query(nativeQuery = true, value = "update t_family set popunum = popunum+1  where famicode =:famicode ")
    @Transactional
    void addNum(String famicode);

    @Modifying
    @Query(nativeQuery = true, value = "update t_family set agrinum = agrinum+1  where famicode =:famicode ")
    @Transactional
    void addNums(String famicode);

    @Query(nativeQuery = true, value = "SELECT MAX(famicode) FROM t_family")
    String getFamicode();
}
