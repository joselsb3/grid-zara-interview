package com.zara.interview.application.infraestructure.input.cmd;

import com.zara.interview.application.infraestructure.input.cmd.GridProductCmdController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URISyntaxException;

@SpringBootTest
class GridProductCmdControllerShould {

    @Autowired
    private GridProductCmdController productController;

    @Test
    public void when_getProducts_then_shouldBeFound() throws IOException, URISyntaxException {
        // given

        //when
    }

}