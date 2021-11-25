package com.contract.inform.modules.cashflow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.contract.inform.modules.cashflow.entity.CashFlow;
import com.contract.inform.modules.cashflow.form.CashFlowForm;


import java.util.Map;

public interface CashFlowService extends IService<CashFlow> {

    boolean save(CashFlowForm cashFlowForm);

//    IPage<?> queryPage(Map<String, Object> params);
}
