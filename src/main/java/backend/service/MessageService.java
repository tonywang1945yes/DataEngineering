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

    public void markRead(String id) {
        if (id.startsWith("m1")) {
            Corporation c = corporationService.findByKey(id);
            c.setStatus(1);
            corporationService.update(c);
        } else if (id.startsWith("m2")) {
            Custom c = customService.findByKey(id);
            c.setStatus(1);
            customService.update(c);
        }
    }

    public void markImportance(String id) {
        if (id.startsWith("m1")) {
            Corporation c = corporationService.findByKey(id);
            c.setImportance(1);
            corporationService.update(c);
        } else if (id.startsWith("m2")) {
            Custom c = customService.findByKey(id);
            c.setImportance(1);
            customService.update(c);
        }
    }
}
