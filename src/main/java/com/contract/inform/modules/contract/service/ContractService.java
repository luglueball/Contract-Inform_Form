package com.contract.inform.modules.contract.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.contract.inform.modules.contract.entity.Contract;
import com.contract.inform.modules.contract.form.ContractBase;

import java.util.List;
import java.util.Map;

public interface ContractService extends IService<Contract> {

    boolean save(Contract contract);

    IPage<Contract> queryPage(Map<String, Object> params);

    List<ContractBase> listProjectName(Map<String, Object> params);
}
