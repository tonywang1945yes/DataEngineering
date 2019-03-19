package backend.service;

import backend.dao.impl.HibernateDao;
import backend.dao.service.BasicDatabaseService;
import backend.entity.DataPackage;
import backend.parameter.data.DataAddParameter;
import backend.parameter.data.DataQueryParameter;
import backend.parameter.data.DataUpdateParameter;
import backend.response.commonResponse.DataQueryResponse;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

@Service
public class DataService {
    BasicDatabaseService<DataPackage> dataService;

    public DataService() {
        dataService = new HibernateDao<>(new DataPackage());
    }

    public void addData(DataAddParameter param) {
        int id = (int) (Math.random() * 900000 + 100000);
        String dataId = "d" + Integer.toString(id);
        DataPackage dataPackage = new DataPackage(dataId, param.getYear(), param.getDataName(), param.getPublicationDate(), param.getInputDate(),
                param.getFirstResult(), param.getFinalResult(), param.getSourceUrl(), param.getResponseInstitute(), param.getResponsePerson(), param.getUrl(),
                param.getProvince(), param.getCity(), param.getDataType(), 0, "");
        dataService.add(dataPackage);
    }

    public void deleteData(String id) {
        dataService.delete(id);
    }

    public void updateData(DataUpdateParameter param) {
        DataPackage dataPackage = dataService.findByKey(param.getId());
        dataPackage.setCity(param.getCity());
        dataPackage.setDataName(param.getDataName());
        dataPackage.setDataType(param.getDataType());
        dataPackage.setFinalResult(param.getFinalResult());
        dataPackage.setFirstResult(param.getFirstResult());
        dataPackage.setInputDate(param.getInputDate());
        dataPackage.setProvince(param.getProvince());
        dataPackage.setPublicationDate(param.getPublicationDate());
        dataPackage.setResponseInstitute(param.getResponseInstitute());
        dataPackage.setResponsePerson(param.getResponsePerson());
        dataPackage.setSourceUrl(param.getSourceUrl());
        dataPackage.setUrl(param.getUrl());
        dataPackage.setYear(param.getYear());
        dataService.update(dataPackage);
    }

    public DataQueryResponse searchData(DataQueryParameter param) {
        ArrayList<String> queryStr = new ArrayList<>();
        if (param.getDataName() != null && !param.getDataName().equals("")) {
            queryStr.add(" d.dataName='" + param.getDataName() + "' ");
        }
        if (param.getYear() != null && !param.getYear().equals("")) {
            queryStr.add(" d.year='" + param.getYear() + "' ");
        }
        if (param.getPublicationDate() != null && !param.getPublicationDate().equals("")) {
            queryStr.add(" d.publicationDate='" + param.getPublicationDate() + "' ");
        }
        if (param.getResponseInstitute() != null && !param.getResponseInstitute().equals("")) {
            queryStr.add(" d.responseInstitute='" + param.getResponseInstitute() + "' ");
        }
        if (param.getResponsePerson() != null && !param.getResponsePerson().equals("")) {
            queryStr.add(" d.responsePerson='" + param.getResponsePerson() + "' ");
        }
        if (param.getProvince() != null && !param.getProvince().equals("")) {
            queryStr.add(" d.province='" + param.getProvince() + "' ");
        }
        if (param.getCity() != null && !param.getCity().equals("")) {
            queryStr.add(" d.city='" + param.getCity() + "' ");
        }
        if (param.getDataType() != null && !param.getDataType().equals("")) {
            queryStr.add(" d.dataType='" + param.getDataType() + "' ");
        }
        if (param.getDownloadDate() != null && !param.getDownloadDate().equals("")) {
            queryStr.add(" d.downloadDate='" + param.getDownloadDate() + "' ");
        }

        String query = "select  d from DataPackage d  ";

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
//        ArrayList<DataPackage> validDatas = new ArrayList<DataPackage>();
//        for (int i = (param.getPage() - 1) * 10; i < param.getPage() * 10; i++) {
//            if (i >= datas.size()) {
//                break;
//            } else {
//                validDatas.add(datas.get(i));
//            }
//        }
        DataPackage[] res = new DataPackage[datas.size()];
        res = datas.toArray(res);

        return new DataQueryResponse(res, datas.size());

    }
}
