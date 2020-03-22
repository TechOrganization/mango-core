package com.mango.mango.core.service;

import com.mango.mango.core.page.PageRequest;
import com.mango.mango.core.page.PageResult;

import java.util.List;

public interface CurdService<T> {

    /**
     * 新增
     *
     * @param record
     * @return
     */
    boolean save(T record);

    /**
     * 修改
     *
     * @param record
     * @return
     */
    boolean update(T record);

    /**
     * 删除
     *
     * @param record
     * @return
     */
    int delete(T record);

    /**
     * 批量删除
     *
     * @param records
     * @return
     */
    boolean delete(List<T> records);

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    T findById(Long id);

    PageResult findPage(PageRequest pageRequest);
}
