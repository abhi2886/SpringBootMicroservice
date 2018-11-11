package com.test.eureka.client.TestEurekaClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo.InstanceStatus;
import com.netflix.discovery.DiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TestEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestEurekaClientApplication.class, args);
	}
}

@RestController
class DefaultRestController {
	
	private DiscoveryClient discoveryClient;
	
	@RequestMapping("/service-instance/status")
	public InstanceStatus serviceInstanceByAppName() {
		return this.discoveryClient.getInstanceRemoteStatus();
	}
	
}