package com.contract.inform.modules.sumtable.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.contract.inform.modules.sumtable.entity.SumtableInputs;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@CacheNamespace(flushInterval = 300000L)//缓存五分钟过期
public interface SumtableMapper extends BaseMapper<SumtableInputs> {
}
