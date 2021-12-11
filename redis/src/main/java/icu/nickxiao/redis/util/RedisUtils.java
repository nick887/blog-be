package icu.nickxiao.redis.util;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * @author nick
 * @version 1.0, 2021/12/11
 * @since 1.0.0
 */
@Slf4j
public final class RedisUtils {
    private RedisUtils() {}

    /**
     * 带分布式锁的执行方法
     *
     * @param lock      锁对象
     * @param waitTime  阻塞等待时间
     * @param leaseTime 自动释放锁时间
     * @param timeUnit  时间单位
     * @param runnable  具体执行方法
     * @return true - 执行成功；false - 执行失败
     */
    public static boolean lockExecute(RLock lock, long waitTime, long leaseTime, TimeUnit timeUnit,
                                      Runnable runnable) {
        Boolean result = lockExecute(lock, waitTime, leaseTime, timeUnit, () -> {
            runnable.run();
            return true;
        });
        return null != result && result;
    }

    /**
     * 带分布式锁的执行方法，会返回一个值
     *
     * @param lock      锁对象
     * @param waitTime  阻塞等待时间
     * @param leaseTime 自动释放锁时间
     * @param timeUnit  时间单位
     * @param supplier  具体执行方法
     * @param <R>       返回值的类型
     * @return 返回apply后的值 - 执行成功；null - 执行失败
     */
    public static <R> R lockExecute(RLock lock, long waitTime, long leaseTime, TimeUnit timeUnit, Supplier<R> supplier) {
        boolean tryLocked = false;
        try {
            // 尝试获取分布式锁
            tryLocked = lock.tryLock(waitTime, leaseTime, timeUnit);
            if (!tryLocked) {
                log.info("{} tryLock failed", lock.getName());
                return null;
            }
            // 需要保证当前线程获取到锁才能继续
            return supplier.get();
        } catch (Exception e) {
            log.warn("{} execute exception", lock.getName(), e);
        } finally {
            if (tryLocked) {
                lock.unlock();
            }
        }
        return null;
    }
}
