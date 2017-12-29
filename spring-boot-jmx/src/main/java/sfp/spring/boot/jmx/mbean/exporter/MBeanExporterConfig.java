package sfp.spring.boot.jmx.mbean.exporter;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.MBeanExporter;

@Configuration
public class MBeanExporterConfig {

	@Bean
	public MBeanExporter mBeanExporter(SampleController	controller, SampleController2 controller2) {
		MBeanExporter exporter = new MBeanExporter();

		Map<String, Object> beans = new HashMap<>();
		beans.put("contoller:name=" + SampleController.class.getName(), controller);
		beans.put("contoller:name=" + SampleController2.class.getName(), controller2);
		exporter.setBeans(beans);
		
		return exporter;
	}
}
