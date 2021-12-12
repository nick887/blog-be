package icu.nickxiao.model.dao;

import static icu.nickxiao.model.dao.UserOperationLogDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import icu.nickxiao.model.entity.UserOperationLog;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface UserOperationLogMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_operation_log")
    BasicColumn[] selectList = BasicColumn.columnList(requestId, method, userId, status, url, created, updated, requestBody, responseBody, requestParams);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_operation_log")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_operation_log")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_operation_log")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<UserOperationLog> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_operation_log")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<UserOperationLog> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_operation_log")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UserOperationLogResult")
    Optional<UserOperationLog> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_operation_log")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UserOperationLogResult", value = {
        @Result(column="request_id", property="requestId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="method", property="method", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="created", property="created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated", property="updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="request_body", property="requestBody", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="response_body", property="responseBody", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="request_params", property="requestParams", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<UserOperationLog> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_operation_log")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_operation_log")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, userOperationLog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_operation_log")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, userOperationLog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_operation_log")
    default int deleteByPrimaryKey(Long requestId_) {
        return delete(c -> 
            c.where(requestId, isEqualTo(requestId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_operation_log")
    default int insert(UserOperationLog record) {
        return MyBatis3Utils.insert(this::insert, record, userOperationLog, c ->
            c.map(requestId).toProperty("requestId")
            .map(method).toProperty("method")
            .map(userId).toProperty("userId")
            .map(status).toProperty("status")
            .map(url).toProperty("url")
            .map(created).toProperty("created")
            .map(updated).toProperty("updated")
            .map(requestBody).toProperty("requestBody")
            .map(responseBody).toProperty("responseBody")
            .map(requestParams).toProperty("requestParams")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_operation_log")
    default int insertMultiple(Collection<UserOperationLog> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, userOperationLog, c ->
            c.map(requestId).toProperty("requestId")
            .map(method).toProperty("method")
            .map(userId).toProperty("userId")
            .map(status).toProperty("status")
            .map(url).toProperty("url")
            .map(created).toProperty("created")
            .map(updated).toProperty("updated")
            .map(requestBody).toProperty("requestBody")
            .map(responseBody).toProperty("responseBody")
            .map(requestParams).toProperty("requestParams")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_operation_log")
    default int insertSelective(UserOperationLog record) {
        return MyBatis3Utils.insert(this::insert, record, userOperationLog, c ->
            c.map(requestId).toPropertyWhenPresent("requestId", record::getRequestId)
            .map(method).toPropertyWhenPresent("method", record::getMethod)
            .map(userId).toPropertyWhenPresent("userId", record::getUserId)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
            .map(url).toPropertyWhenPresent("url", record::getUrl)
            .map(created).toPropertyWhenPresent("created", record::getCreated)
            .map(updated).toPropertyWhenPresent("updated", record::getUpdated)
            .map(requestBody).toPropertyWhenPresent("requestBody", record::getRequestBody)
            .map(responseBody).toPropertyWhenPresent("responseBody", record::getResponseBody)
            .map(requestParams).toPropertyWhenPresent("requestParams", record::getRequestParams)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_operation_log")
    default Optional<UserOperationLog> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, userOperationLog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_operation_log")
    default List<UserOperationLog> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, userOperationLog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_operation_log")
    default List<UserOperationLog> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, userOperationLog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_operation_log")
    default Optional<UserOperationLog> selectByPrimaryKey(Long requestId_) {
        return selectOne(c ->
            c.where(requestId, isEqualTo(requestId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_operation_log")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, userOperationLog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_operation_log")
    static UpdateDSL<UpdateModel> updateAllColumns(UserOperationLog record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(requestId).equalTo(record::getRequestId)
                .set(method).equalTo(record::getMethod)
                .set(userId).equalTo(record::getUserId)
                .set(status).equalTo(record::getStatus)
                .set(url).equalTo(record::getUrl)
                .set(created).equalTo(record::getCreated)
                .set(updated).equalTo(record::getUpdated)
                .set(requestBody).equalTo(record::getRequestBody)
                .set(responseBody).equalTo(record::getResponseBody)
                .set(requestParams).equalTo(record::getRequestParams);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_operation_log")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(UserOperationLog record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(requestId).equalToWhenPresent(record::getRequestId)
                .set(method).equalToWhenPresent(record::getMethod)
                .set(userId).equalToWhenPresent(record::getUserId)
                .set(status).equalToWhenPresent(record::getStatus)
                .set(url).equalToWhenPresent(record::getUrl)
                .set(created).equalToWhenPresent(record::getCreated)
                .set(updated).equalToWhenPresent(record::getUpdated)
                .set(requestBody).equalToWhenPresent(record::getRequestBody)
                .set(responseBody).equalToWhenPresent(record::getResponseBody)
                .set(requestParams).equalToWhenPresent(record::getRequestParams);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_operation_log")
    default int updateByPrimaryKey(UserOperationLog record) {
        return update(c ->
            c.set(method).equalTo(record::getMethod)
            .set(userId).equalTo(record::getUserId)
            .set(status).equalTo(record::getStatus)
            .set(url).equalTo(record::getUrl)
            .set(created).equalTo(record::getCreated)
            .set(updated).equalTo(record::getUpdated)
            .set(requestBody).equalTo(record::getRequestBody)
            .set(responseBody).equalTo(record::getResponseBody)
            .set(requestParams).equalTo(record::getRequestParams)
            .where(requestId, isEqualTo(record::getRequestId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_operation_log")
    default int updateByPrimaryKeySelective(UserOperationLog record) {
        return update(c ->
            c.set(method).equalToWhenPresent(record::getMethod)
            .set(userId).equalToWhenPresent(record::getUserId)
            .set(status).equalToWhenPresent(record::getStatus)
            .set(url).equalToWhenPresent(record::getUrl)
            .set(created).equalToWhenPresent(record::getCreated)
            .set(updated).equalToWhenPresent(record::getUpdated)
            .set(requestBody).equalToWhenPresent(record::getRequestBody)
            .set(responseBody).equalToWhenPresent(record::getResponseBody)
            .set(requestParams).equalToWhenPresent(record::getRequestParams)
            .where(requestId, isEqualTo(record::getRequestId))
        );
    }
}