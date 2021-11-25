package com.contract.inform.modules.history.form;

import com.contract.inform.modules.history.entity.IncomeOutcomeHistory;

public class ProjectHistoryView extends IncomeOutcomeHistory {
    private String projectName;
    private float contractAmountTotal;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public float getContractAmountTotal() {
        return contractAmountTotal;
    }

    public void setContractAmountTotal(float contractAmountTotal) {
        this.contractAmountTotal = contractAmountTotal;
    }

    public float getIncomeAmountTotal() {
        return incomeAmountTotal;
    }

    public void setIncomeAmountTotal(float incomeAmountTotal) {
        this.incomeAmountTotal = incomeAmountTotal;
    }

    private float incomeAmountTotal;
}
