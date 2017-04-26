package com.grigorov;

//import com.grigorov.Entity.PartCache;

import com.grigorov.Security.UserDetailsServiceImpl;
import com.grigorov.Store.Storage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Configuration
@ComponentScan("com.grigorov")
@EnableWebMvc
public class AppConfig {

//    @Bean
//    public EntityManagerFactory factory() {
//        return Persistence.createEntityManagerFactory("spm");
//    }
//
    @Bean
    public EntityManager manager() {
                return Persistence.createEntityManagerFactory("spm").createEntityManager();
    }

//    @Bean
//    public Storage storage() {
//        return new PartCache();
//    }

    @Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        resolver.setOrder(1);
        return resolver;
    }

    @Bean
    public UserDetailsService getUserDetailsService(){
        return new UserDetailsServiceImpl();
    }

//    @Bean
//    public CommonsMultipartResolver multipartResolver() {
//        return new CommonsMultipartResolver();
//    }
}
