package backend.parameter.message;

public class CorporationAddParameter {
    String uid;
    String contact;
    String requirement;
    int status;
    int importance;

    public CorporationAddParameter() {
    }

    public CorporationAddParameter(String uid, String contact, String requirment, int status, int importance) {
        this.uid = uid;
        this.contact = contact;
        this.requirement = requirment;
        this.status = status;
        this.importance = importance;
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
