package backend.service;

import backend.dao.impl.HibernateDao;
import backend.dao.service.BasicDatabaseService;
import backend.entity.Bill;
import backend.parameter.bill.BillAddParameter;
import org.springframework.stereotype.Service;

@Service
public class BillService {
    BasicDatabaseService<Bill> billService;

    public BillService() {
        this.billService=new HibernateDao<>(new Bill());
    }

    public void addBill(BillAddParameter param){
            billService.add(new Bill(param.getPhoneNumber(),param.getEmailAddress(),param.getUid(),param.getProvince(),param.getCity(),param.getDataType(),param.getType()));
    }
}
