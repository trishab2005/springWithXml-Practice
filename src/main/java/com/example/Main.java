package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    static void main() {

        IO.println("<<--------- with spring xml ---------->>");

        // Initializing the Spring IoC Container
        ApplicationContext app = new ClassPathXmlApplicationContext("bjp.xml");
        IO.println("Spring container is ready: " + app.getClass().getName());

        // This is manual object creation (Hardcoded dependency)
        Person p = new Person("Trisha", 20, Address.builder()
                .street("fariapukur")
                .state("WB")
                .city("kolkata")
                .zipCode("700004")
                .build());

        IO.println("Manual Person: " + p.getName() + " of age : "+ p.getAge()+" stays in " + p.getAddress().getStreet());

        // DEPENDENCY INJECTION: Spring provides the fully initialized 'Person' bean from the container
        Person pp = (Person) app.getBean("pr");

        // SETTER INJECTION: Occurs inside the bean 'pr' definition in bjp.xml using <property> tags in XML file
        IO.println("Spring Person: " + pp.getName() + " of age : "+ pp.getAge()+ " stays in " + pp.getAddress().getStreet());

        // CONSTRUCTOR INJECTION: Occurs inside the bean 'pr' definition in bjp.xml using <constructor-arg> in XML file
        IO.println(pp.getName()+" stays in "+pp.getAddress()
                .getStreet()+" "+
                " of age : "+ pp.getAge()+
                pp.getAddress().getState()+" "+
                pp.getAddress().getCity());

    }
}