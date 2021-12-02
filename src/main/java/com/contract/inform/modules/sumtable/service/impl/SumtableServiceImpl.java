package com.contract.inform.modules.sumtable.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.contract.inform.modules.history.form.ProjectHistoryView;
import com.contract.inform.modules.sumtable.entity.SumtableInputs;
import com.contract.inform.modules.sumtable.dao.SumtableMapper;
import com.contract.inform.modules.sumtable.form.ProjectSumView;
import com.contract.inform.modules.sumtable.service.SumtableService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SumtableServiceImpl extends ServiceImpl<SumtableMapper, SumtableInputs> implements SumtableService {
    @Autowired
    private SumtableMapper sumtableMapper;

    @Override
    public IPage<ProjectSumView> queryPage(Map<String, Object> params) {
        long currPage = Long.valueOf((String) params.get("currPage"));
        long pageSize = Long.valueOf((String) params.get("pageSize"));
        String projectName = (String) params.get("projectName");
        String stage = (String) params.get("stage");
        if (stage == null || stage == "") {
            Date d = new Date();
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            stage = dateformat.format(d).substring(0,7);
        }
        Page<ProjectSumView> page = new Page<>(currPage, pageSize);
        IPage<ProjectSumView> contractList = sumtableMapper.listProjectSum(page,projectName,stage);
        return contractList;
    }

    @Override
    public ProjectHistoryView getSumtableDetail(String projectNumber) {
        return null;
    }

    @Override
    public boolean save(SumtableInputs sumtableInputs) {
        SumtableInputs sumtableInputsSelected = sumtableMapper.querySumByProjectNumber(sumtableInputs.getProjectNumber());
        if (sumtableInputsSelected == null) {
            sumtableMapper.insert(sumtableInputs);
        } else {
            sumtableMapper.updateSumtable(sumtableInputs);
        }
        return false;
    }


}
