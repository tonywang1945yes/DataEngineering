package backend.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name="bill")
public class Bill {
    @Id
    @Column(name="bid")
    String bid;
    @Column(name="phone_number")
    String phoneNumber;
    @Column(name="email_address")
    String emailAddress;
    @Column(name="uid")
    String uid;
    @Column(name="province")
    String province;
    @Column(name="city")
    String city;
    @Column(name="time")
    String time;
    @Column(name="latest_time")
    String latest_time;
    @Column(name="type")
    int type=0;//0,更新；1，不需要更新的加工；2，需要更新的加工；3，打包下载
    @Column(name="data_type")
    int dataType=0;//0,无；1，年鉴；2，区划

    public Bill( String phoneNumber, String emailAddress, String uid, String province, String city, int type, int dataType) {
        int id=100000+(int)(Math.random()*900000);
        String random_id="b"+Integer.toString(id);
        this.bid = random_id;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.uid = uid;
        this.province = province;
        this.city = city;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        this.time = date;
        this.latest_time = "";
        this.type = type;
        this.dataType = dataType;
    }

    public Bill() {
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLatest_time() {
        return latest_time;
    }

    public void setLatest_time(String latest_time) {
        this.latest_time = latest_time;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }
}
