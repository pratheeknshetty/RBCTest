package RBCTest.Hipolabs;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = SearchApplication.class)

public class SearchApplicationTests {

    /*
        @Test
        void contextLoads() {
        }
    */
    @Value("${spring.profiles.active}")
    private String profile;


}

