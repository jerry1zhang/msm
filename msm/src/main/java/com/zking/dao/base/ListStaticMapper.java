package com.zking.dao.base;

import com.zking.pojo.base.ListStatic;

public interface ListStaticMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ListStatic record);

    int insertSelective(ListStatic record);

    ListStatic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ListStatic record);

    int updateByPrimaryKey(ListStatic record);
}