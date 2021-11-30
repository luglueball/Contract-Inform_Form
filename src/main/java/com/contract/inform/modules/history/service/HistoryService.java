package com.contract.inform.modules.history.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.contract.inform.modules.history.entity.IncomeOutcomeHistory;
import com.contract.inform.modules.history.form.ProjectHistoryView;

import java.util.Map;

public interface HistoryService extends IService<IncomeOutcomeHistory> {

    IPage<ProjectHistoryView> queryPage(Map<String, Object> params);

    ProjectHistoryView getHistoryByProjectNumber(String projectNumber);

    boolean save(IncomeOutcomeHistory incomeOutcomeHistory);
}
