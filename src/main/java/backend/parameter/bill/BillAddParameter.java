package backend.parameter.bill;

public class BillAddParameter {
    String phoneNumber;
    String emailAddress;
    String uid;
    String province;
    String city;
    int dataType;
    int type;

    public BillAddParameter() {
    }

    public BillAddParameter(String phoneNumber, String emailAddress, String uid, String province, String city, int dataType, int type,String dealer) {
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.uid = uid;
        this.province = province;
        this.city = city;
        this.dataType = dataType;
        this.type = type;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
