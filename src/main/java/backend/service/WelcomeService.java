package backend.service;

import backend.dao.impl.HibernateDao;
import backend.dao.service.BasicDatabaseService;
import backend.entity.User;
import backend.parameter.welcome.SignUpParameter;
import backend.parameter.welcome.UserLoginParameter;
import org.springframework.stereotype.Service;

@Service
public class WelcomeService {
    BasicDatabaseService<User> userService;
    public WelcomeService() {
        userService=new HibernateDao<>(new User());
    }

    public void signUp(SignUpParameter param ){
        User user=new User(param.getPhoneNumber(),param.getPassword(),param.getEmailAddress(),param.getType(),param.getUsername());
        userService.add(user);
    }

    public int userLogin(UserLoginParameter param){
        User user=userService.findByKey(param.getPhoneNumber());
        if(user!=null){
            if(user.getPassword().equals(param.getPassword())){
                return 201;
            }else{
                return 500;//密码错误
            }
        }else{
            return 404;//手机号不存在
        }
    }
}
