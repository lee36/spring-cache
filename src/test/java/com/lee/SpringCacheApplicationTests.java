package com.lee;

import net.bytebuddy.asm.Advice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringCacheApplicationTests {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private CacheManager cacheManager;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private UserMapper userMapper;
    @Test
    @Cacheable(value = "contextLoads",key = "id")
    public void contextLoads() throws SQLException {
        for (int i=0;i<10;i++) {
            Map<String, String> id = userMapper.getById(1);
            System.out.println(id);
        }
    }

}

