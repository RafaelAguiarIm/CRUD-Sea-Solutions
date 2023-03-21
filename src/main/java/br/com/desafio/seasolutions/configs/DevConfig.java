package br.com.desafio.seasolutions.configs;


import br.com.desafio.seasolutions.services.DBServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class DevConfig {
    @Autowired
    private DBServices dbServices;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String value;

    @Bean
    public Boolean instaciaDB(){
        if (value.equals("create")){
            this.dbServices.instanciaDB();
        }
        return false;
    }


}
