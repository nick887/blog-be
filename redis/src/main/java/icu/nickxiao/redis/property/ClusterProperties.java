package icu.nickxiao.redis.property;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author nick
 * @version 1.0, 2021/12/11
 * @since 1.0.0
 */
@Data
@ToString
public class ClusterProperties {

    /** 集群节点 */
    private List<String> nodes;

    /** 集群状态扫描间隔时间，单位：毫秒 */
    private int scanInterval = 5000;

    /** slots覆盖检查 */
    private boolean checkSlotsCoverage = true;
}

