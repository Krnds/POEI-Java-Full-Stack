import com.karinedias.model.Developer;
import com.karinedias.model.Manager;
import com.karinedias.model.ProductOwner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        ProductOwner dev = (ProductOwner) context.getBean("productOwner");
        dev.getTask();

    }
}
