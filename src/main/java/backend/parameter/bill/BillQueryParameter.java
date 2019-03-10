package backend.parameter.bill;

public class BillQueryParameter {
    int type=0;
    String bid;
    String province;
    String city;
    String date;

    public BillQueryParameter(int type, String bid, String province, String city, String date) {
        this.type = type;
        this.bid = bid;
        this.province = province;
        this.city = city;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BillQueryParameter() {
    }
}
