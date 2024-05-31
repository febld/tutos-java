package feb.tutos.apachecamel;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApachecamelApplication {

    public static void main(String[] args) {
       SpringApplication.run(ApachecamelApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext contexte) {
        return args -> {
            System.out.print("Inspection des beans produits par Spring Boot : ");
            String[] nomsBean = contexte.getBeanDefinitionNames();
            Arrays.sort(nomsBean);
            System.out.println(nomsBean.length);
            //int i = 1;
            //for (String nomBean : nomsBean) {
            //    System.out.println(i + " : " + nomBean);
            //    i++;
            //}
        };
    }
}
