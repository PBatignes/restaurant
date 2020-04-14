package dev;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dev.config.AppConfig;
import dev.dao.PlatDaoJdbc;
import dev.entite.Plat;

public class JdbcApp {

	public static void main(String[] args) {
		
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)){
			
			context.getEnvironment().setActiveProfiles("jdbcPlat");
			PlatDaoJdbc platDao = context.getBean(PlatDaoJdbc.class);
			
			List<Plat> plats = platDao.listerPlats();
			
			for (Plat p : plats) {
				System.out.println(p.getNom() + " " + p.getPrixEnCentimesEuros());
			}
			
		}

	}

}
