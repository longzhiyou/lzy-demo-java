package lzy.sys.security;

import lzy.sys.security.jwt.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static lzy.common.CommonDefine.BASE_URI;

/**
 *  想要开启Spring方法级安全，你需要在已经添加了@Configuration注解的类上再添加@EnableGlobalMethodSecurity注解：
 * Created by longzhiyou .
 */
@Configuration
@EnableJpaAuditing
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }

    @Autowired
    private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Bean
    GrantedAuthorityDefaults grantedAuthorityDefaults() {
        return new GrantedAuthorityDefaults(""); // Remove the ROLE_ prefix
    }

    @Bean
    public JwtAuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
        return new JwtAuthenticationTokenFilter();
    }


    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {


        auth.userDetailsService(customUserDetailsService).passwordEncoder(new BCryptPasswordEncoder(4));

    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {


        httpSecurity.csrf().disable();
        httpSecurity.exceptionHandling().authenticationEntryPoint(customAuthenticationEntryPoint)
                .and()
                // don't create session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and();

        httpSecurity.authorizeRequests()
                // 允许对于网站静态资源的无授权访问
                .antMatchers(
                        HttpMethod.GET,
                        "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/assets/**",
                        "/fonts/**",
                        "/maps/**",
                        "/scripts/**",
                        "/styles/**"
                ).permitAll()
                .antMatchers(BASE_URI+"/auth/**",BASE_URI+"/demo/**").permitAll()
//                .antMatchers(BASE_URI+"/admin/**").hasRole("ADMIN")
//                .antMatchers("/auth/*").hasAnyRole("ADMIN","USER")
//                .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
                .anyRequest().authenticated()
        ;

        // disable page caching
        httpSecurity.headers().cacheControl();

        // Custom JWT based security filter
        httpSecurity.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);


    }


}
