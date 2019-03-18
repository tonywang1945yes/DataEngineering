package backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "phone_number")
    String phoneNumber;
    @Column(name = "password")
    String password;
    @Column(name = "email_address")
    String emailAddress;
    @Column(name = "type")
    int type = -1;//0 教师，1 学生， 2 科研工作者
    @Column(name = "username")
    String username;
    @Column(name = "date")
    String date;//注册时间
    @Column(name = "downloads")
    int downloads = 0;
    @Column(name = "bills")
    int bills = 0;
    @Column(name = "bill_amount")
    int billAmount = 0;

    public User() {
    }

    public User(String phoneNumber, String password, String emailAddress, int type, String username, int downloads, int bills, int billAmount) {
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.emailAddress = emailAddress;
        this.type = type;
        this.username = username;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 置日期格式
        String dateString = df.format(new Date());// new Date()为获取当前系统时间
        this.date = dateString;
        this.downloads = downloads;
        this.bills = bills;
        this.billAmount = billAmount;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    public int getBills() {
        return bills;
    }

    public void setBills(int bills) {
        this.bills = bills;
    }

    public int getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(int billAmount) {
        this.billAmount = billAmount;
    }
}
