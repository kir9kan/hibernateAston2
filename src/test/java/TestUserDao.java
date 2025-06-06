import dao.UserDao;
import models.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import utils.SessionFactoryUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUserDao {

        static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres1");

    UserDao userDao;
    @BeforeAll
    static void beforeAll(){
        postgres.start();
    }
    @AfterAll
    static void afterAll(){
        postgres.stop();;
    }
    @BeforeEach
        void setUP(){
        SessionFactoryUtil sessionFactoryUtil=new SessionFactoryUtil(
                postgres.getJdbcUrl(),
                postgres.getUsername(),
                postgres.getPassword()
        );

        userDao=new UserDao(sessionFactoryUtil);
    }
    @Test
        void addUser(){
        userDao.save(new User());
        userDao.save(new User());

        List<User> userList=userDao.findAllUsers();
        assertEquals(2,userList.size());
        }
    }

