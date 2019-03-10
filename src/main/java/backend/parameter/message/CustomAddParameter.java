package backend.parameter.message;

public class CustomAddParameter {
    String uid;
    String contact;
    String requirement;
    int status;
    int importance;
    String year;
    String name;
    String province;
    String city;

    public CustomAddParameter() {
    }

    public CustomAddParameter(String uid, String contact, String requirement, int status, int importance, String year, String name, String province, String city) {
        this.uid = uid;
        this.contact = contact;
        this.requirement = requirement;
        this.status = status;
        this.importance = importance;
        this.year = year;
        this.name = name;
        this.province = province;
        this.city = city;
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
