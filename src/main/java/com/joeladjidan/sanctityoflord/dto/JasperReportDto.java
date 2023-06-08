package com.joeladjidan.sanctityoflord.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JasperReportDto {

    private String reportName;
    private List<?> responseEntityList;

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public List<?> getResponseEntityList() {
        return responseEntityList;
    }

    public void setResponseEntityList(List<?> responseEntityList) {
        this.responseEntityList = responseEntityList;
    }


}
