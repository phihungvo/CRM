package com.base.admin.inventory.service.impl;

import com.base.admin.inventory.dto.request.PagedRequest;
import com.base.admin.inventory.entity.Customer;
import com.base.admin.inventory.mapper.CustomerMapper;
import com.base.admin.inventory.service.CustomerService;
import com.base.admin.inventory.util.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerMapper customerMapper;

    @Override
    public Optional<Customer> findById(UUID id) {
        return customerMapper.findById(id);
    }

    @Override
    public Page<Customer> findPage(PagedRequest pagedRequest) {
        PageUtil pageUtil = new PageUtil(pagedRequest);
        List<Customer> list = customerMapper.findPage(pageUtil.getLimit(), pageUtil.getOffset());
        long count = customerMapper.count();
        return new PageImpl<>(list, pageUtil.getPageable(), count);
    }

    @Override
    public boolean existByName(String customername) {
        return customerMapper.existByName(customername);
    }

    @Override
    public UUID save(Customer customer) {
        customer.setId(UUID.randomUUID());
        customerMapper.save(customer);
        return customer.getId();
    }

    @Override
    public boolean existById(UUID customerid) {
        return customerMapper.existById(customerid);
    }

    @Override
    public boolean delete(UUID customerid) {
        return customerMapper.deleteById(customerid);
    }
}
