//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dfec.hotel.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisUtils {
    @Autowired
    private RedisTemplate<String, Serializable> redisCacheTemplate;
    public static final long DEFAULT_EXPIRE = 86400L;
    public static final long USER_TOKEN_EXPIRE = 1800L;
    public static final long NOT_EXPIRE = -1L;

    public RedisUtils() {
    }

    public void set(String key, Object value, long expire, TimeUnit timeUnit) {
        this.redisCacheTemplate.opsForValue().set(key, this.toJson(value));
        if (expire != -1L) {
            this.redisCacheTemplate.expire(key, expire, timeUnit);
        }

    }

    public void set(String key, Object value, long expire) {
        this.set(key, value, expire, TimeUnit.SECONDS);
    }

    public void set(String key, Object value) {
        this.set(key, value, 86400L);
    }

    public String get(String key) {
        return this.getAndExpire(key, -1L);
    }

    public <T> T get(String key, Class<T> clazz) {
        return this.get(key, clazz, -1L);
    }

    public void expire(String key, long expire, TimeUnit unit) {
        this.redisCacheTemplate.expire(key, expire, unit);
    }

    public String getAndExpire(String key, long expire) {
        String value = (String)this.redisCacheTemplate.opsForValue().get(key);
        if (expire != -1L) {
            this.expire(key, expire, TimeUnit.SECONDS);
        }

        return value;
    }

    public <T> T get(String key, Class<T> clazz, long expire) {
        String value = (String)this.redisCacheTemplate.opsForValue().get(key);
        if (expire != -1L) {
            this.expire(key, expire, TimeUnit.SECONDS);
        }

        return value == null ? null : this.fromJson(value, clazz);
    }

    public long getExpire(String key, TimeUnit unit) {
        return this.redisCacheTemplate.getExpire(key, unit);
    }

    public void delete(String key) {
        this.redisCacheTemplate.delete(key);
    }

    public String toJson(Object object) {
        if (!(object instanceof Integer) && !(object instanceof Long) && !(object instanceof Float) && !(object instanceof Double) && !(object instanceof Boolean) && !(object instanceof String)) {
            return object instanceof Date ? (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(object) : JSON.toJSONString(object, new SerializerFeature[]{SerializerFeature.WriteDateUseDateFormat});
        } else {
            return String.valueOf(object);
        }
    }

    public <T> T fromJson(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

    public <T> List<T> fromJson2List(String json, Class<T> clazz) {
        return JSONObject.parseArray(json, clazz);
    }
}
