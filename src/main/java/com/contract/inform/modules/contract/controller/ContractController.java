package com.contract.inform.modules.contract.controller;


import com.contract.inform.common.utils.PageUtils;
import com.contract.inform.common.utils.R;
import com.contract.inform.modules.contract.entity.Contract;
import com.contract.inform.modules.contract.service.ContractService;
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

        return R.ok().put("page", page);
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
        List<String> projectNames = contractService.listProjectName(params);

        return R.ok().put("projectNames", projectNames);
    }

}
