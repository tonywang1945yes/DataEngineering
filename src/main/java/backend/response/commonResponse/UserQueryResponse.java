package backend.response.commonResponse;

import backend.entity.User;

/**
 * @author Wen Sun
 * @date 2019-3-18
 */
public class UserQueryResponse {
    User[] res;
    int total = 0;

    public UserQueryResponse() {
    }

    public UserQueryResponse(User[] res, int total) {
        this.res = res;
        this.total = total;
    }

    public User[] getRes() {
        return res;
    }

    public void setRes(User[] res) {
        this.res = res;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
