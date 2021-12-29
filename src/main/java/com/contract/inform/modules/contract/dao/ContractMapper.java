package com.contract.inform.modules.contract.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.contract.inform.modules.contract.entity.Contract;
import com.contract.inform.modules.contract.form.ContractBase;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
@CacheNamespace(flushInterval = 300000L)//缓存五分钟过期
public interface ContractMapper extends BaseMapper<Contract> {

//    void updateContract(Contract contract);

    Contract queryByProjectNumber(@Param("projectNumber")String projectNumber);

    IPage<Contract> listContract(@Param("page")Page<Contract> page, @Param("projectName")String projectName);

    List<ContractBase> listProjectName(@Param("projectName")String projectName);

}
