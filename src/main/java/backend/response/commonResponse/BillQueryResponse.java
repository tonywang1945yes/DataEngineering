package backend.response.commonResponse;

import backend.entity.Bill;

/**
 * @author Wen Sun
 * @date 2019-3-19
 */
public class BillQueryResponse {
    Bill[] res;
    int total;

    public BillQueryResponse() {
    }

    public BillQueryResponse(Bill[] res, int total) {
        this.res = res;
        this.total = total;
    }

    public Bill[] getRes() {
        return res;
    }

    public void setRes(Bill[] res) {
        this.res = res;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
