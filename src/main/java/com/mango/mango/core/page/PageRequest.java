package com.mango.mango.core.page;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName PageRequest
 * @Description TODO
 * @Autgor huang
 * @Date 2020-02-23 09:43
 */
@Data
public class PageRequest {

    /**
     * 当前页码
     */
    private Integer pageNum = 1;

    /**
     * 每页数量
     */
    private Integer pageSize = 10;

    /**
     * 查询参数
     */
    private Map<String, Object> params = new HashMap<>();

}
