package id.mni.mahasiswa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
@EnableJpaRepositories
@EntityScan(basePackages = "id.mni.mahasiswa.model")
public class MahasiswaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MahasiswaApplication.class, args);
	}

}