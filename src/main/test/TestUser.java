import cn.edu.shu.society.domain.User;
import cn.edu.shu.society.service.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jxxia on 2016/4/12 0012.
 */
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestUser extends AbstractJUnit4SpringContextTests {
    private static Logger logger = Logger.getLogger(TestUser.class);
    private ApplicationContext ac = null;
    @Resource
    private UserService userService;

//    @Before
//    public void before() {
//        ac = new ClassPathXmlApplicationContext("spring-context.xml");
//        userService = (UserService) ac.getBean("userService");
//    }

    @Test
    public void test1() {
        User user = userService.findById(1);
//        User user = userService.login(new User(1,"邹祥文","111111",24));
        System.out.println(user);
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("user_name", "邹祥文");
        System.out.println(userService);
        List<User> listUser = userService.find(userMap);
        System.out.println(listUser);
        // System.out.println(user.getUserName());
        // logger.info("值："+user.getUserName());
    }
}