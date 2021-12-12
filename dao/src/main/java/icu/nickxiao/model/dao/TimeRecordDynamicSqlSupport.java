package icu.nickxiao.model.dao;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class TimeRecordDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: time_record")
    public static final TimeRecord timeRecord = new TimeRecord();

    /**
     * Database Column Remarks:
     *   blog id
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: time_record.id")
    public static final SqlColumn<Long> id = timeRecord.id;

    /**
     * Database Column Remarks:
     *   服务器起始运行时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: time_record.timestamp")
    public static final SqlColumn<LocalDateTime> timestamp = timeRecord.timestamp;

    /**
     * Database Column Remarks:
     *   创建时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: time_record.created")
    public static final SqlColumn<LocalDateTime> created = timeRecord.created;

    /**
     * Database Column Remarks:
     *   更新时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: time_record.updated")
    public static final SqlColumn<LocalDateTime> updated = timeRecord.updated;

    /**
     * Database Column Remarks:
     *   删除时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: time_record.deleted")
    public static final SqlColumn<LocalDateTime> deleted = timeRecord.deleted;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: time_record")
    public static final class TimeRecord extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> timestamp = column("`timestamp`", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> created = column("created", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> updated = column("updated", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> deleted = column("deleted", JDBCType.TIMESTAMP);

        public TimeRecord() {
            super("time_record");
        }
    }
}