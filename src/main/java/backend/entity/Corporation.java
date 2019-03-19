package backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Corporation {
    @Id
    @Column(name = "mid")
    String mid = "";
    @Column(name = "uid")
    String uid = "";
    @Column(name = "contact")
    String contact = "";
    @Column(name = "requirement")
    String requirement = "";
    @Column(name = "status")
    int status = 0;//0,未读；1，已读
    @Column(name = "importance")
    int importance = 0;//0,不重要；1，重要
    @Column(name = "date")
    String date;

    public Corporation() {
    }

    public Corporation(String uid, String contact, String requirement, int status, int importance) {
        int id = 100000 + (int) (Math.random() * 900000);
        String random_id = "m1" + Integer.toString(id);
        this.mid = random_id;
        this.uid = uid;
        this.contact = contact;
        this.requirement = requirement;
        this.status = status;
        this.importance = importance;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        this.date = date;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }
}
