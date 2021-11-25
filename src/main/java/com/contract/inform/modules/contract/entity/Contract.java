package com.contract.inform.modules.contract.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@TableName("contract")
public class Contract implements Serializable {
    private static final long serialVersionUID = 1L;
    private String projectNumber;
    private int version;
    private String projectName;
    private String projectShorterName;
    private float contractAmountTotal;
    private float contractAmountBuild;
    private float contractAmountEquip;
    private float incomeAmountTotal;
    private float incomeAmountBuild;
    private float incomeAmountEquip;
    private float costAmountTotal;
    private float costAmountBuild;
    private float costAmountEquip;
    private float profit;
    private String createTime;
}
