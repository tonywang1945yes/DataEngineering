package backend.service;

import backend.dao.impl.HibernateDao;
import backend.dao.service.BasicDatabaseService;
import backend.entity.User;
import backend.parameter.welcome.UserQueryParameter;
import backend.parameter.welcome.SignUpParameter;
import backend.parameter.welcome.UserLoginParameter;
import backend.response.commonResponse.UserQueryResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class WelcomeService {
    BasicDatabaseService<User> userService;

    public WelcomeService() {
        userService = new HibernateDao<>(new User());
    }

    public int signUp(SignUpParameter param) {
        User user = new User(param.getPhoneNumber(), param.getPassword(), param.getEmailAddress(), param.getType(), param.getUsername(), 0, 0, 0);
        if (userService.checkKeyExists(param.getPhoneNumber())) {
            return 500;
        } else {
            userService.add(user);
            return 201;
        }
    }

    public int userLogin(UserLoginParameter param) {
        User user = userService.findByKey(param.getPhoneNumber());
        if (user != null) {
            if (user.getPassword().equals(param.getPassword())) {
                return 201;
            } else {
                return 500;//密码错误
            }
        } else {
            return 404;//手机号不存在
        }
    }

    //管理员登录
    public boolean adminLogin(String username, String password) {
        return username.equals("admin") && password.equals("123");
    }

    // 获取用户姓名
    public String getUserName(String uid) {
        return userService.findByKey(uid).getUsername();
    }

    public UserQueryResponse getUserInfo(UserQueryParameter param) {
        String query = "select u from User u ";
        ArrayList<String> queryStr = new ArrayList<>();
        if (param.getDate() != null && !param.getDate().equals("")) {
            queryStr.add(" u.date='" + param.getDate() + "' ");
        }
        if (param.getType() != -1) {
            queryStr.add(" u.type=" + param.getType() + "");
        }
        if (param.getUsername() != null && !param.getUsername().equals("")) {
            queryStr.add(" u.username='" + param.getUsername() + "' ");
        }
        if (queryStr.size() > 0) {
            query = query + " where ";
        }
        for (int i = 0; i < queryStr.size(); i++) {
            query = query + queryStr.get(i);
            if (i != queryStr.size() - 1) {
                query = query + " and ";
            }
        }
        ArrayList<User> users = userService.executeQuerySql(query);
        User[] res = new User[users.size()];
        res = users.toArray(res);
        return new UserQueryResponse(res, users.size());
    }
}
