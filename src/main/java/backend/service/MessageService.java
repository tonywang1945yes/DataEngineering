package backend.service;

import backend.dao.impl.HibernateDao;
import backend.dao.service.BasicDatabaseService;
import backend.entity.Corporation;
import backend.entity.Custom;
import backend.parameter.bill.BillAddParameter;
import backend.parameter.message.CorporationAddParameter;
import backend.parameter.message.CustomAddParameter;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    BasicDatabaseService<Corporation> corporationService;
    BasicDatabaseService<Custom> customService;

    public MessageService() {
        this.corporationService = new HibernateDao<>(new Corporation());
        this.customService = new HibernateDao<>(new Custom());
    }

    public void addCorporation(CorporationAddParameter param) {
        corporationService.add(new Corporation(param.getContact(), param.getUid(), param.getRequirement(), param.getStatus(), param.getImportance()));
    }

    public void addCustom(CustomAddParameter param) {
        customService.add(new Custom(param.getContact(), param.getUid(), param.getRequirement(), param.getStatus(), param.getImportance(), param.getYear(), param.getName(), param.getProvince(), param.getCity()));
    }
}
