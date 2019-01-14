package pjx.test.service.impl;

import org.beetl.sql.core.DBRunner;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.SQLReady;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pjx.test.dao.UserDao;
import pjx.test.domain.User;

import java.util.Date;
import java.util.List;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 19/1/13
 */
@Service
public class UserServiceImpl {
    @Autowired
    private UserDao userDao;

    public boolean createUser(String userName, String passWord) {
        User user = new User();
        user.setUser_name(userName);
        user.setPassword(passWord);
        user.setCreate_time(new Date());
        return userDao.createQuery().insertSelective(user) ==1;
    }

    public List<User> getAllUsers() {
        return userDao.all();
    }

    public PageQuery<User> userPageQuery() {
        return userDao.createLambdaQuery().andEq(User::getDelete_flag, false).desc(User::getCreate_time).page(1, 10);
//        return userDao.createQuery().andEq("delete_flag", 0).page(1, 10);
//        PageQuery<User> pageQuery = new PageQuery<>(1, 10);
//        String sql = "select * from beetl.user ";
//        return userDao.getSQLManager().execute(new SQLReady(sql), User.class, pageQuery);
    }

    public User findUniqueUser(String userName) {
        //SELECT * FROM `beetl`.`user` WHERE `user_name` = ? limit 0 , 2
        //如果有多条数据会抛出异常 ‘unique查询，查询出多条结果集’
//        return userDao.createLambdaQuery().andEq(User::getUser_name, userName).unique();
//        SELECT * FROM `beetl`.`user` WHERE `user_name` = ? limit 0 , 1
        return userDao.createLambdaQuery().andEq(User::getUser_name, userName).single();
//        不管是什么字段，都是按照id查询 如果不存在会抛出异常
        //select * from `beetl`.`user` where `id` = ?
//        return userDao.unique(userName);
        //select * from `beetl`.`user` where `id` = ?
//        return userDao.single(userName);

//        DBRunner dbRunner = new DBRunner() {
//            @Override
//            public void run(SQLManager sm) {
//                sm.
//            }
//        }
//        return userDao.getSQLManager().useMaster();
    }

    public List<User> findUsersByNameUsingConfig(String userName) {
        return userDao.selectByName(userName);
    }

    public List<User> findUsersByNameUsingJDBC(String userName) {
        return userDao.selectByNameUsingJDBC(userName);
    }
}
