package backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "data_package")
public class DataPackage {
    @Id
    @Column(name = "id")
    String id;
    @Column(name = "year")
    String year;
    @Column(name = "data_name")
    String dataName;
    @Column(name = "publication_date")
    String publicationDate;
    @Column(name = "input_date")
    String inputDate;
    @Column(name = "first_result")
    String firstResult;
    @Column(name = "final_result")
    String finalResult;
    @Column(name = "source_url")
    String sourceUrl;
    @Column(name = "response_institute")
    String responseInstitute;
    @Column(name = "response_person")
    String responsePerson;
    @Column(name = "url")
    String url;//云盘链接
    @Column(name = "province")
    String province;
    @Column(name = "city")
    String city;
    @Column(name = "data_type")
    String dataType;
    @Column(name = "downloads")
    int downloads = 0;
    @Column(name = "download_date")
    String downloadDate;

    //TODO 出来挨打

    /**
     * 省
     * 市
     * 年鉴（区划）
     */

    public DataPackage() {
    }

    public DataPackage(String id, String year, String dataName, String publicationDate, String inputDate, String firstResult, String finalResult, String sourceUrl, String responseInstitute, String responsePerson, String url, String province, String city, String dataType, int downloads, String downloadDate) {
        this.id = id;
        this.year = year;
        this.dataName = dataName;
        this.publicationDate = publicationDate;
        this.inputDate = inputDate;
        this.firstResult = firstResult;
        this.finalResult = finalResult;
        this.sourceUrl = sourceUrl;
        this.responseInstitute = responseInstitute;
        this.responsePerson = responsePerson;
        this.url = url;
        this.province = province;
        this.city = city;
        this.dataType = dataType;
        this.downloads = downloads;
        this.downloadDate = downloadDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    public String getFirstResult() {
        return firstResult;
    }

    public void setFirstResult(String firstResult) {
        this.firstResult = firstResult;
    }

    public String getFinalResult() {
        return finalResult;
    }

    public void setFinalResult(String finalResult) {
        this.finalResult = finalResult;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getResponseInstitute() {
        return responseInstitute;
    }

    public void setResponseInstitute(String responseInstitute) {
        this.responseInstitute = responseInstitute;
    }

    public String getResponsePerson() {
        return responsePerson;
    }

    public void setResponsePerson(String responsePerson) {
        this.responsePerson = responsePerson;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    public String getDownloadDate() {
        return downloadDate;
    }

    public void setDownloadDate(String downloadDate) {
        this.downloadDate = downloadDate;
    }
}
