package com.contract.inform.modules.cashflow.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.contract.inform.modules.cashflow.entity.CashFlow;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
@CacheNamespace(flushInterval = 300000L)//缓存五分钟过期
public interface CashFlowMapper extends BaseMapper<CashFlow> {

    @Select("SELECT count(*) FROM cash_flow WHERE project_number = #{projectNumber}")
    int queryByProjectNumber(String projectNumber);

    void deleteByMap();

    void insertCashFlowList(List<CashFlow> cashFlowList);
}
