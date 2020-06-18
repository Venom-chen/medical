package com.gm.medical.dao;

import com.gm.medical.entity.AdminUserRole;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Evan
 * @date 2019/11
 */
public interface AdminUserRoleDAO extends JpaRepository<AdminUserRole,Integer> {


    @Query(nativeQuery = true, value = "SELECT user.id FROM user  WHERE judeid=?")
    int findUid(@Param("judeid") int judeid);

    void deleteAllByUid(int uid);

    AdminUserRole findAllById(int id);

   // int findid();
    @Query(nativeQuery = true, value = "SELECT admin_user_role.id FROM admin_user_role  WHERE rid=0")
    int findId();

    List<AdminUserRole> findAllByUid(int uid);

    @Query(nativeQuery = true, value = "SELECT admin_user_role.rid FROM admin_user_role  WHERE uid=?")
    int findRid(int uid);
}
