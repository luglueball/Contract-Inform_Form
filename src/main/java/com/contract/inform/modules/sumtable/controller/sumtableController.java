package com.contract.inform.modules.sumtable.controller;


import com.contract.inform.common.utils.PageUtils;
import com.contract.inform.common.utils.R;
import com.contract.inform.modules.history.entity.IncomeOutcomeHistory;
import com.contract.inform.modules.history.form.ProjectHistoryView;
import com.contract.inform.modules.history.service.HistoryService;
import com.contract.inform.modules.sumtable.entity.SumtableInputs;
import com.contract.inform.modules.sumtable.service.SumtableService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/sumtable")
@Api(description = "总表接口")
public class sumtableController {
    @Autowired
    private SumtableService sumtableService;

    @GetMapping("/list")
//    @RequiresPermissions("")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = new PageUtils(sumtableService.queryPage(params));

        return R.ok().put("data", page);
    }
    /**
     获取历史记录详情
     */
    @PostMapping("/detail")
//    @RequiresPermissions("")
    public R getSumtableDetail(@RequestBody String projectNumber) {
        ProjectHistoryView ProjectHistoryDetail = sumtableService.getSumtableDetail(projectNumber);
        return R.ok().put("data", ProjectHistoryDetail);
    }

    /**
     新增，修改总表记录
     */
    @PostMapping("/save")
//    @RequiresPermissions("")
    public R save(@RequestBody SumtableInputs sumtableInputs) {
        sumtableService.save(sumtableInputs);
        return R.ok();
    }
}
