package backend.service;

import backend.dao.impl.HibernateDao;
import backend.dao.service.BasicDatabaseService;
import backend.entity.Admin;

/**
 * @author Wen Sun
 * @date 2019-3-19
 */
public class AdminService {
    BasicDatabaseService<Admin> adminService;

    public AdminService() {
        adminService = new HibernateDao<>(new Admin());
    }

    public void setAdminName(){

    }

    public String getAdminName(){
        return null;
    }

    public void setAdminEmail(){

    }

    public void getAdminEmail(){

    }
}
