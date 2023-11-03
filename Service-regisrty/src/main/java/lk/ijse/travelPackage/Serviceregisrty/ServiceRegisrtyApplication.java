package lk.ijse.travelPackage.Serviceregisrty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegisrtyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegisrtyApplication.class, args);
	}

}
