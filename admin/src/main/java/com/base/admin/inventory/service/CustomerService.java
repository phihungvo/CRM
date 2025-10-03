package com.base.admin.inventory.service;

import com.base.admin.inventory.dto.request.PagedRequest;
import com.base.admin.inventory.entity.Customer;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface CustomerService {
    Optional<Customer> findById(UUID id);

    Page<Customer> findPage(PagedRequest pagedRequest);

    boolean existByName(String customername);

    UUID save(Customer customer);

    boolean existById(UUID customerid);

    boolean delete(UUID customerid);
}
