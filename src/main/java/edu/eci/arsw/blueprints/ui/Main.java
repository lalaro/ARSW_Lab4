package edu.eci.arsw.blueprints.ui;

import edu.eci.arsw.blueprints.services.BlueprintsServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String a[]) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BlueprintsServices gc = ac.getBean(BlueprintsServices.class);
        System.out.println(gc.getAllBlueprints());
    }
}