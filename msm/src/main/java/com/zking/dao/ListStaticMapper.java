package com.zking.dao;

import com.zking.pojo.ListStatic;

public interface ListStaticMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ListStatic record);

    int insertSelective(ListStatic record);

    ListStatic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ListStatic record);

    int updateByPrimaryKey(ListStatic record);
}