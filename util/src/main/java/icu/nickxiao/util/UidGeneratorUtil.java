package icu.nickxiao.util;

/**
 * @author xiaoyi03 <xiaoyi03@kuaishou.com>
 * Created on 2021-12-12
 */
@SuppressWarnings("MagicNumber")
public final class UidGeneratorUtil {

    private UidGeneratorUtil() {
    }

    /**
     * 生成id
     *
     * <p><ul>
     * <li>最终uid的构造 0(64bit) + timestamp(63 ~ 32 bit) + machineId(31 ~ 25 bit) + counter(24 ~ 1bit)</li>
     * <li>@see <a href="http://mongodb.github.io/mongo-java-driver/3.7/javadoc/org/bson/types/ObjectId.html">ObjectId</a></li>
     * </ul>
     *
     * @return id
     */
    public static long generateUid() {
        ObjectId objectId = ObjectId.get();
        long timestamp = objectId.getTimestamp();
        long machineId = (objectId.getMachineIdentifier() & 0XEF);
        long count = (objectId.getCounter() & 0xFFFFFF);
        timestamp = timestamp << 31;
        machineId = machineId << 24;
        return (timestamp | machineId | count);
    }

    /**
     * 从id中获取时间戳
     *
     * @return 返回时间戳，单位：秒
     */
    public static long getTimestamp(long id) {
        return (id >> 31);
    }
}
