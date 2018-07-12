package cn.yong.action;

import cn.yong.entity.User;
import cn.yong.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
@Scope("prototype")
public class LoginAction extends ActionSupport {
    @Autowired
    private UserService userService;
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login(){
        User user = userService.login(name, password);
        if (user!=null){
            Map session = ActionContext.getContext().getSession();
            session.put("CURRENT_USER",user.getName());
            return SUCCESS;
        }
        return LOGIN;
    }
}
