import dao.GroupDao;
import models.Group;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TestGroupService {
    @Test
    public void FindGroupByNumber() {
        GroupDao mockGroupDao = Mockito.mock(GroupDao.class);
        Group group1 = new Group(123);
        Group group2 = new Group(999);
        mockGroupDao.findByNumber(999);
    }
}

