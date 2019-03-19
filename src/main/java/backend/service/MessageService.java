package backend.service;

import backend.dao.impl.HibernateDao;
import backend.dao.service.BasicDatabaseService;
import backend.entity.Corporation;
import backend.entity.Custom;
import backend.parameter.message.CorporationAddParameter;
import backend.parameter.message.CustomAddParameter;
import backend.parameter.message.MessageGetParameter;
import backend.parameter.message.MessageUpdateParameter;
import backend.response.commonResponse.CorporationQueryResponse;
import backend.response.commonResponse.CustomQueryResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MessageService {
    BasicDatabaseService<Corporation> corporationService;
    BasicDatabaseService<Custom> customService;

    public MessageService() {
        this.corporationService = new HibernateDao<>(new Corporation());
        this.customService = new HibernateDao<>(new Custom());
    }

    public void addCorporation(CorporationAddParameter param) {
        corporationService.add(new Corporation(param.getUid(), param.getContact(), param.getRequirement(), param.getStatus(), param.getImportance()));
    }

    public void addCustom(CustomAddParameter param) {
        customService.add(new Custom(param.getUid(), param.getContact(), param.getRequirement(), param.getStatus(), param.getImportance(), param.getYear(), param.getName(), param.getProvince(), param.getCity()));
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

    public void markImportance(String id, MessageUpdateParameter param) {
        if (id.startsWith("m1")) {
            Corporation c = corporationService.findByKey(id);
            c.setImportance(param.getHasImportance());
            corporationService.update(c);
        } else if (id.startsWith("m2")) {
            Custom c = customService.findByKey(id);
            c.setImportance(param.getHasImportance());
            customService.update(c);
        }
    }

    public synchronized void deleteMsg(String id) {
        if (id.startsWith("m1")) {
            corporationService.delete(id);
        } else if (id.startsWith("m2")) {
            customService.delete(id);
        }
    }

    public synchronized CorporationQueryResponse getCorporationMsg(MessageGetParameter param) {
        ArrayList<Corporation> res = new ArrayList<>();
        if (param.getHasRead() == -1 && param.getHasImportance() == -1) {
            if (param.getDate() != null && !param.getDate().equals("")) {
                res = corporationService.executeQuerySql("select c from Corporation c where c.date = '" + param.getDate() + "'");
            } else {
                res = corporationService.executeQuerySql("select c from Corporation c ");
            }
        } else if (param.getHasImportance() == 1) {
            res = corporationService.executeQuerySql("select c from Corporation c where c.importance = 1");
        } else {
            if (param.getHasRead() == 1) {
                res = corporationService.executeQuerySql("select c from Corporation c where c.status = 1");
            } else {
                res = corporationService.executeQuerySql("select c from Corporation c where c.status = 0");
            }
        }
        Corporation[] result = new Corporation[res.size()];
        result = res.toArray(result);
        return new CorporationQueryResponse(result, res.size());
    }

    public synchronized CustomQueryResponse getCustomMsg(MessageGetParameter param) {
        ArrayList<Custom> res = new ArrayList<>();
        if (param.getHasRead() == -1 && param.getHasImportance() == -1) {
            if (param.getDate() != null && !param.getDate().equals("")) {
                res = customService.executeQuerySql("select c from Custom c where c.date = '" + param.getDate() + "'");
            } else {
                res = customService.executeQuerySql("select c from Custom c ");
            }
        } else if (param.getHasImportance() == 1) {
            res = customService.executeQuerySql("select c from Custom c where c.importance = 1");
        } else {
            if (param.getHasRead() == 1) {
                res = customService.executeQuerySql("select c from Custom c where c.status = 1");
            } else {
                res = customService.executeQuerySql("select c from Custom c where c.status = 0");
            }
        }
        Custom[] result = new Custom[res.size()];
        result = res.toArray(result);
        return new CustomQueryResponse(result, res.size());
    }
}
