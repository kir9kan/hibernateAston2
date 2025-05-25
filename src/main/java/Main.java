import models.Group;
import models.User;
import service.GroupService;
import service.UserService;

public class Main {
    public static void main(String[] args) {
        UserService userService =new UserService();
        GroupService groupService = new GroupService();

        Group group123 = new Group(123);
        Group group101=new Group(101);

        groupService.saveGroup(group123);
        groupService.saveGroup(group101);

        User userPE = new User("Ivanov", "Ivan");
        User userMath= new User("Sidorov", "Alexey");

        userService.saveUser(userPE);
        userService.saveUser(userMath);

        group101.addUserToGroup(userMath);
        group123.addUserToGroup(userPE);

        groupService.updateGroup(group101);
        groupService.updateGroup(group123);

        System.out.println(userService.findAllUsers().toString());

    }
}