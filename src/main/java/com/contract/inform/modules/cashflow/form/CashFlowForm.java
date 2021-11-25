package com.contract.inform.modules.cashflow.form;

import com.contract.inform.modules.cashflow.entity.CashFlow;

import java.util.List;

public class CashFlowForm {
    private String projectNumber;
    List<CashFlow> cashFlowList;

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public List<CashFlow> getCashFlowList() {
        return cashFlowList;
    }

    public void setCashFlowList(List<CashFlow> cashFlowList) {
        this.cashFlowList = cashFlowList;
    }
}
