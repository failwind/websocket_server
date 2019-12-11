package tw.com.seedinfo.server.init;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = "tw.com.seedinfo")
//@ComponentScan(basePackages = "com.cesmart") // 扫描那些包得到bean.@ComponentScan({"com.teradata.notification","com.teradata.dal"})
public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
    }
}
