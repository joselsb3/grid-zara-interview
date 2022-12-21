package com.zara.interview.application.infraestructure.input.cmd;

import com.zara.interview.application.domain.repository.ProductRepository;
import com.zara.interview.application.infraestructure.output.persistence.csv.ProductCsvRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.TestPropertySource;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource("/test-application.properties")
public class GridProduct513CmdControllerIntegrationTest {

    @Autowired
    private GridProductCmdController productController;

    @Test
    public void when_show_then_shouldBe_5_1_3() {
        // given
        //when
        String result = productController.show();
        // then
        assertEquals(result, "5,1,3");
    }

}