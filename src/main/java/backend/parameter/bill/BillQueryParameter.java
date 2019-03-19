package backend.parameter.bill;

public class BillQueryParameter {
    int type = 0;
    String bid;
    String province;
    String city;
    String time;

    public BillQueryParameter() {
    }

    public BillQueryParameter(int type, String bid, String province, String city, String time) {
        this.type = type;
        this.bid = bid;
        this.province = province;
        this.city = city;
        this.time = time;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
