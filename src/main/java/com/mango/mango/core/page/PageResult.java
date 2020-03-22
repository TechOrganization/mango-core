package com.mango.mango.core.page;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName PageResult
 * @Description TODO
 * @Autgor huang
 * @Date 2020-02-23 09:43
 */
@Data
public class PageResult {

    /**
     * 当前页码
     */
    private Integer pageNum;

    /**
     * 每页数量
     */
    private Integer pageSize;

    /**
     * 记录数量
     */
    private Long totalSize;

    /**
     * 页码总数
     */
    private Integer totalPages;

    /**
     * 分页数量
     */
    private List<?> content;
}
