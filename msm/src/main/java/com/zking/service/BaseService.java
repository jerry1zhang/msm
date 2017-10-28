package com.zking.service;

import com.zking.pojo.Menu;
import com.zking.util.PageData;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BaseService {
    /**
     * 获得全部列表
     * @param pg
     * @return
     */
    PageData getAllList(PageData pg);

    /**
     * 获得全部列表(分页)
     * @param pg
     * @return
     */
    PageData getAllPageList(PageData pg);

    /**
     * 获得部分列表（查询）
     * @param pg
     * @return
     */
    PageData getPartList(PageData pg);

    /**
     * 获得部分列表（查询和分页）
     * @param pg
     * @return
     */
    PageData getPartPageList(PageData pg);

    /**
     * 通过id删除
     * @param object
     * @return
     */
    boolean del(Object object);

    /**
     * 增加
     * @param object
     * @return
     */
    boolean add(Object object);

    /**
     * 修改
     * @param object
     * @return
     */
    boolean update(Object object);

    /**
     * 通过某个值查询
     * @param object
     * @return
     */
    Object select(Object object);
}
