package com.manuja.shoppingapp.util;

import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter   {
	
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Autowired 
	private JwtRequestFilter jwtRequestFilter;
	
	@Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
        auth.userDetailsService(myUserDetailsService);
		
    }
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http.csrf().disable()		
	.antMatcher("/api/**")
  .	authorizeRequests().antMatchers("/api/authenticate").permitAll().anyRequest().authenticated()
	.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	
//	http.csrf().disable()
//	.antMatcher("/api/**")
//  .	authorizeRequests().antMatchers("/api/authenticate").permitAll().anyRequest().authenticated()
//	.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//	http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		
		
//		http.csrf().disable().
//		authorizeRequests().antMatchers("/authenticate").permitAll().anyRequest().authenticated()
//		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		
//		http.authorizeRequests()
//		.antMatchers("/admin").hasRole("ADMIN")
//		.antMatchers("/user").hasAnyRole("ADMIN","USER")
//		.antMatchers("/").permitAll().and().formLogin();
		
//		
		
//		http
//        .csrf().disable()
//        .antMatcher("/api/**")
//        .authorizeRequests()
//        .antMatchers("/api/authenticate").permitAll()
//        .antMatchers("/api/**").hasAnyRole("ADMIN","USER")
//    	.and()
//        .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		
		
//		http.authorizeRequests()
//		.antMatchers("/api*/**").authenticated()
//		.anyRequest().permitAll()
//		.and()
//		.csrf().disable().addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

}
	//}

	

	

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}



	@Bean
	public PasswordEncoder passwordEncoder() {
	    return NoOpPasswordEncoder.getInstance();
	    
	}
//
	
}
