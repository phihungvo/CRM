package com.base.admin.inventory.service.impl;

import com.base.admin.inventory.dto.request.PagedRequest;
import com.base.admin.inventory.entity.InventoryFull;
import com.base.admin.inventory.mapper.InventoryInfoMapper;
import com.base.admin.inventory.service.InventoryInfoService;
import com.base.admin.inventory.util.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InventoryInfoServiceImpl implements InventoryInfoService {
    private final InventoryInfoMapper inventoryInfoMapper;

    @Override
    public List<InventoryFull> findByProductId(UUID productid) {
        return inventoryInfoMapper.findByProductId(productid);
    }

    @Override
    public List<InventoryFull> findByWarehouseId(UUID warehouseid) {
        return inventoryInfoMapper.findByWarehouseId(warehouseid);
    }

    @Override
    public List<InventoryFull> findByProductIdAndWarehouseId(UUID productid, UUID warehouseid) {
        return inventoryInfoMapper.findByProductIdAndWarehouseId(productid, warehouseid);
    }

    @Override
    public Page<InventoryFull> findPage(PagedRequest pagedRequest) {
        PageUtil pageUtil = new PageUtil(pagedRequest);
        List<InventoryFull> list = inventoryInfoMapper.findPage(pageUtil.getLimit(), pageUtil.getOffset());
        long count = inventoryInfoMapper.count();
        return new PageImpl<>(list, pageUtil.getPageable(), count);
    }

    @Override
    public Page<InventoryFull> searchProductNameOrWarehouseName(PagedRequest pagedRequest, String productOrWarehouse) {
        PageUtil pageUtil = new PageUtil(pagedRequest);
        List<InventoryFull> list = inventoryInfoMapper.searchProductNameOrWarehouseName(
                pageUtil.getLimit(),pageUtil.getOffset(),productOrWarehouse
        );
        long count = inventoryInfoMapper.countProductNameOrWarehouseName(productOrWarehouse);
        return new PageImpl<>(list, pageUtil.getPageable(), count);
    }
}
