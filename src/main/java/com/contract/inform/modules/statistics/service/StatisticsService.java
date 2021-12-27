package com.contract.inform.modules.statistics.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.contract.inform.modules.statistics.form.ProjectInOutForm;

import java.util.List;
import java.util.Map;

public interface StatisticsService extends IService<ProjectInOutForm> {
    List<ProjectInOutForm> statisticsInOutcomeByProject(String[] params);
}
