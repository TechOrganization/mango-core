package com.mango.mango.core.page;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mango.mango.common.utils.ReflectionUtils;

import java.util.List;

/**
 * @ClassName MybatisPageHelper
 * @Description TODO
 * @Autgor huang
 * @Date 2020-02-23 09:50
 */
public class MybatisPageHelper {

    public static final String findPage = "findPage";

    /**
     * 分页查询，约定查询方法为：findPage
     * @param pageRequest 分页请求
     * @param mapper mapper对象，mybatis的mapper
     * @return
     */
    public static PageResult findPage(PageRequest pageRequest, Object mapper) {
        return findPage(pageRequest,mapper,findPage);
    }

    /**
     * 调用分页插件进行分页查询
     * @param pageRequest 分页请求
     * @param mapper mapper对象，mybatis的mapper
     * @param queryMethodName 分页要查询的名字
     * @param args 防范参数
     * @return
     */
    @SuppressWarnings({"unchecked","rawtypes"})
    public static PageResult findPage(PageRequest pageRequest, Object mapper,String queryMethodName, Object...args) {

        // 设置分页参数
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        // 利用反射调用插叙方法
        Object result = ReflectionUtils.invoke(mapper, queryMethodName, args);
        return getPageResult(pageRequest, new PageInfo<>((List)result));
    }

    private static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo) {

        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;

    }
}
