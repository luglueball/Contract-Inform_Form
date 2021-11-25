package com.contract.inform.modules.cashflow.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.contract.inform.modules.cashflow.dao.CashFlowMapper;
import com.contract.inform.modules.cashflow.entity.CashFlow;
import com.contract.inform.modules.cashflow.form.CashFlowForm;
import com.contract.inform.modules.cashflow.service.CashFlowService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CashFlowServiceImpl extends ServiceImpl<CashFlowMapper, CashFlow> implements CashFlowService {
    @Autowired
    private CashFlowMapper cashFlowMapper;

    @Override
    public boolean save(CashFlowForm cashFlowForm) {
        int count = cashFlowMapper.queryByProjectNumber(cashFlowForm.getProjectNumber());
        if (count > 0) {
            Map<String, Object> columnMap = new HashMap<String, Object>();
            columnMap.put("project_number", cashFlowForm.getProjectNumber());
            cashFlowMapper.deleteByMap(columnMap);
        }
        List<CashFlow> cashFlowList = cashFlowForm.getCashFlowList();
        cashFlowList.stream().forEach(item -> {
            item.setProjectNumber(cashFlowForm.getProjectNumber());
        });
        cashFlowMapper.insertCashFlowList(cashFlowList);
        return false;
    }
}
