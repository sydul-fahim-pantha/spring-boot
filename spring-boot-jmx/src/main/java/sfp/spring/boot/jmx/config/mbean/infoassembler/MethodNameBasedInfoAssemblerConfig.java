package sfp.spring.boot.jmx.config.mbean.infoassembler;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.assembler.MethodNameBasedMBeanInfoAssembler;

@Configuration
public class MethodNameBasedInfoAssemblerConfig {

	@Bean
	public MethodNameBasedMBeanInfoAssembler assembler() {
		MethodNameBasedMBeanInfoAssembler assembler = new MethodNameBasedMBeanInfoAssembler();
		assembler.setManagedMethods(new String[] {"infoAssemblerMethod1"});
		
		return assembler;
	}
}
