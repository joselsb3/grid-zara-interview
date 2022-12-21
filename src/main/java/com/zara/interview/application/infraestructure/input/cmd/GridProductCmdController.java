package com.zara.interview.application.infraestructure.input.cmd;

import com.zara.interview.application.application.dto.GridProductStockResponse;
import com.zara.interview.application.application.usecase.GridUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.stream.Collectors;

@Controller
public class GridProductCmdController {

    private final GridUseCase gridUseCase;

    @Autowired
    public GridProductCmdController(GridUseCase gridUseCase) {
        this.gridUseCase = gridUseCase;
    }

    public String show() {
        final GridProductStockResponse grid = gridUseCase.getProductGrid();
        return grid.getProductIds()
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }

}
