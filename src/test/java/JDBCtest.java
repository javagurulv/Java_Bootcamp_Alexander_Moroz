import lv.messages.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JDBCtest {

    @Test
    public void addProductTest(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        ProductDatabase jdbcservice = applicationContext.getBean(ProductDatabase.class);
        Product Car = new Product("Car", 100.0);
        jdbcservice.addProduct(Car);
    }
}
