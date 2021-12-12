package icu.nickxiao.model.dao;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UserOperationLogDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_operation_log")
    public static final UserOperationLog userOperationLog = new UserOperationLog();

    /**
     * Database Column Remarks:
     *   request_id
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_operation_log.request_id")
    public static final SqlColumn<Long> requestId = userOperationLog.requestId;

    /**
     * Database Column Remarks:
     *   请求方法
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_operation_log.method")
    public static final SqlColumn<String> method = userOperationLog.method;

    /**
     * Database Column Remarks:
     *   请求者id
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_operation_log.user_id")
    public static final SqlColumn<Long> userId = userOperationLog.userId;

    /**
     * Database Column Remarks:
     *   状态码
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_operation_log.status")
    public static final SqlColumn<Integer> status = userOperationLog.status;

    /**
     * Database Column Remarks:
     *   url
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_operation_log.url")
    public static final SqlColumn<String> url = userOperationLog.url;

    /**
     * Database Column Remarks:
     *   创建时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_operation_log.created")
    public static final SqlColumn<LocalDateTime> created = userOperationLog.created;

    /**
     * Database Column Remarks:
     *   更新时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_operation_log.updated")
    public static final SqlColumn<LocalDateTime> updated = userOperationLog.updated;

    /**
     * Database Column Remarks:
     *   请求体
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_operation_log.request_body")
    public static final SqlColumn<String> requestBody = userOperationLog.requestBody;

    /**
     * Database Column Remarks:
     *   响应体
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_operation_log.response_body")
    public static final SqlColumn<String> responseBody = userOperationLog.responseBody;

    /**
     * Database Column Remarks:
     *   request参数
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_operation_log.request_params")
    public static final SqlColumn<String> requestParams = userOperationLog.requestParams;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_operation_log")
    public static final class UserOperationLog extends SqlTable {
        public final SqlColumn<Long> requestId = column("request_id", JDBCType.BIGINT);

        public final SqlColumn<String> method = column("`method`", JDBCType.VARCHAR);

        public final SqlColumn<Long> userId = column("user_id", JDBCType.BIGINT);

        public final SqlColumn<Integer> status = column("`status`", JDBCType.INTEGER);

        public final SqlColumn<String> url = column("url", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> created = column("created", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> updated = column("updated", JDBCType.TIMESTAMP);

        public final SqlColumn<String> requestBody = column("request_body", JDBCType.LONGVARCHAR);

        public final SqlColumn<String> responseBody = column("response_body", JDBCType.LONGVARCHAR);

        public final SqlColumn<String> requestParams = column("request_params", JDBCType.LONGVARCHAR);

        public UserOperationLog() {
            super("user_operation_log");
        }
    }
}