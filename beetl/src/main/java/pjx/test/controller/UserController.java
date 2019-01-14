package pjx.test.controller;

import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pjx.test.domain.User;
import pjx.test.service.UserService;
import pjx.test.service.impl.UserServiceImpl;

import java.util.List;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 19/1/13
 */
@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;


    @GetMapping(value = "/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping(value = "/users-page")
    public PageQuery<User> getAllUsersPage() {
        return userService.userPageQuery();
    }
    @GetMapping(value = "/users/unique")
    public User finUniqueUser(@RequestParam(value = "userName") String userName) {
        return userService.findUniqueUser(userName);
    }

    @GetMapping(value = "/users/config")
    public List<User> findUsersByNameUsingConfig(@RequestParam(value = "userName") String userName) {
        return userService.findUsersByNameUsingConfig(userName);
    }
    @GetMapping(value = "/users/jdbc")
    public List<User> findUsersByNameUsingJDBC(@RequestParam(value = "userName") String userName) {
        return userService.findUsersByNameUsingJDBC(userName);
    }


    @PostMapping(value = "/user")
    public boolean createUser(@RequestParam(name = "username") String userName,
                              @RequestParam(name = "password") String password) {
        return userService.createUser(userName, password);
    }
}
