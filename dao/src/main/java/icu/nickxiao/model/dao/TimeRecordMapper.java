package icu.nickxiao.model.dao;

import static icu.nickxiao.model.dao.TimeRecordDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import icu.nickxiao.model.entity.TimeRecord;
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
public interface TimeRecordMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: time_record")
    BasicColumn[] selectList = BasicColumn.columnList(id, timestamp, created, updated, deleted);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: time_record")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: time_record")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: time_record")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<TimeRecord> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: time_record")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<TimeRecord> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: time_record")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TimeRecordResult")
    Optional<TimeRecord> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: time_record")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TimeRecordResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="timestamp", property="timestamp", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created", property="created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated", property="updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deleted", property="deleted", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TimeRecord> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: time_record")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: time_record")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, timeRecord, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: time_record")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, timeRecord, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: time_record")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: time_record")
    default int insert(TimeRecord record) {
        return MyBatis3Utils.insert(this::insert, record, timeRecord, c ->
            c.map(id).toProperty("id")
            .map(timestamp).toProperty("timestamp")
            .map(created).toProperty("created")
            .map(updated).toProperty("updated")
            .map(deleted).toProperty("deleted")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: time_record")
    default int insertMultiple(Collection<TimeRecord> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, timeRecord, c ->
            c.map(id).toProperty("id")
            .map(timestamp).toProperty("timestamp")
            .map(created).toProperty("created")
            .map(updated).toProperty("updated")
            .map(deleted).toProperty("deleted")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: time_record")
    default int insertSelective(TimeRecord record) {
        return MyBatis3Utils.insert(this::insert, record, timeRecord, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(timestamp).toPropertyWhenPresent("timestamp", record::getTimestamp)
            .map(created).toPropertyWhenPresent("created", record::getCreated)
            .map(updated).toPropertyWhenPresent("updated", record::getUpdated)
            .map(deleted).toPropertyWhenPresent("deleted", record::getDeleted)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: time_record")
    default Optional<TimeRecord> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, timeRecord, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: time_record")
    default List<TimeRecord> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, timeRecord, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: time_record")
    default List<TimeRecord> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, timeRecord, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: time_record")
    default Optional<TimeRecord> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: time_record")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, timeRecord, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: time_record")
    static UpdateDSL<UpdateModel> updateAllColumns(TimeRecord record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(timestamp).equalTo(record::getTimestamp)
                .set(created).equalTo(record::getCreated)
                .set(updated).equalTo(record::getUpdated)
                .set(deleted).equalTo(record::getDeleted);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: time_record")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(TimeRecord record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(timestamp).equalToWhenPresent(record::getTimestamp)
                .set(created).equalToWhenPresent(record::getCreated)
                .set(updated).equalToWhenPresent(record::getUpdated)
                .set(deleted).equalToWhenPresent(record::getDeleted);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: time_record")
    default int updateByPrimaryKey(TimeRecord record) {
        return update(c ->
            c.set(timestamp).equalTo(record::getTimestamp)
            .set(created).equalTo(record::getCreated)
            .set(updated).equalTo(record::getUpdated)
            .set(deleted).equalTo(record::getDeleted)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: time_record")
    default int updateByPrimaryKeySelective(TimeRecord record) {
        return update(c ->
            c.set(timestamp).equalToWhenPresent(record::getTimestamp)
            .set(created).equalToWhenPresent(record::getCreated)
            .set(updated).equalToWhenPresent(record::getUpdated)
            .set(deleted).equalToWhenPresent(record::getDeleted)
            .where(id, isEqualTo(record::getId))
        );
    }
}