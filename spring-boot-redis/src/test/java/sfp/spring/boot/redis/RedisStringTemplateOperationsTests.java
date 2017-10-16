
package sfp.spring.boot.redis;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisStringTemplateOperationsTests {

	@Autowired
	RedisStringTemplateOperations redisStringTemplateOperations;
		
	@Test
	public void setAndGet() {
		redisStringTemplateOperations.set("setX1", "val");
		
		assertEquals("val", redisStringTemplateOperations.get("setX1"));
	}
	
	@Test
	public void setMap() {
		
		Map<String, Object> map = new HashMap<>(); 
		
		for(int i=0; i< 5; i++) {
			map.put(i + "keyNew", "asds" + i);
		}
		
		redisStringTemplateOperations.set(map, 50L);
		
		map.forEach((k, v) -> {assertEquals(v, redisStringTemplateOperations.get(k));});
	}
}
