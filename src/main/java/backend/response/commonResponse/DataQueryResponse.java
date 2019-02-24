package backend.response.commonResponse;

import backend.entity.DataPackage;

public class DataQueryResponse {
    DataPackage[] res;
    int total;

    public DataQueryResponse(DataPackage[] res, int total) {
        this.res = res;
        this.total = total;
    }

    public DataQueryResponse() {
    }

    public DataPackage[] getRes() {
        return res;
    }

    public void setRes(DataPackage[] res) {
        this.res = res;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
