package backend.service;

import backend.dao.impl.HibernateDao;
import backend.dao.service.BasicDatabaseService;
import backend.entity.DataPackage;
import backend.parameter.data.DataAddParameter;
import org.springframework.stereotype.Service;

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
}
