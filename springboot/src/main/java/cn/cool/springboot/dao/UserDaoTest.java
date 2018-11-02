package cn.cool.springboot.dao;

import cn.cool.springboot.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void insertTest() {
        User user = new User();
        user.setBirthday(new Date());
        user.setPassword("123");
        user.setId(2);
        user.setUsername("Cool");
        int insert = userDao.insert(user);
        System.out.println(insert);
    }

    @Test
    public void GetId() {
        User byId = userDao.getById(2);
        System.out.println(byId.getUsername());
    }
}
