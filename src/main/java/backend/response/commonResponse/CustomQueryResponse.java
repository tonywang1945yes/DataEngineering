package backend.response.commonResponse;

import backend.entity.Custom;

/**
 * @author Wen Sun
 * @date 2019-3-19
 */
public class CustomQueryResponse {
    Custom[] res;
    int total;

    public CustomQueryResponse() {
    }

    public CustomQueryResponse(Custom[] res, int total) {
        this.res = res;
        this.total = total;
    }

    public Custom[] getRes() {
        return res;
    }

    public void setRes(Custom[] res) {
        this.res = res;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
