import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext(
                "appconfigXML.xml"
        );
        Drama drama= context.getBean("drama",Drama.class);
        System.out.println( drama.getName());
        var comedy=context.getBean("comedy",Comedy.class);
        System.out.println( comedy.getName());
        context.getBean("player1",Player.class).ShowType();
        context.getBean("player2",Player.class).ShowType();
    }
}
