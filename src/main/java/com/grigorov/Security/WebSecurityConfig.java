package com.grigorov.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(getShaPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf()
              .disable()
                // указываем правила запросов
                // по которым будет определятся доступ к ресурсам и остальным данным
                .authorizeRequests()
                //.antMatchers("/**").permitAll()
                .antMatchers("/userView/**").hasRole("USER")
                .anyRequest().permitAll()
                .and();

        http.formLogin()
                                .loginPage("/")
                                .loginProcessingUrl("/j_spring_security_check")

                // указываем URL при неудачном логине
                .failureUrl("/login?error")
                                .usernameParameter("j_username")
                .passwordParameter("j_password")
                //.successForwardUrl("/userView")
                .defaultSuccessUrl("/userView");
                                //.permitAll();

        http.logout()
                // разрешаем делать логаут всем
                .permitAll()
                // указываем URL логаута
                .logoutUrl("/logout")
                // указываем URL при удачном логауте
                .logoutSuccessUrl("/?logout")
                // делаем не валидной текущую сессию
                .invalidateHttpSession(true);

    }

    @Bean
    public ShaPasswordEncoder getShaPasswordEncoder(){
        return new ShaPasswordEncoder();
    }
//   @Override
//   protected void configure(HttpSecurity http) throws Exception
//   {
//      http.csrf().disable()
//            .authorizeRequests()
//            .antMatchers(HttpMethod.POST, "/users").permitAll()
//            .antMatchers(HttpMethod.GET, "/webms").permitAll()
//            .antMatchers("/manage").hasRole("ADMIN")
//            .anyRequest().authenticated().and().httpBasic();
//   }
}