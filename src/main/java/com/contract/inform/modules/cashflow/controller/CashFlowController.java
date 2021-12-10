package com.contract.inform.modules.cashflow.controller;


import com.contract.inform.common.utils.R;
import com.contract.inform.modules.cashflow.entity.CashFlow;
import com.contract.inform.modules.cashflow.form.ContractCashView;
import com.contract.inform.modules.cashflow.form.CashFlowForm;
import com.contract.inform.modules.cashflow.service.CashFlowService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cashflow")
@Api(description = "现金流接口")
public class CashFlowController {

    @Autowired
    private CashFlowService cashFlowService;
    /**
     * 新增或者更新
     */
    @PostMapping("/save")
//    @RequiresPermissions("")
    public R save(@RequestBody List<CashFlow> cashFlowList) {
        cashFlowService.save(cashFlowList);
        return R.ok();
    }

    @GetMapping("/cashOfContract")
//    @RequiresPermissions("")
    public R getCashByContract(@RequestParam Map<String, Object> params) {
        String projectNumber = (String) params.get("projectNumber");
        ContractCashView contractCashView = cashFlowService.getCashByContract(projectNumber);
        return R.ok().put("data", contractCashView);
    }
}
