package chaw.personalproject.pms.projectmanagementsystem;

import chaw.personalproject.pms.projectmanagementsystem.entity.Employee;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot REST API Documentation",
				description = "Spring Boot REST API Documentation for PMS",
				version = "v1.0",
				contact = @Contact(
						name = "Kok Fei",
						email = "chawkokfei96@gmail.com"
				),
				license = @License(
						name = "MIT"
				)
		)
)
public class ProjectManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementSystemApplication.class, args);
	}

	@Bean
	@Scope(value = "prototype")
	Employee getEmployee() { return new Employee(); }
}
