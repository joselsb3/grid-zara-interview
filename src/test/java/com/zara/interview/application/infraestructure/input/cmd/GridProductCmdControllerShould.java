package com.zara.interview.application.infraestructure.input.cmd;

import com.zara.interview.application.infraestructure.input.cmd.GridProductCmdController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GridProductCmdControllerShould {

    @Autowired
    private GridProductCmdController productController;

    @Test
    public void when_show_then_shouldBeExecuted() {
        // given
        //when
        String result = productController.show();
        // then
        assertEquals(result, "5,1,3");
    }

}