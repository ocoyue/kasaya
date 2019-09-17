package com.ocoyue.cloud.p1.mapper;

import com.ocoyue.cloud.p1.domain.TbUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.MyMapper;
import tk.mybatis.mapper.annotation.RegisterMapper;

@Mapper
public interface TbUserMapper extends MyMapper<TbUser> {
}