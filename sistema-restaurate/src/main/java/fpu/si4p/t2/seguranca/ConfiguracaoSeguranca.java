package fpu.si4p.t2.seguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ConfiguracaoSeguranca extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		/*
		 * Quando a proteção CSRF é habilitado, Spring Security espera um token CSRF a partir do cliente 
		 * ao usar POST. Se o cliente não enviar um tal sinal, será nula, o que significa falta.
		 * Para desabilitar: http.csrf().disable().authorizeRequests().....
		 */
		http.csrf().disable().authorizeRequests()
			.antMatchers("/css/*","/js/*","/fonts/*", "/imagens/*").permitAll()
		   	.antMatchers("/" ,"/home").hasRole("USER")
		   	.antMatchers("/cozinha", "/itemPedido2", "/prato").hasRole("COZINHEIRO")
			.antMatchers("/fatura", "/pedido/finalizar").hasRole("ADMIN")
			.antMatchers("/pedido", "/mesa").hasRole("PEDIDO")
			.anyRequest().authenticated()
			.and().formLogin().loginPage("/login").permitAll()
			.and().logout().permitAll();
	}
	
	/* FATURAMENTO  = admin
	 * COZINHEIRO   = só visualiza e marca como finalizado
	 * PEDIDO       = realiza pedido e visualiza os finalizados 
	 * USER         = visualiza a home
	 *  */
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
	{
		//JdbcUserDetailsManagerConfigurer<AuthenticationManagerBuilder> inJdbcUserDetailsManagerConfigurer;
		InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> inMemoryAuthentication = auth.inMemoryAuthentication();
	inMemoryAuthentication.withUser("admin").password("123").roles("ADMIN", "COZINHEIRO", "PEDIDO", "USER");
		inMemoryAuthentication.withUser("cozinheiro").password("123").roles("COZINHEIRO", "USER");
		inMemoryAuthentication.withUser("garcon").password("123").roles("COZINHEIRO", "PEDIDO", "USER");
	}
}
