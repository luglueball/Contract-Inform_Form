package com.contract.inform.modules.statistics.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.contract.inform.modules.statistics.form.ProjectInOutForm;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
@CacheNamespace(flushInterval = 300000L)//缓存五分钟过期
public interface StatisticsMapper extends BaseMapper<ProjectInOutForm> {
    public List<ProjectInOutForm> stasticsInOutcomeByProject(@Param("projectNumbers")List<String> projectNumbers);
}
