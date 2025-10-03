package com.base.admin.inventory.service.impl;

import com.base.admin.inventory.dto.request.OrderRequest;
import com.base.admin.inventory.dto.request.PagedRequest;
import com.base.admin.inventory.dto.response.OrderResponse;
import com.base.admin.inventory.entity.Order;
import com.base.admin.inventory.mapper.OrderDetailMapper;
import com.base.admin.inventory.mapper.OrderMapper;
import com.base.admin.inventory.service.OrderService;
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
public class OrderServiceImpl implements OrderService {
    private final OrderMapper orderMapper;
    private final OrderDetailMapper orderDetailMapper;

    @Override
    public Optional<Order> findById(UUID id) {
        return orderMapper.findById(id);
    }

    @Override
    public Page<Order> findPage(PagedRequest pagedRequest) {
        PageUtil pageUtil = new PageUtil(pagedRequest);
        List<Order> list = orderMapper.findPage(pageUtil.getLimit(), pageUtil.getOffset());
        long count = orderMapper.count();
        return new PageImpl<>(list, pageUtil.getPageable(), count);
    }

    @Override
    public Optional<Order> findByOrdernumber(String ordernumber) {
        return orderMapper.findByOrdernumber(ordernumber);
    }

    @Override
    public OrderResponse saveOrder(OrderRequest orderRequest) {
        return null;
    }

    @Override
    public UUID save(Order order) {
        return null;
    }

    @Override
    public boolean existById(UUID orderid) {
        return orderMapper.existById(orderid);
    }

    @Override
    public boolean deleteOrder(UUID orderid) {
        try {
            orderMapper.deleteOrder(orderid);
            orderDetailMapper.deleteById(orderid);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
