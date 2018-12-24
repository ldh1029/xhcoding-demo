package com.example.demo.config;

/**
 * 设置需要调用哪个数据源
 * 具体类型 {@link DBTypeEnum}
 */
public class DataSourceKeyHolder {
    private static ThreadLocal<String> DATASOURCE_KEY_HOLDER = new ThreadLocal<>();
    /**
     * 设置数据源
     * @param dbTypeEnum
     */
    public static void set(DBTypeEnum dbTypeEnum) {
        DATASOURCE_KEY_HOLDER.set(dbTypeEnum.getValue());
    }

    /**
     * 取得当前数据源
     */
    public static String get() {
        return DATASOURCE_KEY_HOLDER.get();
    }

    /**
     * 清除
     */
    public static void clear() {
        DATASOURCE_KEY_HOLDER.remove();
    }
}
