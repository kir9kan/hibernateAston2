import dao.UserDao;
import models.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.security.PublicKey;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestUserService {
    @Test
    public void UserFindByIdTestAndFindAll(){
        UserDao mockUserDao=Mockito.mock(UserDao.class);
        User userTest=new User();
        User user2Test=new User();
        mockUserDao.findAllUsers();
        User byId = mockUserDao.findById(1);
    }
}
