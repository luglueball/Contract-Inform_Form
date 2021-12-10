package com.contract.inform.modules.cashflow.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.contract.inform.modules.cashflow.dao.CashFlowMapper;
import com.contract.inform.modules.cashflow.entity.CashFlow;
import com.contract.inform.modules.cashflow.form.ContractCashView;
import com.contract.inform.modules.cashflow.form.CashFlowForm;
import com.contract.inform.modules.cashflow.service.CashFlowService;
import com.contract.inform.modules.contract.dao.ContractMapper;
import com.contract.inform.modules.contract.entity.Contract;
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
    @Autowired
    private ContractMapper contractMapper;

    @Override
    public boolean save(List<CashFlow> cashFlowList) {
        int count = cashFlowMapper.queryByProjectNumber(cashFlowList.get(0).getProjectNumber());
        if (count > 0) {
            Map<String, Object> columnMap = new HashMap<String, Object>();
            columnMap.put("project_number", cashFlowList.get(0).getProjectNumber());
            cashFlowMapper.deleteByMap(columnMap);
        }
//        List<CashFlow> cashFlowList = cashFlowForm.getCashFlowList();
//        cashFlowList.stream().forEach(item -> {
//            item.setProjectNumber(cashFlowForm.getProjectNumber());
//        });
        cashFlowMapper.insertCashFlowList(cashFlowList);
        return false;
    }

    @Override
    public ContractCashView getCashByContract(String projectNumber) {
        Contract contractBaseInfo = contractMapper.queryByProjectNumber(projectNumber);
        ContractCashView contractCashView = new ContractCashView();
        contractCashView.setProjectNumber(contractBaseInfo.getProjectNumber());
        contractCashView.setProjectName(contractBaseInfo.getProjectName());
        contractCashView.setContractAmountTotal(contractBaseInfo.getContractAmountTotal());
        contractCashView.setCostAmountTotal(contractBaseInfo.getCostAmountTotal());
        List<CashFlow> cashFlowList = cashFlowMapper.getCashFlowByProjectNumber(projectNumber);
        contractCashView.setCashFlowList(cashFlowList);
        return contractCashView;
    }
}