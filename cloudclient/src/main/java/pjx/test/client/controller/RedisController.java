package pjx.test.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pjx.test.client.vo.UserVO;

import java.util.concurrent.TimeUnit;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 18/12/31
 */
@RestController
public class RedisController {
    private Logger logger = LoggerFactory.getLogger(RedisController.class);

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @GetMapping("/redis_ini")
    public String initialTest() {
        Object user1 = redisTemplate.boundValueOps("user1").get();
        if (user1 == null) {
            logger.info("数据为空，写入缓存");
            redisTemplate.boundValueOps("user1").set(new UserVO("1", "user1"), 10, TimeUnit.SECONDS);
            user1 = redisTemplate.boundValueOps("user1").get();
        }
        logger.info("从缓存读取 user1={}", user1);

        return user1.toString();
    }
}
