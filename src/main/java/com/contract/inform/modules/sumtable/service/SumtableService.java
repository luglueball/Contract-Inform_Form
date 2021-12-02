package com.contract.inform.modules.sumtable.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.contract.inform.modules.history.form.ProjectHistoryView;
import com.contract.inform.modules.sumtable.entity.SumtableInputs;
import com.contract.inform.modules.sumtable.form.ProjectSumView;

import java.util.Map;

public interface SumtableService extends IService<SumtableInputs> {

    ProjectHistoryView getSumtableDetail(String projectNumber);

    boolean save(SumtableInputs sumtableInputs);

    IPage<ProjectSumView> queryPage(Map<String, Object> params);
}
