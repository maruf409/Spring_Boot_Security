package Spring.Security.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class securityConfiguration extends WebSecurityConfigurerAdapter {

	private final PasswordEncoder encoder;

	public securityConfiguration(PasswordEncoder encoder) {
		super();
		this.encoder = encoder;
	}

	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {

		/*
		 * .antMatchers("/", "/index", "/**").permitAll() for this all are getting
		 * access
		 */
		httpSecurity.csrf().disable().authorizeRequests().antMatchers("/", "/index", "/css/*", "/js/*").permitAll()
				.antMatchers("/student/info/*").hasRole(userRole.STUDENT.name())
				.antMatchers(HttpMethod.DELETE, "/admin/student/info/*").hasRole(userRole.ADMIN.name())
				.antMatchers(HttpMethod.POST, "/admin/student/info/*").hasRole(userRole.ADMIN.name())
				.antMatchers(HttpMethod.PUT, "/admin/student/info/*")
				.hasAnyRole(userRole.ADMIN.name(), userRole.SUBADMIN.name())
				.antMatchers(HttpMethod.GET, "/admin/student/info/*")
				.hasAnyRole(userRole.ADMIN.name(), userRole.SUBADMIN.name()).anyRequest().authenticated().and()
				.httpBasic();
	}

	@Bean
	protected UserDetailsService detailsService() {
		UserDetails smith = User.builder().username("smith").password(encoder.encode("smith123"))
				.roles(userRole.STUDENT.name()) /*----------------- role wise authentication */
//				.authorities(userRole.STUDENT.grantedAuthorities())
				.build();

		UserDetails john = User.builder().username("john").password(encoder.encode("smith123"))
				.roles(userRole.ADMIN.name()) /*----------------- role wise authentication */
//				.authorities(userRole.ADMIN.grantedAuthorities())
				.build();

		UserDetails tony = User.builder().username("tony").password(encoder.encode("smith123"))
				.roles(userRole.SUBADMIN.name())
//				.authorities(userRole.SUBADMIN.grantedAuthorities())
				.build();

		return new InMemoryUserDetailsManager(smith, john, tony);
	}

}
