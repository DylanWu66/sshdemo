package cn.yong.test;

import cn.yong.entity.User;
import cn.yong.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

    @Test
    public void testSave(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService service = (UserService) context.getBean("userService");
        User user = new User();
        user.setName("admin");
        user.setPassword("admin");

        service.save(user);
        System.out.print("执行完毕");
    }

    @Test
    public void testLogin(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService service = (UserService) context.getBean("userService");

        User user = service.login("admin","admin");

        if (user != null){
            System.out.println(user.getName());
        } else {
            System.out.print("登录失败");
        }

    }
}
