package edu.eci.arsw.blueprints.ui;

import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws BlueprintNotFoundException { // Mover [] al tipo
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BlueprintsServices gc = ac.getBean(BlueprintsServices.class);
        System.out.println(gc.getBlueprintsByAuthor("_authorname_"));
    }
}
