package com.contract.inform.modules.sumtable.form;

import com.contract.inform.modules.sumtable.entity.SumtableInputs;
import lombok.Data;

@Data
public class ProjectSumView extends SumtableInputs {
    private String projectName;
    private float accumulatedActualCharges;     //history表 累计实际收费
    private float accumulatedActualPayment;     //history表 累计付费
    private float settlementRevenueProportion;  //history表 结转营收比例
    private float actualChargeProportion;       //history表 实际收费比例
    private float profitDeviation;              //history表 利润偏差
    private float cumulateIncome;               //cashflow表 累计现金流
    private float currentTwoAmount;             //history表 当期两金
    private float balanceOfCurrentTwoAmount;    //当月计划两金余额 = 当期两金+当月计划付费+计划外付费-计划外收费-当月计划收费
    private float currentPlannedCharge;         //当月计划收费 = 表3（累计计划收费）-表4（累计实际收费）
}
