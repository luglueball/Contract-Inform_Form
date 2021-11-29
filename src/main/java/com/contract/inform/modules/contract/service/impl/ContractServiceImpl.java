package com.contract.inform.modules.contract.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.contract.inform.modules.contract.dao.ContractMapper;
import com.contract.inform.modules.contract.entity.Contract;
import com.contract.inform.modules.contract.form.ContractBase;
import com.contract.inform.modules.contract.service.ContractService;
import lombok.RequiredArgsConstructor;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ContractServiceImpl extends ServiceImpl<ContractMapper, Contract> implements ContractService {
    @Autowired
    private ContractMapper contractMapper;
    @Override
    public IPage<Contract> queryPage(Map<String, Object> params) {
        long currPage = Long.valueOf((String) params.get("currPage"));
        long pageSize = Long.valueOf((String) params.get("pageSize"));
        String projectName = (String) params.get("projectName");
        Page<Contract> page = new Page<>(currPage, pageSize);
        IPage<Contract> contractList = contractMapper.listContract(page,projectName);
        return contractList;
    }

    @Override
    public List<ContractBase> listProjectName(Map<String, Object> params) {
        String projectName = (String) params.get("projectName");
        List<ContractBase> projectNames = contractMapper.listProjectName(projectName);
        return projectNames;
    }

    @Override
    public boolean save(Contract contract) {
        Contract queryResult = contractMapper.queryByProjectNumber(contract.getProjectNumber());
        if (queryResult != null && queryResult.getVersion() > 0 ) {
            int version = queryResult.getVersion() + 1;
            contract.setCreateTime(queryResult.getCreateTime());
            contract.setVersion(version);
        } else{
            Date d = new Date();
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String createTime = dateformat.format(d);
            contract.setVersion(1);
            contract.setCreateTime(createTime);
        }
        contractMapper.insert(contract);
        return false;
    }

}
