package backend.parameter.message;

public class MessageGetParameter {
    int hasRead;
    int hasImportance;

    public MessageGetParameter() {
    }

    public MessageGetParameter(int hasRead, int hasImportance) {
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
}
