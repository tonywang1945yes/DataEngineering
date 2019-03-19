package backend.response.commonResponse;

import backend.entity.Corporation;

/**
 * @author Wen Sun
 * @date 2019-3-19
 */
public class CorporationQueryResponse {
    Corporation[] res;
    int total;

    public CorporationQueryResponse() {
    }

    public CorporationQueryResponse(Corporation[] res, int total) {
        this.res = res;
        this.total = total;
    }

    public Corporation[] getRes() {
        return res;
    }

    public void setRes(Corporation[] res) {
        this.res = res;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
