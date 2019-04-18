package com.srtp.dispute.domain.es;

/**
 * 录入案件-入参
 */
public class CaseInputDTO {
    private String disputeNO;
    private String district; //区域
    private String disputeName; //纠纷名称
    private String evaluation; //案情评估
    private String fierceDegree; //激烈程度
    private String disputePerson;
    private String compensation; //涉及金额
    private String disputeDegree; //纠纷等级
    private String acceptDate; //受理时间
    private String disputeOrigin; //案件来源
    private String disputeType; //纠纷类型
    private String disputeArea; //纠纷区域
    private String disputeLocation; //发生地点
    private String briefInfo; //简要情况
    private String disputeResolution; //调解结果
    private String resolutionDate; //调解成功时间
    private String institution; //责任单位
    private String staffName; //调解员
    private String agreement; //达成协议内容
    private String disputeTag; //标签
    private String personName;//当事人姓名
    private String hospitalName;//医院名称

    public String getDisputeNO() {
        return disputeNO;
    }

    public void setDisputeNO(String disputeNO) {
        this.disputeNO = disputeNO;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDisputeName() {
        return disputeName;
    }

    public void setDisputeName(String disputeName) {
        this.disputeName = disputeName;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public String getFierceDegree() {
        return fierceDegree;
    }

    public void setFierceDegree(String fierceDegree) {
        this.fierceDegree = fierceDegree;
    }

    public String getDisputePerson() {
        return disputePerson;
    }

    public void setDisputePerson(String disputePerson) {
        this.disputePerson = disputePerson;
    }

    public String getCompensation() {
        return compensation;
    }

    public void setCompensation(String compensation) {
        this.compensation = compensation;
    }

    public String getDisputeDegree() {
        return disputeDegree;
    }

    public void setDisputeDegree(String disputeDegree) {
        this.disputeDegree = disputeDegree;
    }

    public String getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(String acceptDate) {
        this.acceptDate = acceptDate;
    }

    public String getDisputeOrigin() {
        return disputeOrigin;
    }

    public void setDisputeOrigin(String disputeOrigin) {
        this.disputeOrigin = disputeOrigin;
    }

    public String getDisputeType() {
        return disputeType;
    }

    public void setDisputeType(String disputeType) {
        this.disputeType = disputeType;
    }

    public String getDisputeArea() {
        return disputeArea;
    }

    public void setDisputeArea(String disputeArea) {
        this.disputeArea = disputeArea;
    }

    public String getDisputeLocation() {
        return disputeLocation;
    }

    public void setDisputeLocation(String disputeLocation) {
        this.disputeLocation = disputeLocation;
    }

    public String getBriefInfo() {
        return briefInfo;
    }

    public void setBriefInfo(String briefInfo) {
        this.briefInfo = briefInfo;
    }

    public String getDisputeResolution() {
        return disputeResolution;
    }

    public void setDisputeResolution(String disputeResolution) {
        this.disputeResolution = disputeResolution;
    }

    public String getResolutionDate() {
        return resolutionDate;
    }

    public void setResolutionDate(String resolutionDate) {
        this.resolutionDate = resolutionDate;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }

    public String getDisputeTag() {
        return disputeTag;
    }

    public void setDisputeTag(String disputeTag) {
        this.disputeTag = disputeTag;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }
}
