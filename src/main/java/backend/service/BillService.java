package backend.service;

import backend.dao.impl.HibernateDao;
import backend.dao.service.BasicDatabaseService;
import backend.entity.Bill;
import backend.entity.DataPackage;
import backend.parameter.bill.BillAddParameter;
import backend.parameter.bill.BillQueryParameter;
import backend.parameter.data.DataQueryParameter;
import backend.response.commonResponse.DataQueryResponse;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class BillService {
    BasicDatabaseService<Bill> billService;

    public BillService() {
        this.billService=new HibernateDao<>(new Bill());
    }

    public void addBill(BillAddParameter param){
            billService.add(new Bill(param.getPhoneNumber(),param.getEmailAddress(),param.getUid(),param.getProvince(),param.getCity(),param.getDataType(),param.getType()));
    }


    public void sendBill(String id){
       Bill bill= billService.findByKey(id);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳

        bill.setLatest_time(date);
        billService.update(bill);

    }

    public Bill[] searchBills(BillQueryParameter param){
        ArrayList<String> queryStr=new ArrayList<>();

            queryStr.add(" d.type="+param.getType()+" ");

        if(param.getBid()!=null&&!param.getBid().equals("")){
            queryStr.add(" d.bid='"+param.getBid()+"' ");
        }
        if(param.getProvince()!=null&&!param.getProvince().equals("")){
            queryStr.add(" d.publicationDate='"+param.getProvince()+"' ");
        }
        if(param.getCity()!=null&&!param.getCity().equals("")){
            queryStr.add(" d.responseInstitute='"+param.getCity()+"' ");
        }
        if(param.getDate()!=null&&!param.getDate().equals("")){
            queryStr.add(" d.responsePerson='"+param.getDate()+"' ");
        }

        String query="select  d from Bill d  ";

        if(queryStr.size()>0){
            query=query+" where ";
        }

        for(int i=0;i<queryStr.size();i++){
            query=query+queryStr.get(i);
            if(i!=queryStr.size()-1){
                query=query+" and ";
            }
        }

        ArrayList<Bill> bills=billService.executeQuerySql(query);

        Bill[] res= new Bill[bills.size()];
        res=bills.toArray(res);

        return res;

    }
}
