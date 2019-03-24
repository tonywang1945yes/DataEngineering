package backend.service;

import backend.dao.impl.HibernateDao;
import backend.dao.service.BasicDatabaseService;
import backend.entity.Bill;
import backend.entity.DataPackage;
import backend.entity.User;
import backend.parameter.bill.BillAddParameter;
import backend.parameter.bill.BillQueryParameter;
import backend.response.commonResponse.BillQueryResponse;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class BillService {
    BasicDatabaseService<Bill> billService;
    BasicDatabaseService<User> userService;
    BasicDatabaseService<DataPackage> dataService;

    public BillService() {
        this.billService = new HibernateDao<>(new Bill());
        this.userService = new HibernateDao<>(new User());
        this.dataService = new HibernateDao<>(new DataPackage());
    }

    public void addBill(BillAddParameter param) {
        billService.add(new Bill(param.getPhoneNumber(), param.getEmailAddress(), param.getUid(), param.getProvince(), param.getCity(), param.getType(), param.getDataType()));
        User user = userService.findByKey(param.getUid());
        user.setBills(user.getBills() + 1);
        if (param.getType() == 0) {
            user.setBillAmount(user.getBillAmount() + 1);
        } else if (param.getType() == 1) {
            user.setBillAmount(user.getBillAmount() + 10);
        } else if (param.getType() == 2) {
            user.setBillAmount(user.getBillAmount() + 100);
        } else if (param.getType() == 3) {
            // 下载
            user.setDownloads(user.getDownloads() + 1);
            // 按照假设，每个市只有唯一的数据，所以可以定向检索
            String query = "select  d from DataPackage d  ";
            ArrayList<String> queryStr = new ArrayList<>();
            if (param.getProvince() != null && !param.getProvince().equals("")) {
                queryStr.add(" d.province='" + param.getProvince() + "' ");
            }
            if (param.getCity() != null && !param.getCity().equals("")) {
                queryStr.add(" d.city='" + param.getCity() + "' ");
            }
            if (queryStr.size() > 0) {
                query = query + " where ";
            }
            for (int i = 0; i < queryStr.size(); i++) {
                query = query + queryStr.get(i);
                if (i != queryStr.size() - 1) {
                    query = query + " and ";
                }
            }
            ArrayList<DataPackage> datas = dataService.executeQuerySql(query);
            if (datas.size() != 0) {
                DataPackage data = datas.get(0);
                data.setDownloads(data.getDownloads() + 1);
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
                String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
                data.setDownloadDate(date);
                dataService.update(data);
            }
        }
        userService.update(user);
    }

    public synchronized void deleteBill(String id) {
        billService.delete(id);
    }


    public synchronized void sendBill(String id) {
        Bill bill = billService.findByKey(id);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        bill.setLatest_time(date);
        billService.update(bill);
    }

    public BillQueryResponse searchBills(BillQueryParameter param) {
        ArrayList<String> queryStr = new ArrayList<>();
        if (param.getType() != -1) {
            queryStr.add(" d.type=" + param.getType() + " ");
        }
        if (param.getBid() != null && !param.getBid().equals("")) {
            queryStr.add(" d.bid='" + param.getBid() + "' ");
        }
        if (param.getProvince() != null && !param.getProvince().equals("")) {
            queryStr.add(" d.province='" + param.getProvince() + "' ");
        }
        if (param.getCity() != null && !param.getCity().equals("")) {
            queryStr.add(" d.city='" + param.getCity() + "' ");
        }
        if (param.getTime() != null && !param.getTime().equals("")) {
            queryStr.add(" d.time='" + param.getTime() + "' ");
        }

        String query = "select  d from Bill d  ";

        if (queryStr.size() > 0) {
            query = query + " where ";
        }

        for (int i = 0; i < queryStr.size(); i++) {
            query = query + queryStr.get(i);
            if (i != queryStr.size() - 1) {
                query = query + " and ";
            }
        }

        ArrayList<Bill> bills = billService.executeQuerySql(query);

        Bill[] res = new Bill[bills.size()];
        res = bills.toArray(res);

        return new BillQueryResponse(res, bills.size());

    }
}
