package icu.nickxiao.model.dao;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UserDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    public static final User user = new User();

    /**
     * Database Column Remarks:
     *   用户id
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user.id")
    public static final SqlColumn<Long> id = user.id;

    /**
     * Database Column Remarks:
     *   邮箱
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user.email")
    public static final SqlColumn<String> email = user.email;

    /**
     * Database Column Remarks:
     *   用户昵称
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user.nickname")
    public static final SqlColumn<String> nickname = user.nickname;

    /**
     * Database Column Remarks:
     *   状态
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user.status")
    public static final SqlColumn<String> status = user.status;

    /**
     * Database Column Remarks:
     *   角色
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user.role")
    public static final SqlColumn<String> role = user.role;

    /**
     * Database Column Remarks:
     *   创建时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user.created")
    public static final SqlColumn<LocalDateTime> created = user.created;

    /**
     * Database Column Remarks:
     *   更新时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user.updated")
    public static final SqlColumn<LocalDateTime> updated = user.updated;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    public static final class User extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> email = column("email", JDBCType.VARCHAR);

        public final SqlColumn<String> nickname = column("nickname", JDBCType.VARCHAR);

        public final SqlColumn<String> status = column("`status`", JDBCType.VARCHAR);

        public final SqlColumn<String> role = column("`role`", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> created = column("created", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> updated = column("updated", JDBCType.TIMESTAMP);

        public User() {
            super("user");
        }
    }
}