package pjx.test.dao;

import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.annotatoin.Sql;
import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.test.BaseDao;
import pjx.test.domain.User;

import java.util.List;

/**
 * 类作用描述
 * Mapper 对应的sql文件默认根据实体来确定，如实体是UserInfo对象，则对应的sql文件是userInfo.md(sql),可以通过@SqlResource 注解来指定Mapper对应的sql文件。比如
 * @author panjinxin
 * @since 19/1/13
 */
@SqlResource("user")
public interface UserDao extends BaseDao<User> {
    /**
     * 根据userName查询  8之前的jdk版本需要加@Param("name"),8以及之后的不需要加注解，但变异需要加参数,java编译的时候开启-parameters选项
     * @param name
     * @return
     */
    List<User> selectByName(@Param("name")String name);

    /**
     * @param name
     * @return
     */
    @Sql("select * from beetl.user t where t.user_name =?")
    List<User> selectByNameUsingJDBC(String name);
}
