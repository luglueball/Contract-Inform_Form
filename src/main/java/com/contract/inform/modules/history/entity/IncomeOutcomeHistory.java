package com.contract.inform.modules.history.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("income_outcome_history")
public class IncomeOutcomeHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    private String projectNumber;
    private float accumulatedRevenue;
    private float currentTwoAmount;
    private float unfinishedConstructionFee;
    private float accountsReceivable;
    private float accumulatedActualCharges;
    private float currentCharge;
    private float accumulatedActualPayment;
    private float currentPayment;
    private float profitDeviation;
    private int settlementRevenueProportion;
    private int actualChargeProportion;
    private int actualPaymentProportion;
}
