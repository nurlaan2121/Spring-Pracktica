package java12.configs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java12.entities.Course;
import java12.entities.Lesson;
import java12.entities.Student;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Properties;


@org.springframework.context.annotation.Configuration
@ComponentScan(basePackages = "java12")
public class HibernateConfig {



    @Bean
    public static EntityManager getEntityManagerFactory() {
        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/lmstask2");
        properties.put(Environment.USER, "postgres");
        properties.put(Environment.PASS, "nurlan21");
        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.HBM2DDL_AUTO, "update");
        properties.put(Environment.DRIVER, "org.postgresql.Driver");
        Configuration configuration = new Configuration();
        configuration.addProperties(properties);
        configuration.addAnnotatedClass(Course.class);
        configuration.addAnnotatedClass(Lesson.class);
        configuration.addAnnotatedClass(Student.class);
        return configuration.buildSessionFactory().unwrap(EntityManagerFactory.class).createEntityManager();
    }
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        // Дополнительные настройки EntityManager
//        return em;
//    }
}
