package com.contract.inform.modules.history.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("income_outcome_history")
public class IncomeOutcomeHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    private String projectNumber;
    private String stage;                     //年月
    private float accumulatedRevenue;         //累计营收
    private float currentTwoAmount;           //当期两金
    private float unfinishedConstructionFee;  //未完施工
    private float accountsReceivable;         //应收账款
    private float accumulatedActualCharges;   //累计实际收费
    private float currentCharge;              //当期收费
    private float accumulatedActualPayment;   //累计实际付费
    private float currentPayment;             //当期付费
    private float profitDeviation;            //利润偏差
    private float settlementRevenueProportion;  //结转营收比例
    private float actualChargeProportion;       //实际收费比例
    private float actualPaymentProportion;      //实际付费比例
}
