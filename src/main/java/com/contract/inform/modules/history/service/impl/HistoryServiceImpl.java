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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl extends ServiceImpl<HistoryMapper, IncomeOutcomeHistory> implements HistoryService {
    @Autowired
    HistoryMapper historyMapper;

    @Override
    public IPage<ProjectHistoryView> queryPage(Map<String, Object> params) {
        long currPage = Long.valueOf((String) params.get("currPage"));
        long pageSize = Long.valueOf((String) params.get("pageSize"));
        String projectName = (String) params.get("projectName");
        String stage = (String) params.get("stage");
        if (stage == null || stage == "") {
            Date d = new Date();
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            stage = dateformat.format(d).substring(0,7);
        }
        Page<ProjectHistoryView> page = new Page<>(currPage, pageSize);
        IPage<ProjectHistoryView> contractList = historyMapper.listHistory(page,projectName,stage);
        return contractList;
    }

    @Override
    public ProjectHistoryView getHistoryByProjectNumber(String projectNumber) {
        ProjectHistoryView projectHistoryView = historyMapper.queryProjectHistory(projectNumber);
        return projectHistoryView;
    }

    @Override
    public boolean save(IncomeOutcomeHistory incomeOutcomeHistory) {
        IncomeOutcomeHistory queryResultOfCurrentMonth =
                historyMapper.queryHistoryByProjectNumber(incomeOutcomeHistory.getProjectNumber(),
                        incomeOutcomeHistory.getStage());
        String lastMonth =  getLastMonth(incomeOutcomeHistory.getStage());
        IncomeOutcomeHistory queryResultOfLastMonth =
                historyMapper.queryHistoryByProjectNumber(incomeOutcomeHistory.getProjectNumber(),
                        lastMonth);
        float currAccumulatedActualCharges = 0;
        float accumulatedActualPayment = 0;
        if (queryResultOfCurrentMonth == null ) {
//            Date d = new Date();
//            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            String createTime = dateformat.format(d);
            if (queryResultOfLastMonth == null) {
                currAccumulatedActualCharges = incomeOutcomeHistory.getCurrentCharge();
                accumulatedActualPayment = incomeOutcomeHistory.getCurrentPayment();
            } else {
                currAccumulatedActualCharges = queryResultOfLastMonth.getAccumulatedActualCharges() +
                        incomeOutcomeHistory.getCurrentCharge();
                accumulatedActualPayment = queryResultOfLastMonth.getAccumulatedActualPayment() +
                        incomeOutcomeHistory.getCurrentPayment();
            }
            incomeOutcomeHistory.setStage(incomeOutcomeHistory.getStage());
            incomeOutcomeHistory.setAccumulatedActualCharges(currAccumulatedActualCharges);
            incomeOutcomeHistory.setAccumulatedActualPayment(accumulatedActualPayment);
            historyMapper.insert(incomeOutcomeHistory);
        } else {
            if (queryResultOfLastMonth == null) {
                currAccumulatedActualCharges = incomeOutcomeHistory.getCurrentCharge();
                accumulatedActualPayment = incomeOutcomeHistory.getCurrentPayment();
            } else {
                currAccumulatedActualCharges = queryResultOfLastMonth.getAccumulatedActualCharges() +
                        incomeOutcomeHistory.getCurrentCharge();
                accumulatedActualPayment = queryResultOfLastMonth.getAccumulatedActualPayment() +
                        incomeOutcomeHistory.getCurrentPayment();
            }
            incomeOutcomeHistory.setAccumulatedActualCharges(currAccumulatedActualCharges);
            incomeOutcomeHistory.setAccumulatedActualPayment(accumulatedActualPayment);
            historyMapper.updateByProject(incomeOutcomeHistory);
        }
        return false;
    }

    private String getLastMonth (String stage){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        try {
            Date sourceDate = format.parse(stage);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(sourceDate); // 设置为当前时间
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1); // 设置为上一个月
            String accDate = format.format(calendar.getTime());
            return accDate;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}
