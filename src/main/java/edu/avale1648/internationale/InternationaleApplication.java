package edu.avale1648.internationale;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import edu.avale1648.internationale.filesuploading.storage.StorageProperties;
import edu.avale1648.internationale.filesuploading.storage.StorageService;
import edu.avale1648.internationale.util.Urls;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class InternationaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(InternationaleApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}
	
	@Bean
	public WebMvcConfigurer configureCors() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping(Urls.COMMUNITIES.toString()).allowedOrigins(Urls.ORIGIN.toString());
				registry.addMapping(Urls.MESSAGES.toString()).allowedOrigins(Urls.ORIGIN.toString());
				registry.addMapping(Urls.MODERATORS.toString()).allowedOrigins(Urls.ORIGIN.toString());
				registry.addMapping(Urls.POSTS.toString()).allowedOrigins(Urls.ORIGIN.toString());
				registry.addMapping(Urls.RATINGS.toString()).allowedOrigins(Urls.ORIGIN.toString());
				registry.addMapping(Urls.COMMUNITY_SUBSCRIPTIONS.toString()).allowedOrigins(Urls.ORIGIN.toString());
				registry.addMapping(Urls.USER_SUBSCRIPTIONS.toString()).allowedOrigins(Urls.ORIGIN.toString());
				registry.addMapping(Urls.USERS.toString()).allowedOrigins(Urls.ORIGIN.toString());
			}
		};
	}
}
