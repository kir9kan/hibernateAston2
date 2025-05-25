package service;

import dao.GroupDao;
import models.Group;

public class GroupService {
    private GroupDao studyGroupDao = new GroupDao();

    public GroupService() {
    }
    public Group findGroupByNumber (int number){
        return studyGroupDao.findByNumber(number);
    }
    public void saveGroup (Group group){
        studyGroupDao.save(group);
    }
    public void updateGroup (Group group){
        studyGroupDao.update(group);
    }
    public void deleteGroup (Group group){
        studyGroupDao.delete(group);
    }

}
