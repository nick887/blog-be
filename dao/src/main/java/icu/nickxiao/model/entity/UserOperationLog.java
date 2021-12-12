package icu.nickxiao.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.annotation.Generated;

/**
 * Database Table Remarks:
 *   用户操作日志
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table user_operation_log
 */
public class UserOperationLog implements Serializable {
    /**
     * Database Column Remarks:
     *   request_id
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_operation_log.request_id")
    private Long requestId;

    /**
     * Database Column Remarks:
     *   请求方法
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_operation_log.method")
    private String method;

    /**
     * Database Column Remarks:
     *   请求者id
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_operation_log.user_id")
    private Long userId;

    /**
     * Database Column Remarks:
     *   状态码
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_operation_log.status")
    private Integer status;

    /**
     * Database Column Remarks:
     *   创建时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_operation_log.created")
    private LocalDateTime created;

    /**
     * Database Column Remarks:
     *   更新时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_operation_log.updated")
    private LocalDateTime updated;

    /**
     * Database Column Remarks:
     *   请求体
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_operation_log.request_body")
    private String requestBody;

    /**
     * Database Column Remarks:
     *   响应体
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_operation_log.response_body")
    private String responseBody;

    /**
     * Database Column Remarks:
     *   request参数
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_operation_log.request_params")
    private String requestParams;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_operation_log")
    private static final long serialVersionUID = 1L;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_operation_log.request_id")
    public Long getRequestId() {
        return requestId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_operation_log")
    public UserOperationLog withRequestId(Long requestId) {
        this.setRequestId(requestId);
        return this;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_operation_log.request_id")
    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_operation_log.method")
    public String getMethod() {
        return method;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_operation_log")
    public UserOperationLog withMethod(String method) {
        this.setMethod(method);
        return this;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_operation_log.method")
    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_operation_log.user_id")
    public Long getUserId() {
        return userId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_operation_log")
    public UserOperationLog withUserId(Long userId) {
        this.setUserId(userId);
        return this;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_operation_log.user_id")
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_operation_log.status")
    public Integer getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_operation_log")
    public UserOperationLog withStatus(Integer status) {
        this.setStatus(status);
        return this;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_operation_log.status")
    public void setStatus(Integer status) {
        this.status = status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_operation_log.created")
    public LocalDateTime getCreated() {
        return created;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_operation_log")
    public UserOperationLog withCreated(LocalDateTime created) {
        this.setCreated(created);
        return this;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_operation_log.created")
    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_operation_log.updated")
    public LocalDateTime getUpdated() {
        return updated;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_operation_log")
    public UserOperationLog withUpdated(LocalDateTime updated) {
        this.setUpdated(updated);
        return this;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_operation_log.updated")
    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_operation_log.request_body")
    public String getRequestBody() {
        return requestBody;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_operation_log")
    public UserOperationLog withRequestBody(String requestBody) {
        this.setRequestBody(requestBody);
        return this;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_operation_log.request_body")
    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody == null ? null : requestBody.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_operation_log.response_body")
    public String getResponseBody() {
        return responseBody;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_operation_log")
    public UserOperationLog withResponseBody(String responseBody) {
        this.setResponseBody(responseBody);
        return this;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_operation_log.response_body")
    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody == null ? null : responseBody.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_operation_log.request_params")
    public String getRequestParams() {
        return requestParams;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_operation_log")
    public UserOperationLog withRequestParams(String requestParams) {
        this.setRequestParams(requestParams);
        return this;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_operation_log.request_params")
    public void setRequestParams(String requestParams) {
        this.requestParams = requestParams == null ? null : requestParams.trim();
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_operation_log")
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
        UserOperationLog other = (UserOperationLog) that;
        return (this.getRequestId() == null ? other.getRequestId() == null : this.getRequestId().equals(other.getRequestId()))
            && (this.getMethod() == null ? other.getMethod() == null : this.getMethod().equals(other.getMethod()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreated() == null ? other.getCreated() == null : this.getCreated().equals(other.getCreated()))
            && (this.getUpdated() == null ? other.getUpdated() == null : this.getUpdated().equals(other.getUpdated()));
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_operation_log")
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRequestId() == null) ? 0 : getRequestId().hashCode());
        result = prime * result + ((getMethod() == null) ? 0 : getMethod().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreated() == null) ? 0 : getCreated().hashCode());
        result = prime * result + ((getUpdated() == null) ? 0 : getUpdated().hashCode());
        return result;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_operation_log")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", requestId=").append(requestId);
        sb.append(", method=").append(method);
        sb.append(", userId=").append(userId);
        sb.append(", status=").append(status);
        sb.append(", created=").append(created);
        sb.append(", updated=").append(updated);
        sb.append(", requestBody=").append(requestBody);
        sb.append(", responseBody=").append(responseBody);
        sb.append(", requestParams=").append(requestParams);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}