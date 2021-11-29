package com.contract.inform.modules.contract.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("contract")
public class Contract implements Serializable {
    private static final long serialVersionUID = 1L;
    private String projectNumber;
    private int version;
    private String projectName;
    private String projectShorterName;
    private float contractAmountTotal;     //合同总金额
    private float contractAmountBuild;
    private float contractAmountEquip;
    private float contractAmountOther;
    private float incomeAmountTotal;
    private float incomeAmountBuild;
    private float incomeAmountEquip;
    private float incomeAmountOther;
    private float costAmountTotal;        //预计总成本
    private float costAmountBuild;
    private float costAmountEquip;
    private float costAmountOther;
    private float profit;
    private String createTime;
}
