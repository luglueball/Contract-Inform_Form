package com.contract.inform.modules.sumtable.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.contract.inform.modules.history.form.ProjectHistoryView;
import com.contract.inform.modules.sumtable.entity.SumtableInputs;
import com.contract.inform.modules.sumtable.mapper.SumtableMapper;
import com.contract.inform.modules.sumtable.service.SumtableService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class SumtableServiceImpl extends ServiceImpl<SumtableMapper, SumtableInputs> implements SumtableService {
    @Autowired
    private SumtableMapper sumtableMapper;

    @Override
    public IPage<?> queryPage(Map<String, Object> params) {
        return null;
    }

    @Override
    public ProjectHistoryView getSumtableDetail(String projectNumber) {
        return null;
    }

    @Override
    public boolean save(SumtableInputs sumtableInputs) {
        sumtableMapper.insert(sumtableInputs);
        return false;
    }


}
