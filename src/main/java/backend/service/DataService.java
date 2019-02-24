package backend.service;

import backend.dao.impl.HibernateDao;
import backend.dao.service.BasicDatabaseService;
import backend.entity.DataPackage;
import backend.parameter.data.DataAddParameter;
import backend.parameter.data.DataQueryParameter;
import backend.response.commonResponse.DataQueryResponse;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

@Service
public class DataService {
    BasicDatabaseService<DataPackage> dataService;
    public DataService() {
        dataService=new HibernateDao<>(new DataPackage());
    }

    public void addData(DataAddParameter param){
        int id=(int)(Math.random()*900000+100000);
        String dataId="d"+Integer.toString(id);
        DataPackage dataPackage=new DataPackage(dataId,param.getYear(),param.getDataName(),param.getPublicationDate(),param.getInputDate(),
                param.getFirstResult(),param.getFinalResult(),param.getSourceUrl(),param.getResponseInstitute(),param.getResponsePerson(),param.getUrl());
        dataService.add(dataPackage);
    }

    public DataQueryResponse searchData(DataQueryParameter param){
        ArrayList<String> queryStr=new ArrayList<>();
        if(param.getDataName()!=null&&!param.getDataName().equals("")){
            queryStr.add(" d.dataName='"+param.getDataName()+"' ");
        }
        if(param.getYear()!=null&&!param.getYear().equals("")){
            queryStr.add(" d.year='"+param.getYear()+"' ");
        }
        if(param.getPublicationDate()!=null&&!param.getPublicationDate().equals("")){
            queryStr.add(" d.publicationDate='"+param.getPublicationDate()+"' ");
        }
        if(param.getResponseInstitute()!=null&&!param.getResponseInstitute().equals("")){
            queryStr.add(" d.responseInstitute='"+param.getResponseInstitute()+"' ");
        }
        if(param.getResponsePerson()!=null&&!param.getResponsePerson().equals("")){
            queryStr.add(" d.responsePerson='"+param.getResponsePerson()+"' ");
        }

        String query="select  d from DataPackage d  ";

        if(queryStr.size()>0){
            query=query+" where ";
        }

        for(int i=0;i<queryStr.size();i++){
            query=query+queryStr.get(i);
            if(i!=queryStr.size()-1){
                query=query+" and ";
            }
        }

        ArrayList<DataPackage> datas=dataService.executeQuerySql(query);

        DataPackage[] res= new DataPackage[datas.size()];
        res=datas.toArray(res);

        return new DataQueryResponse(res,datas.size());

    }
}
