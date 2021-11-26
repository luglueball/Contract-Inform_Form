package com.contract.inform.modules.history.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.contract.inform.modules.contract.entity.Contract;
import com.contract.inform.modules.history.dao.HistoryMapper;
import com.contract.inform.modules.history.entity.IncomeOutcomeHistory;
import com.contract.inform.modules.history.form.ProjectHistoryView;
import com.contract.inform.modules.history.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl extends ServiceImpl<HistoryMapper, IncomeOutcomeHistory> implements HistoryService {
    @Autowired
    HistoryMapper historyMapper;

    @Override
    public IPage<IncomeOutcomeHistory> queryPage(Map<String, Object> params) {
        long currPage = Long.valueOf((String) params.get("currPage"));
        long pageSize = Long.valueOf((String) params.get("pageSize"));
        String projectName = (String) params.get("projectName");
        Page<IncomeOutcomeHistory> page = new Page<>(currPage, pageSize);
        IPage<IncomeOutcomeHistory> contractList = historyMapper.listHistory(page,projectName);
        return contractList;
    }

    @Override
    public ProjectHistoryView getHistoryByProjectNumber(String projectNumber) {
        ProjectHistoryView projectHistoryView = historyMapper.queryProjectHistory(projectNumber);
        return projectHistoryView;
    }

    @Override
    public boolean save(IncomeOutcomeHistory incomeOutcomeHistory) {
        IncomeOutcomeHistory queryResult = historyMapper.queryHistoryByProjectNumber(incomeOutcomeHistory.getProjectNumber());
        if (queryResult == null ) {
            historyMapper.insert(incomeOutcomeHistory);
        }
        return false;
    }
}
