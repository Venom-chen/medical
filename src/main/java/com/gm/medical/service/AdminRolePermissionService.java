package com.gm.medical.service;

import com.gm.medical.dao.AdminRolePermissionDAO;
import com.gm.medical.entity.AdminRolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Evan
 * @date 2019/11
 */
@Service
public class AdminRolePermissionService {
    @Autowired
    AdminRolePermissionDAO adminRolePermissionDAO;

    List<AdminRolePermission> findAllByRid(int rid) {
        return adminRolePermissionDAO.findAllByRid(rid);
    }

//    @Modifying
    @Transactional
    public void savePermChanges(int rid, Map<String, List<Integer>> permIds) {
        adminRolePermissionDAO.deleteAllByRid(rid);
        List<AdminRolePermission> rps = new ArrayList<>();
        for (Integer pid : permIds.get("permIds")) {
            AdminRolePermission rp = new AdminRolePermission();
            rp.setPid(pid);
            rp.setRid(rid);
            rps.add(rp);
        }
        adminRolePermissionDAO.saveAll(rps);
    }
}
