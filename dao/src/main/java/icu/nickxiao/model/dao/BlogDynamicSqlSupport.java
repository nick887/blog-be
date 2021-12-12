package icu.nickxiao.model.dao;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class BlogDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: blog")
    public static final Blog blog = new Blog();

    /**
     * Database Column Remarks:
     *   blog id
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: blog.id")
    public static final SqlColumn<Long> id = blog.id;

    /**
     * Database Column Remarks:
     *   喜欢数
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: blog.likes")
    public static final SqlColumn<Long> likes = blog.likes;

    /**
     * Database Column Remarks:
     *   主题
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: blog.topic")
    public static final SqlColumn<String> topic = blog.topic;

    /**
     * Database Column Remarks:
     *   浏览记录
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: blog.visit_count")
    public static final SqlColumn<Long> visitCount = blog.visitCount;

    /**
     * Database Column Remarks:
     *   标题
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: blog.title")
    public static final SqlColumn<String> title = blog.title;

    /**
     * Database Column Remarks:
     *   创建时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: blog.created")
    public static final SqlColumn<LocalDateTime> created = blog.created;

    /**
     * Database Column Remarks:
     *   更新时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: blog.updated")
    public static final SqlColumn<LocalDateTime> updated = blog.updated;

    /**
     * Database Column Remarks:
     *   删除时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: blog.deleted")
    public static final SqlColumn<LocalDateTime> deleted = blog.deleted;

    /**
     * Database Column Remarks:
     *   主体
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: blog.body")
    public static final SqlColumn<String> body = blog.body;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: blog")
    public static final class Blog extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> likes = column("likes", JDBCType.BIGINT);

        public final SqlColumn<String> topic = column("topic", JDBCType.VARCHAR);

        public final SqlColumn<Long> visitCount = column("visit_count", JDBCType.BIGINT);

        public final SqlColumn<String> title = column("title", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> created = column("created", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> updated = column("updated", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> deleted = column("deleted", JDBCType.TIMESTAMP);

        public final SqlColumn<String> body = column("body", JDBCType.LONGVARCHAR);

        public Blog() {
            super("blog");
        }
    }
}