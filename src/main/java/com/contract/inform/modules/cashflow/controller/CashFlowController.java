package com.contract.inform.modules.cashflow.controller;


import com.contract.inform.common.utils.R;
import com.contract.inform.modules.cashflow.entity.CashFlow;
import com.contract.inform.modules.cashflow.form.CashFlowForm;
import com.contract.inform.modules.cashflow.service.CashFlowService;
import com.contract.inform.modules.contract.service.ContractService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public R save(@RequestBody CashFlowForm cashFlowForm) {
        cashFlowService.save(cashFlowForm);
        return R.ok();
    }
}