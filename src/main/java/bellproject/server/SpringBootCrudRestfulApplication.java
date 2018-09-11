package bellproject.server;


import bellproject.server.configuration.SpringConfiguration;
import bellproject.server.pojo.OrganizationEntity;
import bellproject.server.service.OrganizationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.List;
import java.util.Locale;

@ImportResource("spring_mvc_config.xml")
@SpringBootApplication
public class SpringBootCrudRestfulApplication {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        SpringApplication.run(SpringBootCrudRestfulApplication.class);
//        AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        OrganizationService organizationService = (OrganizationService) context.getBean("organizationService");
//        List<OrganizationEntity> allOrganization = organizationService.findAllOrganization();
//        OrganizationEntity organizationEntity = organizationService.findOrganizationById(1);
//        organizationService.deleteOrganizationById(1);
//        List<OrganizationEntity> organizationEntities = organizationService.findAllOrganization();
//        System.out.println(allOrganization);
    }
}
