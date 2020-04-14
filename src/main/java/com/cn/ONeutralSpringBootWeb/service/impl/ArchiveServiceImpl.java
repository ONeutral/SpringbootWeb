package com.cn.ONeutralSpringBootWeb.service.impl;

import com.cn.ONeutralSpringBootWeb.dao.ArchiveMapper;
import com.cn.ONeutralSpringBootWeb.pojo.BlogInfo;
import com.cn.ONeutralSpringBootWeb.service.ArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("ArchiveService")
@Transactional(rollbackFor = Exception.class)
public class ArchiveServiceImpl implements ArchiveService {

    @Autowired
    private ArchiveMapper archiveMapper;

    @Override
    public Map<String, Integer> findAchiveByYear() {
        List<String> years = archiveMapper.findAchiveByYear();
        HashMap<String,Integer> map = new HashMap<>();
        for (String year : years) {
            map.put(year,archiveMapper.findYearByNum(year));
        }
        return map;
    }

    @Override
    public List<BlogInfo> findByYear(String year) {
        return archiveMapper.findByYear(year);
    }
}
