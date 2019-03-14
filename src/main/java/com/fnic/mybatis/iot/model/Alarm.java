package com.fnic.mybatis.iot.model;

public class Alarm {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column alarm.id
     *
     * @mbg.generated
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column alarm.ack_ts
     *
     * @mbg.generated
     */
    private Long ackTs;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column alarm.clear_ts
     *
     * @mbg.generated
     */
    private Long clearTs;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column alarm.additional_info
     *
     * @mbg.generated
     */
    private String additionalInfo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column alarm.end_ts
     *
     * @mbg.generated
     */
    private Long endTs;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column alarm.originator_id
     *
     * @mbg.generated
     */
    private String originatorId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column alarm.originator_type
     *
     * @mbg.generated
     */
    private Integer originatorType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column alarm.propagate
     *
     * @mbg.generated
     */
    private Boolean propagate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column alarm.severity
     *
     * @mbg.generated
     */
    private String severity;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column alarm.start_ts
     *
     * @mbg.generated
     */
    private Long startTs;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column alarm.status
     *
     * @mbg.generated
     */
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column alarm.tenant_id
     *
     * @mbg.generated
     */
    private String tenantId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column alarm.type
     *
     * @mbg.generated
     */
    private String type;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column alarm.id
     *
     * @return the value of alarm.id
     *
     * @mbg.generated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column alarm.id
     *
     * @param id the value for alarm.id
     *
     * @mbg.generated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column alarm.ack_ts
     *
     * @return the value of alarm.ack_ts
     *
     * @mbg.generated
     */
    public Long getAckTs() {
        return ackTs;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column alarm.ack_ts
     *
     * @param ackTs the value for alarm.ack_ts
     *
     * @mbg.generated
     */
    public void setAckTs(Long ackTs) {
        this.ackTs = ackTs;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column alarm.clear_ts
     *
     * @return the value of alarm.clear_ts
     *
     * @mbg.generated
     */
    public Long getClearTs() {
        return clearTs;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column alarm.clear_ts
     *
     * @param clearTs the value for alarm.clear_ts
     *
     * @mbg.generated
     */
    public void setClearTs(Long clearTs) {
        this.clearTs = clearTs;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column alarm.additional_info
     *
     * @return the value of alarm.additional_info
     *
     * @mbg.generated
     */
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column alarm.additional_info
     *
     * @param additionalInfo the value for alarm.additional_info
     *
     * @mbg.generated
     */
    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo == null ? null : additionalInfo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column alarm.end_ts
     *
     * @return the value of alarm.end_ts
     *
     * @mbg.generated
     */
    public Long getEndTs() {
        return endTs;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column alarm.end_ts
     *
     * @param endTs the value for alarm.end_ts
     *
     * @mbg.generated
     */
    public void setEndTs(Long endTs) {
        this.endTs = endTs;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column alarm.originator_id
     *
     * @return the value of alarm.originator_id
     *
     * @mbg.generated
     */
    public String getOriginatorId() {
        return originatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column alarm.originator_id
     *
     * @param originatorId the value for alarm.originator_id
     *
     * @mbg.generated
     */
    public void setOriginatorId(String originatorId) {
        this.originatorId = originatorId == null ? null : originatorId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column alarm.originator_type
     *
     * @return the value of alarm.originator_type
     *
     * @mbg.generated
     */
    public Integer getOriginatorType() {
        return originatorType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column alarm.originator_type
     *
     * @param originatorType the value for alarm.originator_type
     *
     * @mbg.generated
     */
    public void setOriginatorType(Integer originatorType) {
        this.originatorType = originatorType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column alarm.propagate
     *
     * @return the value of alarm.propagate
     *
     * @mbg.generated
     */
    public Boolean getPropagate() {
        return propagate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column alarm.propagate
     *
     * @param propagate the value for alarm.propagate
     *
     * @mbg.generated
     */
    public void setPropagate(Boolean propagate) {
        this.propagate = propagate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column alarm.severity
     *
     * @return the value of alarm.severity
     *
     * @mbg.generated
     */
    public String getSeverity() {
        return severity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column alarm.severity
     *
     * @param severity the value for alarm.severity
     *
     * @mbg.generated
     */
    public void setSeverity(String severity) {
        this.severity = severity == null ? null : severity.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column alarm.start_ts
     *
     * @return the value of alarm.start_ts
     *
     * @mbg.generated
     */
    public Long getStartTs() {
        return startTs;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column alarm.start_ts
     *
     * @param startTs the value for alarm.start_ts
     *
     * @mbg.generated
     */
    public void setStartTs(Long startTs) {
        this.startTs = startTs;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column alarm.status
     *
     * @return the value of alarm.status
     *
     * @mbg.generated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column alarm.status
     *
     * @param status the value for alarm.status
     *
     * @mbg.generated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column alarm.tenant_id
     *
     * @return the value of alarm.tenant_id
     *
     * @mbg.generated
     */
    public String getTenantId() {
        return tenantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column alarm.tenant_id
     *
     * @param tenantId the value for alarm.tenant_id
     *
     * @mbg.generated
     */
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column alarm.type
     *
     * @return the value of alarm.type
     *
     * @mbg.generated
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column alarm.type
     *
     * @param type the value for alarm.type
     *
     * @mbg.generated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alarm
     *
     * @mbg.generated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Alarm other = (Alarm) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAckTs() == null ? other.getAckTs() == null : this.getAckTs().equals(other.getAckTs()))
            && (this.getClearTs() == null ? other.getClearTs() == null : this.getClearTs().equals(other.getClearTs()))
            && (this.getAdditionalInfo() == null ? other.getAdditionalInfo() == null : this.getAdditionalInfo().equals(other.getAdditionalInfo()))
            && (this.getEndTs() == null ? other.getEndTs() == null : this.getEndTs().equals(other.getEndTs()))
            && (this.getOriginatorId() == null ? other.getOriginatorId() == null : this.getOriginatorId().equals(other.getOriginatorId()))
            && (this.getOriginatorType() == null ? other.getOriginatorType() == null : this.getOriginatorType().equals(other.getOriginatorType()))
            && (this.getPropagate() == null ? other.getPropagate() == null : this.getPropagate().equals(other.getPropagate()))
            && (this.getSeverity() == null ? other.getSeverity() == null : this.getSeverity().equals(other.getSeverity()))
            && (this.getStartTs() == null ? other.getStartTs() == null : this.getStartTs().equals(other.getStartTs()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getTenantId() == null ? other.getTenantId() == null : this.getTenantId().equals(other.getTenantId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alarm
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAckTs() == null) ? 0 : getAckTs().hashCode());
        result = prime * result + ((getClearTs() == null) ? 0 : getClearTs().hashCode());
        result = prime * result + ((getAdditionalInfo() == null) ? 0 : getAdditionalInfo().hashCode());
        result = prime * result + ((getEndTs() == null) ? 0 : getEndTs().hashCode());
        result = prime * result + ((getOriginatorId() == null) ? 0 : getOriginatorId().hashCode());
        result = prime * result + ((getOriginatorType() == null) ? 0 : getOriginatorType().hashCode());
        result = prime * result + ((getPropagate() == null) ? 0 : getPropagate().hashCode());
        result = prime * result + ((getSeverity() == null) ? 0 : getSeverity().hashCode());
        result = prime * result + ((getStartTs() == null) ? 0 : getStartTs().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getTenantId() == null) ? 0 : getTenantId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        return result;
    }
}