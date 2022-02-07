
package pe.com.synopsis.imgrabber.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import pe.com.synopsis.imgrabber.security.JwtAuthenticationEntryPoint;
import pe.com.synopsis.imgrabber.security.JwtAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter()
    {
        return new JwtAuthenticationFilter();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.authenticationProvider(authenticationProvider);
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception
    {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        // @formatter:off
        http
        .cors()
            .and()
        .csrf()
            .disable()
        .exceptionHandling()
            .authenticationEntryPoint(unauthorizedHandler)
            .and()
        .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
        .authorizeRequests()
            .antMatchers("/auth/v1/login").permitAll()
            .antMatchers("/swagger-ui.html").permitAll()
            .antMatchers("/auth/v1/changePassword").permitAll()
            .antMatchers("/area/v1/*").hasRole("ADMINISTRADOR")
            .antMatchers("/employ/v1/addOfficerEmploy").hasRole("ADMINISTRADOR")
            .antMatchers("/employ/v1/addSupervisorEmploy").hasRole("ADMINISTRADOR")
            .antMatchers("/employ/v1/addAdminEmploy").hasRole("GLOBAL")
            .antMatchers("/employ/v1/deleteEmploy").hasRole("ADMINISTRADOR")
            .antMatchers("/employ/v1/defuseSupervisorEmploy").hasRole("ADMINISTRADOR")
            .antMatchers("/employ/v1/updateAdminBusinessEmploy").hasRole("GLOBAL")
            .antMatchers("/employ/v1/loadAllEmploy").permitAll()
            .antMatchers("/employ/v1/updateOfficerEmploy").hasRole("ADMINISTRADOR")
            .antMatchers("/employTraze/v1/loadEmployTrace").hasRole("ADMINISTRADOR")
            .antMatchers("/swagger-resources/**").permitAll()
            .antMatchers("/v2/**").permitAll()
            .antMatchers("/webjars/**").permitAll()
        .anyRequest()
            .authenticated();
        //este metodo es de una clase padre
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        // @formatter:on
    }

}