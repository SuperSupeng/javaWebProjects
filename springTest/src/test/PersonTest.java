import beans.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonTest {
    @Test
    public void testOne() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) ac.getBean("person");
        System.out.println(person);
    }
}
