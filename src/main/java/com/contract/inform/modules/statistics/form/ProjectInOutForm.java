package com.contract.inform.modules.statistics.form;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProjectInOutForm implements Serializable {
    private static final long serialVersionUID = 1L;
    private String stage;
    private float cumulateIncome;            //计划收费
    private float cumulateOutcome;           //计划付费
    private float accumulatedActualCharges;  //实际应收
    private float accumulatedActualPayment;  //实际付费
}
