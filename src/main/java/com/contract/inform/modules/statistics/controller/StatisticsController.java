package com.contract.inform.modules.statistics.controller;


import com.contract.inform.common.utils.PageUtils;
import com.contract.inform.common.utils.R;
import com.contract.inform.modules.statistics.form.ProjectInOutForm;
import com.contract.inform.modules.statistics.service.StatisticsService;
import com.contract.inform.modules.sumtable.service.SumtableService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/statistics")
@Api(description = "统计接口")
public class StatisticsController {
    @Autowired
    private StatisticsService statisticservice;

    @PostMapping("/getInOutcomeByProject")
//    @RequiresPermissions("")
    public R getInOutcomeByProject(@RequestBody String[] projectNumbers) {
        List<ProjectInOutForm> list = statisticservice.statisticsInOutcomeByProject(projectNumbers);

        return R.ok().put("data", list);
    }
}
