package com.contract.inform.modules.contract.form;

import lombok.Data;

import java.io.Serializable;

public class ContractBase implements Serializable {
    private static final long serialVersionUID = 1L;
    private String projectNumber;
    private String projectName;

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
