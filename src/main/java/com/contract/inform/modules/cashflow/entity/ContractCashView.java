package com.contract.inform.modules.cashflow.entity;

import com.contract.inform.modules.contract.entity.Contract;
import java.util.List;

public class ContractCashView extends Contract {

    private static final long serialVersionUID = 1L;
    List<CashFlow> cashFlowList;

    public List<CashFlow> getCashFlowList() {
        return cashFlowList;
    }

    public void setCashFlowList(List<CashFlow> cashFlowList) {
        this.cashFlowList = cashFlowList;
    }
}
