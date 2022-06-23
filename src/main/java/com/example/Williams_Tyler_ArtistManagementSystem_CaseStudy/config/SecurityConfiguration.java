package com.example.Williams_Tyler_ArtistManagementSystem_CaseStudy.config;

import com.example.Williams_Tyler_ArtistManagementSystem_CaseStudy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
//@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    //Allows authenticationProvider to be passed to configure() method.
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    //Future re
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/manager", "/home", "/manager_index")
                .hasAnyAuthority("ARTIST")
                .antMatchers("/artist", "/home", "/artist_index")
                .hasAnyAuthority("MANAGER")
                .antMatchers("/admin",
                        "/manager_index",
                        "/artist_index",
                        "/new_artist",
                        "/new_manager",
                        "/update_artist",
                        "/update_manager",
                        "/manager",
                        "/manager/home",
                        "/manager/showNewManagerForm",
                        "/manager/showFormForManagerUpdate/{id}",
                        "/manager/saveManager",
                        "/manager/deleteManager/{id}",
                        "/artist/home",
                        "/artist/showNewArtistForm",
                        "/manager/saveManager",
                        "/artist/showFormForArtistUpdate/{id}",
                        "/artist/deleteArtist/{id}",
                        "/saveArtist")
                .hasAuthority("ADMIN")
                .antMatchers(
                        "/admin",
                        "/manager_index",
                        "/artist_index",
                        "/new_artist",
                        "/new_manager",
                        "/update_artist",
                        "/update_manager",
                        "/manager",
                        "/manager/home",
                        "/manager/showNewManagerForm",
                        "/manager/showFormForManagerUpdate/{id}",
                        "/manager/saveManager",
                        "/manager/deleteManager/{id}",
                        "/artist/home",
                        "/artist/showNewArtistForm",
                        "/manager/saveManager",
                        "/artist/showFormForArtistUpdate/{id}",
                        "/artist/deleteArtist/{id}",
                        "/saveArtist"

//                "/","/registration**",
//                "/js/**",
//                "/css/**",
//                "/img/**"
                )
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll();
    }
}
