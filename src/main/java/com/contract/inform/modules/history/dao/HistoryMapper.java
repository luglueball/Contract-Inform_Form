package com.contract.inform.modules.history.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.contract.inform.modules.history.entity.IncomeOutcomeHistory;
import com.contract.inform.modules.history.form.ProjectHistoryView;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@CacheNamespace(flushInterval = 300000L)//缓存五分钟过期
public interface HistoryMapper extends BaseMapper<IncomeOutcomeHistory> {

    IPage<IncomeOutcomeHistory> listHistory(Page<IncomeOutcomeHistory> page, String projectName);

    IncomeOutcomeHistory queryHistoryByProjectNumber(String projectNumber);

    ProjectHistoryView queryProjectHistory(String projectNumber);

    void updateByProject(IncomeOutcomeHistory incomeOutcomeHistory);
}
