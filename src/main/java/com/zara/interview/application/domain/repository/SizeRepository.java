package com.zara.interview.application.domain.repository;

import com.zara.interview.application.domain.aggregate.Size;

import java.util.List;
import java.util.Optional;

public interface SizeRepository {
    List<Size> getAll(int productId);
}
