package backend.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dataPackage")
public class DataPackage {
    @Id
    @Column(name="id")
    String id;
    @Column(name="year")
    String year;
    @Column(name="dataName")
    String dataName;
    @Column(name="publicationDate")
    String publicationDate;
    @Column(name="inputDate")
    String inputDate;
    @Column(name="firstResult")
    String firstResult;
    @Column(name="finalResult")
    String finalResult;
    @Column(name="sourceUrl")
    String sourceUrl;
    @Column(name="responseInstitute")
    String responseInstitute;
    @Column(name="responsePerson")
    String responsePerson;
    @Column(name="url")
    String url;//云盘链接

    public DataPackage() {
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

    public DataPackage(String id, String year, String dataName, String publicationDate, String inputDate, String firstResult, String finalResult, String sourceUrl, String responseInstitute, String responsePerson, String url) {
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
    }
}
