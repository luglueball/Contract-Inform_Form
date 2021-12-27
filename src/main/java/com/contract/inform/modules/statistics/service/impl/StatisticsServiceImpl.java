package com.contract.inform.modules.statistics.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.contract.inform.modules.statistics.dao.StatisticsMapper;
import com.contract.inform.modules.statistics.form.ProjectInOutForm;
import com.contract.inform.modules.statistics.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StatisticsServiceImpl extends ServiceImpl<StatisticsMapper, ProjectInOutForm> implements StatisticsService {
    @Autowired
    private StatisticsMapper statisticsMapper;

    @Override
    public List<ProjectInOutForm> statisticsInOutcomeByProject(String[] projectNumbers) {
        List<String> projectNumberList = Arrays.asList(projectNumbers);
        List<ProjectInOutForm> inOutcomeStatistics = statisticsMapper.stasticsInOutcomeByProject(projectNumberList);
        return inOutcomeStatistics;
    }
}
