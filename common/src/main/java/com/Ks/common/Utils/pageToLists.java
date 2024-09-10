package com.Ks.common.Utils;


import java.util.ArrayList;
import java.util.List;

/**
 * 分页拆分
 */
public class pageToLists {

    /**
     * 拆分列表为分页，并将结果存储在 Map 中
     *
     * @param list     需要分页的原始列表
     * @param pageSize 每页的元素数量
     * @return 包含分页结果的 Map，键为页码，值为每页的内容
     */
    public static <T> List<List<T>> paginateToMap(List<T> list, int pageSize) {
        List<List<T>> paginatedMap = new ArrayList<>();

        if (list == null || pageSize <= 0) {
            return paginatedMap; // 返回空 Map
        }

        int totalSize = list.size();
        int totalPages = (int) Math.ceil((double) totalSize / pageSize);

        for (int i = 0; i < totalPages; i++) {
            int start = i * pageSize;
            int end = Math.min(start + pageSize, totalSize);
            List<T> page = list.subList(start, end);
            paginatedMap.add(new ArrayList<>(page)); // 页码从1开始
        }
        return paginatedMap;
    }

}
