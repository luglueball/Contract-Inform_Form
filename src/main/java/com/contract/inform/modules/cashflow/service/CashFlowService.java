package com.contract.inform.modules.cashflow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.contract.inform.modules.cashflow.entity.CashFlow;
import com.contract.inform.modules.cashflow.form.ContractCashView;
import com.contract.inform.modules.cashflow.form.CashFlowForm;

import java.util.List;

public interface CashFlowService extends IService<CashFlow> {

    boolean save(List<CashFlow> cashFlowList);

    ContractCashView getCashByContract(String projectNumber);

//    IPage<?> queryPage(Map<String, Object> params);
}
