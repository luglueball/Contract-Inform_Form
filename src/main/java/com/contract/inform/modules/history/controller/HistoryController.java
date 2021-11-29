package com.contract.inform.modules.history.controller;

import com.contract.inform.common.utils.PageUtils;
import com.contract.inform.common.utils.R;
import com.contract.inform.modules.history.entity.IncomeOutcomeHistory;
import com.contract.inform.modules.history.form.ProjectHistoryView;
import com.contract.inform.modules.history.service.HistoryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 历史表
 */
@RestController
@RequestMapping("/history")
@Api(description = "实际收付费记录接口")
public class HistoryController {
    @Autowired
    private HistoryService historyService;

    @GetMapping("/list")
//    @RequiresPermissions("")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = new PageUtils(historyService.queryPage(params));

        return R.ok().put("data", page);
    }
    /**
     获取历史记录详情
     */
    @PostMapping("/detail")
//    @RequiresPermissions("")
    public R getHistoryByProjectNumber(@RequestBody String projectNumber) {
        ProjectHistoryView ProjectHistoryDetail = historyService.getHistoryByProjectNumber(projectNumber);
        return R.ok().put("data", ProjectHistoryDetail);
    }

    /**
    新增，修改实际收付费记录
     */
    @PostMapping("/save")
//    @RequiresPermissions("")
    public R save(@RequestBody IncomeOutcomeHistory incomeOutcomeHistory) {
        historyService.save(incomeOutcomeHistory);
        return R.ok();
    }
}
