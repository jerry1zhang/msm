package com.zking.service.impl;

import com.zking.dao.ListStaticMapper;
import com.zking.pojo.ListStatic;
import com.zking.service.BaseService;
import com.zking.service.ListStaticService;
import com.zking.util.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("list")
public class ListStaticServiceImpl implements BaseService{
    @Resource
    ListStaticMapper ListStaticMapper;

    @Override
    public PageData getAllList(PageData pg) {
        String list_type = pg.getString("list_type");
        List<ListStatic> list = ListStaticMapper.selectByListType(list_type);
        PageData pageData = new PageData();
        pageData.put("list",list);
        return pageData;
    }

    @Override
    public PageData getAllPageList(PageData pg) {
        return null;
    }

    @Override
    public PageData getPartList(PageData pg) {
        return null;
    }

    @Override
    public PageData getPartPageList(PageData pg) {
        return null;
    }

    @Override
    public boolean del(Object object) {
        return false;
    }

    @Override
    public boolean add(Object object) {
        return false;
    }

    @Override
    public boolean update(Object object) {
        return false;
    }

    @Override
    public Object select(Object object) {
        return null;
    }
}
