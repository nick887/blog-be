package icu.nickxiao.model.dao;

import static icu.nickxiao.model.dao.BlogDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import icu.nickxiao.model.entity.Blog;
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
public interface BlogMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: blog")
    BasicColumn[] selectList = BasicColumn.columnList(id, likes, topic, visitCount, title, created, updated, deleted, body);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: blog")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: blog")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: blog")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Blog> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: blog")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Blog> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: blog")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("BlogResult")
    Optional<Blog> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: blog")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="BlogResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="likes", property="likes", jdbcType=JdbcType.BIGINT),
        @Result(column="topic", property="topic", jdbcType=JdbcType.VARCHAR),
        @Result(column="visit_count", property="visitCount", jdbcType=JdbcType.BIGINT),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="created", property="created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated", property="updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deleted", property="deleted", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="body", property="body", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Blog> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: blog")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: blog")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, blog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: blog")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, blog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: blog")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: blog")
    default int insert(Blog record) {
        return MyBatis3Utils.insert(this::insert, record, blog, c ->
            c.map(id).toProperty("id")
            .map(likes).toProperty("likes")
            .map(topic).toProperty("topic")
            .map(visitCount).toProperty("visitCount")
            .map(title).toProperty("title")
            .map(created).toProperty("created")
            .map(updated).toProperty("updated")
            .map(deleted).toProperty("deleted")
            .map(body).toProperty("body")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: blog")
    default int insertMultiple(Collection<Blog> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, blog, c ->
            c.map(id).toProperty("id")
            .map(likes).toProperty("likes")
            .map(topic).toProperty("topic")
            .map(visitCount).toProperty("visitCount")
            .map(title).toProperty("title")
            .map(created).toProperty("created")
            .map(updated).toProperty("updated")
            .map(deleted).toProperty("deleted")
            .map(body).toProperty("body")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: blog")
    default int insertSelective(Blog record) {
        return MyBatis3Utils.insert(this::insert, record, blog, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(likes).toPropertyWhenPresent("likes", record::getLikes)
            .map(topic).toPropertyWhenPresent("topic", record::getTopic)
            .map(visitCount).toPropertyWhenPresent("visitCount", record::getVisitCount)
            .map(title).toPropertyWhenPresent("title", record::getTitle)
            .map(created).toPropertyWhenPresent("created", record::getCreated)
            .map(updated).toPropertyWhenPresent("updated", record::getUpdated)
            .map(deleted).toPropertyWhenPresent("deleted", record::getDeleted)
            .map(body).toPropertyWhenPresent("body", record::getBody)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: blog")
    default Optional<Blog> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, blog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: blog")
    default List<Blog> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, blog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: blog")
    default List<Blog> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, blog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: blog")
    default Optional<Blog> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: blog")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, blog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: blog")
    static UpdateDSL<UpdateModel> updateAllColumns(Blog record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(likes).equalTo(record::getLikes)
                .set(topic).equalTo(record::getTopic)
                .set(visitCount).equalTo(record::getVisitCount)
                .set(title).equalTo(record::getTitle)
                .set(created).equalTo(record::getCreated)
                .set(updated).equalTo(record::getUpdated)
                .set(deleted).equalTo(record::getDeleted)
                .set(body).equalTo(record::getBody);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: blog")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Blog record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(likes).equalToWhenPresent(record::getLikes)
                .set(topic).equalToWhenPresent(record::getTopic)
                .set(visitCount).equalToWhenPresent(record::getVisitCount)
                .set(title).equalToWhenPresent(record::getTitle)
                .set(created).equalToWhenPresent(record::getCreated)
                .set(updated).equalToWhenPresent(record::getUpdated)
                .set(deleted).equalToWhenPresent(record::getDeleted)
                .set(body).equalToWhenPresent(record::getBody);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: blog")
    default int updateByPrimaryKey(Blog record) {
        return update(c ->
            c.set(likes).equalTo(record::getLikes)
            .set(topic).equalTo(record::getTopic)
            .set(visitCount).equalTo(record::getVisitCount)
            .set(title).equalTo(record::getTitle)
            .set(created).equalTo(record::getCreated)
            .set(updated).equalTo(record::getUpdated)
            .set(deleted).equalTo(record::getDeleted)
            .set(body).equalTo(record::getBody)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: blog")
    default int updateByPrimaryKeySelective(Blog record) {
        return update(c ->
            c.set(likes).equalToWhenPresent(record::getLikes)
            .set(topic).equalToWhenPresent(record::getTopic)
            .set(visitCount).equalToWhenPresent(record::getVisitCount)
            .set(title).equalToWhenPresent(record::getTitle)
            .set(created).equalToWhenPresent(record::getCreated)
            .set(updated).equalToWhenPresent(record::getUpdated)
            .set(deleted).equalToWhenPresent(record::getDeleted)
            .set(body).equalToWhenPresent(record::getBody)
            .where(id, isEqualTo(record::getId))
        );
    }
}