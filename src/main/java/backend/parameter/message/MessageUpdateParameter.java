package backend.parameter.message;

/**
 * @author Wen Sun
 * @date 2019-3-19
 */
public class MessageUpdateParameter {
    int hasRead;
    int hasImportance;


    public MessageUpdateParameter() {
    }

    public MessageUpdateParameter(int hasRead, int hasImportance) {
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
