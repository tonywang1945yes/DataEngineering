package backend.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Custom {
    @Id
    @Column(name="mid")
    String mid="";
    @Column(name="uid")
    String uid="";
    @Column(name="contact")
    String contact="";
    @Column(name="requirment")
    String requirment="";
    @Column(name="status")
    int status=0;//0,未读；1，已读
    @Column(name="importance")
    int importance=0;//0,不重要；1，重要
    @Column(name="year")
    String year="";
    @Column(name="name")
    String name="";
    @Column(name="province")
    String province="";
    @Column(name="city")
    String city="";

    public Custom() {
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

    public String getRequirment() {
        return requirment;
    }

    public void setRequirment(String requirment) {
        this.requirment = requirment;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
