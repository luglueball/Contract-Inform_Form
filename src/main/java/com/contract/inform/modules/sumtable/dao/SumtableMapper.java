package com.contract.inform.modules.sumtable.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.contract.inform.modules.sumtable.entity.SumtableInputs;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
@CacheNamespace(flushInterval = 300000L)//缓存五分钟过期
public interface SumtableMapper extends BaseMapper<SumtableInputs> {

    SumtableInputs querySumByProjectNumber(@Param("projectNumber")String projectNumber);
    void updateSumtable(SumtableInputs sumtableInputs);
}
