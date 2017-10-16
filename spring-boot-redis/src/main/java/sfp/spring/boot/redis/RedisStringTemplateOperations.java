package sfp.spring.boot.redis;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisStringTemplateOperations {

	@Autowired
	StringRedisTemplate stringRedisTemplate;

	public void set(String key, String value) {
		stringRedisTemplate.opsForValue().set(key, value);
	}
	
	public void set(Map<String, Object> map, long expiration) {
		stringRedisTemplate.executePipelined(new RedisCallback() {
		
			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				
				map.forEach((k, v) -> {
					System.out.println(">>>>>>>>>>>>>> conne " + k + "   " + v);
					connection.setEx(k.getBytes(), expiration, v.toString().getBytes());
				}
				);

				return null;
			}
		});
	}
	
	public String get(String key) {
		return stringRedisTemplate.opsForValue().get(key);
	}
}
