package cn.koboro.offlineservice.constants;

/**
 * @author xdw
 */
public class CommonConstants {

    /**
     * 乐观锁默认失败重试次数
     */
    public static final int DEFAULT_MAX_RETRIES = 5;

    public interface Dict{
        public static final int TYPE_PARENT = 1;
        public static final int TYPE_CHILD = 2;
    }

}
