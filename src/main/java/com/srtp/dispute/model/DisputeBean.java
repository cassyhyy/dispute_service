/**
 * 文书类，存放相关信息（与搭建索引有重要联系）
 */
package com.srtp.dispute.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "dispute_index", type = "dispute_texts")
public class DisputeBean {
    @Id
    private Long id; //编号
    @Field(type = FieldType.Keyword)
    private String disputeNO;
    @Field(type = FieldType.Text, analyzer = "ik_max_word", store = true)
    private String district; //区域
    @Field(type = FieldType.Text, analyzer = "ik_max_word", store = true)
    private String disputeName; //纠纷名称
    @Field(type = FieldType.Keyword)
    private String evaluation; //案情评估
    @Field(type = FieldType.Keyword)
    private String fierceDegree; //激烈程度
    @Field(type = FieldType.Keyword)
    private String disputePerson; //涉及人数
    @Field(type = FieldType.Keyword)
    private String compensation; //涉及金额
    @Field(type = FieldType.Keyword)
    private String disputeDegree; //纠纷等级
    @Field(type = FieldType.Keyword)
    private String acceptDate; //受理时间
    @Field(type = FieldType.Keyword)
    private String disputeOrigin; //案件来源
    @Field(type = FieldType.Keyword)
    private String disputeType; //纠纷类型
    @Field(type = FieldType.Keyword)
    private String disputeArea; //纠纷区域
    @Field(type = FieldType.Text, analyzer = "ik_max_word", store = true)
    private String disputeLocation; //发生地点
    @Field(type = FieldType.Text, analyzer = "ik_max_word", store = true)
    private String briefInfo; //简要情况
    @Field(type = FieldType.Keyword)
    private String disputeResolution; //调解结果
    @Field(type = FieldType.Keyword)
    private String resolutionDate; //调解成功时间
    @Field(type = FieldType.Keyword)
    private String institution; //责任单位
    @Field(type = FieldType.Keyword)
    private String staffName; //调解员
    @Field(type = FieldType.Text, analyzer = "ik_max_word", store = true)
    private String agreement; //达成协议内容
    @Field(type = FieldType.Text, analyzer = "ik_max_word", store = true)
    private String disputeTag; //标签
    @Field(type = FieldType.Keyword)
    private String personName;//当事人姓名
    @Field(type = FieldType.Keyword)
    private String hospitalName;//医院名称

    //获取name长度，以便设置展示页面的标题字体大小
    public Integer getLength() {
        return disputeName.length();
    }

    public Long getID() { return id; }
    public void setId(Long id) {
        this.id = id;
    }

    public String getDisputeNO() {
        return disputeNO;
    }
    public void setDisputeNO(String disputeNO) {
        this.disputeNO = disputeNO;
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


    public DisputeBean(String disputeNO, String district, String disputeName, String evaluation, String fierceDegree,
                       String disputePerson, String compensation, String disputeDegree, String acceptDate, String disputeOrigin, String disputeType,
                       String disputeArea, String disputeLocation, String briefInfo, String disputeResolution, String resolutionDate,
                       String institution, String staffName, String agreement, String disputeTag, String personName, String hospitalName) {
        this.disputeNO = disputeNO;
        this.district = district;
        this.disputeName = disputeName;
        this.evaluation = evaluation;
        this.fierceDegree = fierceDegree;
        this.disputePerson = disputePerson;
        this.compensation = compensation;
        this.disputeDegree = disputeDegree;
        this.acceptDate = acceptDate;
        this.disputeOrigin = disputeOrigin;
        this.disputeType = disputeType;
        this.disputeArea = disputeArea;
        this.disputeLocation = disputeLocation;
        this.briefInfo = briefInfo;
        this.disputeResolution = disputeResolution;
        this.resolutionDate = resolutionDate;
        this.institution = institution;
        this.staffName = staffName;
        this.agreement = agreement;
        this.disputeTag = disputeTag;
        this.personName = personName;
        this.hospitalName = hospitalName;

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
    public void setDisputeName(String dn) {
        disputeName = dn;
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

    public String getDisputeDegree() {
        return disputeDegree;
    }
    public void setDisputeDegree(String rank) {
        disputeDegree = rank;
    }

    public String getAcceptDate() {
        return acceptDate;
    }
    public void setAcceptDate(String date) {
        acceptDate = date;
    }

    public String getDisputeOrigin() {
        return disputeOrigin;
    }
    public void setDisputeOrigin(String source) {
        disputeOrigin = source;
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
    public void setDisputeLocation(String location) {
        disputeLocation = location;
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
    public void setDisputeResolution(String result) {
        disputeResolution = result;
    }

    public String getResolutionDate() {
        return resolutionDate;
    }
    public void setResolutionDate(String date) {
        resolutionDate = date;
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
    public void setDisputeTag(String tag) {
        disputeTag = tag;
    }
}
