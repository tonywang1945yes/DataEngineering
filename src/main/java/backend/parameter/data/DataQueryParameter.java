package backend.parameter.data;

public class DataQueryParameter {
    int page;

    String year;

    String dataName;

    String publicationDate;//

    String responseInstitute;

    String responsePerson;//

    String province;

    String city;

    String dataType;

    String downloadDate;

    public DataQueryParameter() {
    }

    public DataQueryParameter(int page, String year, String dataName, String publicationDate, String responseInstitute, String responsePerson, String dataType, String province, String city, String downloadDate) {
        this.page = page;
        this.year = year;
        this.dataName = dataName;
        this.publicationDate = publicationDate;
        this.responseInstitute = responseInstitute;
        this.responsePerson = responsePerson;
        this.dataType = dataType;
        this.province = province;
        this.city = city;
        this.downloadDate = downloadDate;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
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

    public String getDownloadDate() {
        return downloadDate;
    }

    public void setDownloadDate(String downloadDate) {
        this.downloadDate = downloadDate;
    }
}
