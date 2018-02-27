package yc.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author:wh
 * @create in 18-2-26 下午3:01
 */
public class RedisCache implements Cache {

    RedisTemplate redisTemplate;
    private String name;

    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return null;
    }

    public Object getNativeCache() {
        return null;
    }

    public ValueWrapper get(Object key) {
        return null;
    }

    public <T> T get(Object key, Class<T> type) {
        return null;
    }

    public void put(Object key, Object value) {

    }

    public ValueWrapper putIfAbsent(Object key, Object value) {
        return null;
    }

    public void evict(Object key) {

    }

    public void clear() {

    }
}
