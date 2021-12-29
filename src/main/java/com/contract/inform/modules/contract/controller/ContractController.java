package com.contract.inform.modules.contract.controller;


import com.contract.inform.common.utils.PageUtils;
import com.contract.inform.common.utils.R;
import com.contract.inform.modules.contract.entity.Contract;
import com.contract.inform.modules.contract.form.ContractBase;
import com.contract.inform.modules.contract.service.ContractService;
import com.contract.inform.modules.history.service.HistoryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 合同表
 */
@RestController
@RequestMapping("/contract")
@Api(description = "合同接口")
public class ContractController {
    @Autowired
    private ContractService contractService;

    @GetMapping("/list")
//    @RequiresPermissions("")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = new PageUtils(contractService.queryPage(params));

        return R.ok().put("data", page);
    }

    /**
     * 新增或者更新
     */
    @PostMapping("/save")
//    @RequiresPermissions("")
    public R save(@RequestBody Contract contract) {
        contractService.save(contract);
        return R.ok();
    }

    @GetMapping("/listProjectName")
//    @RequiresPermissions("")
    public R listProjectName(@RequestParam Map<String, Object> params) {
        List<ContractBase> data = contractService.listProjectName(params);

        return R.ok().put("data", data);
    }

    @GetMapping("/detail")
//    @RequiresPermissions("")
    public R getContractDetail(@RequestParam String projectNumber) {
        Contract data = contractService.getContractDetail(projectNumber);

        return R.ok().put("data", data);
    }

}
