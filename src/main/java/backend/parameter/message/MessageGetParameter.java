package backend.parameter.message;

public class MessageGetParameter {
    String date;
    int hasRead = 0;
    int hasImportance = 0;

    public MessageGetParameter() {
    }

    public MessageGetParameter(String date, int hasRead, int hasImportance) {
        this.date = date;
        this.hasRead = hasRead;
        this.hasImportance = hasImportance;
    }

    public int getHasRead() {
        return hasRead;
    }

    public void setHasRead(int hasRead) {
        this.hasRead = hasRead;
    }

    public int getHasImportance() {
        return hasImportance;
    }

    public void setHasImportance(int hasImportance) {
        this.hasImportance = hasImportance;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
