package com.contract.inform.modules.cashflow.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("cash_flow")
public class CashFlow implements Serializable {
    private static final long serialVersionUID = 1L;
    private String projectNumber;
    private String stage; //年月 2021年10月
    private float income;
    private float cumulateIncome;
    private float outcome;
    private float cumulateOutcome;
    private float stageCashFlow;
    private float cumulateCashFLow;
}
