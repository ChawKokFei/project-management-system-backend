package dc.icdc.pms.projectmanagementsystem;

import dc.icdc.pms.projectmanagementsystem.entity.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class ProjectManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementSystemApplication.class, args);
	}

	@Bean
	@Scope(value = "prototype")
	Employee getEmployee() { return new Employee(); }
}
