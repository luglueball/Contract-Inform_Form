package com.contract.inform.modules.sumtable.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("sum_table_inputs")
public class SumtableInputs implements Serializable {
    private static final long serialVersionUID = 1L;
    private String projectNumber;
    private String stage; //年月 2021年10月
    private String agency;                      //实施机构
    private float paymentBeforeRemittance;      //回款前付款
    private float paymentAfterRemittance;       //回款后付款
    private float unplannedCharges;             //计划外收费
    private float unplannedPayment;             //计划外付费
    private float currentPlannedPayment;        //当月计划付款=回款前付款+回款后付款
    private float projectImageProgress;         //形象进度
}
