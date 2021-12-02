package com.contract.inform.modules.cashflow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.contract.inform.modules.cashflow.entity.CashFlow;
import com.contract.inform.modules.cashflow.form.ContractCashView;
import com.contract.inform.modules.cashflow.form.CashFlowForm;

public interface CashFlowService extends IService<CashFlow> {

    boolean save(CashFlowForm cashFlowForm);

    ContractCashView getCashByContract(String projectNumber);

//    IPage<?> queryPage(Map<String, Object> params);
}
