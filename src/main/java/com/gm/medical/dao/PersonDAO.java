package com.gm.medical.dao;

import com.gm.medical.entity.Person;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Evan
 */
public interface PersonDAO extends JpaRepository<Person,Integer> {
    Person findByFamicode(String famicode);

    //List<Person> findAllByFamicode(String persname);
    @Query(nativeQuery = true, value = "SELECT * FROM t_person WHERE t_person.famicode IN(\n" +
            "SELECT t_person.famicode FROM t_person WHERE persname = ?)")
    List<Person> findAllByPersname(@Param("persname") String persname);

    Person findByPersname(String persname);

    @Query(nativeQuery = true, value = "SELECT MAX(perscode) FROM t_person")
    String getPerscode();

    @Modifying
    @Query(nativeQuery = true, value = "update t_person set isch =1, chtime =:Date, chid =:chid, chinvoice =:chinvoice  where persname =:persname ")
    @Transactional
    void updateCode( @Param("persname,Date,chid,chinvoice") String persname,String Date,String chid,int chinvoice);


    Person getIschByCardid(String cardid);
}
