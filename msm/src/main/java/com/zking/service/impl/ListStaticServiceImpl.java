package com.zking.service.impl;

import com.zking.dao.ListStaticMapper;
import com.zking.pojo.ListStatic;
import com.zking.service.ListStaticService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ListStaticServiceImpl implements ListStaticService{
    @Resource
    ListStaticMapper ListStaticMapper;
    @Override
    public List<ListStatic> getList(String list_type) {
        return ListStaticMapper.selectByListType(list_type);
    }
}
