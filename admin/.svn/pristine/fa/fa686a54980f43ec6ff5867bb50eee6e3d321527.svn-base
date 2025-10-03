/**
 * @mbg.generated generator on Fri Mar 29 11:27:03 ICT 2024
 */
package com.base.admin.hrm.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.base.admin.hrm.dto.UnitItemDTO;
import com.base.admin.hrm.entity.Units;
import com.base.admin.hrm.mapper.UnitsMapper;
import com.base.admin.utils.ClassUtils;

@Service
public class UnitsServiceImpl implements UnitsService {
    private final UnitsMapper unitsMapper;

    public UnitsServiceImpl(UnitsMapper unitsMapper) {
        this.unitsMapper = unitsMapper;
    }

    @Override
    public int deleteByPrimaryKey(UUID unitid) {
        return unitsMapper.deleteByPrimaryKey(unitid);
    }

    @Override
    public int insert(Units row) {
        return unitsMapper.insert(row);
    }

    @Override
    public int insertSelective(Units row) {
        return unitsMapper.insertSelective(row);
    }

    @Override
    public Units selectByPrimaryKey(UUID unitid) {
        return unitsMapper.selectByPrimaryKey(unitid);
    }

    @Override
    public int updateByPrimaryKeySelective(Units row) {
        return unitsMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int updateByPrimaryKey(Units row) {
        return unitsMapper.updateByPrimaryKey(row);
    }

    @Override
    public Units findById(UUID unitid) {
        return unitsMapper.selectByPrimaryKey(unitid);
    }

    @Override
    public Page<Units> searchPaged(Units search, Pageable pageable, boolean exact) {
        long total = 0;
        List<Units> content = unitsMapper.searchPaged(search, pageable, exact);
        if (!content.isEmpty()) {
            total = unitsMapper.countPaged(search, exact);
        }
        return new PageImpl<>(content, pageable, total);
    }

    //    @Override
    //    public int addUnit(Units unitDTO) {
    //        return 0;
    //    }
    //
    //    @Override
    //    public int update(Units unitDTO) {
    //        return 0;
    //    }
    //
    //    @Override
    //    public int deleteById(UUID unitid) {
    //        return 0;
    //    }
    // }

    @Override
    public int addUnit(Units unitDTO) {
        unitDTO.setUnitid(UUID.randomUUID());
        return unitsMapper.insert(unitDTO);
    }

    @Override
    public int update(Units unitDTO) {
        Units unit = unitsMapper.selectByPrimaryKey(unitDTO.getUnitid());
        if (unit != null) {
            unit = (Units) ClassUtils.convertDTOToEntity(unitDTO, unit);
            return unitsMapper.updateByPrimaryKey(unit);
        }
        return 0;
    }

    @Override
    public int deleteById(UUID unitid) {
        return unitsMapper.deleteByPrimaryKey(unitid);
    }

    @Override
    public List<UnitItemDTO> getTreeOfUnits(UUID organizationid) {

        List<UnitItemDTO> unitItems = unitsMapper.getUnitItems(organizationid);
        if (!unitItems.isEmpty()) {
            int level = 0;
            return recursiveMenuItem(unitItems, null, level);
        }
        return null;
    }

    private boolean isHasChildren(List<UnitItemDTO> allItems, UUID parent) {
        return allItems.parallelStream()
                .anyMatch(item -> (item.getParentunitid().equals(parent)));
    }

    private List<UnitItemDTO> recursiveMenuItem(List<UnitItemDTO> allItems, UUID parent, int level) {
        if (!allItems.isEmpty()) {
            List<UnitItemDTO> items = GetPageSameLevelAndSort(allItems, parent);
            if (!items.isEmpty()) {
                for (UnitItemDTO menu : items) {
                    menu.setLevel(level);
                    if (isHasChildren(allItems, menu.getUnitid())) {
                        menu.setChildItem(recursiveMenuItem(allItems, menu.getUnitid(), level + 1));
                    }
                }
                level++;
                return items;
            }
        }
        return null;
    }

    private List<UnitItemDTO> GetPageSameLevelAndSort(List<UnitItemDTO> allItems, UUID parent) {
        List<UnitItemDTO> itemsSameParent = allItems.parallelStream()
                .filter(item -> ((item.getParentunitid() == null && parent == null)
                        || ((item.getParentunitid() != null && parent != null)
                                && item.getParentunitid().equals(parent))))
                .toList();

        if (!itemsSameParent.isEmpty()) {
            allItems.removeAll(itemsSameParent);
        }

        return itemsSameParent;
    }
}
