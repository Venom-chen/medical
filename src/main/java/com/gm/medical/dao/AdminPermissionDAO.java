package com.gm.medical.dao;

import com.gm.medical.entity.AdminPermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Evan
 * @date 2019/11
 */
public interface AdminPermissionDAO extends JpaRepository<AdminPermission, Integer> {
    AdminPermission findById(int id);
    List<AdminPermission> findAllByParentid(int parentid);
}
