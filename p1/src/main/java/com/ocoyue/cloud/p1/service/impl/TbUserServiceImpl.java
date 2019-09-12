package com.ocoyue.cloud.p1.service.impl;

import com.ocoyue.cloud.p1.mapper.TbUserMapper;
import com.ocoyue.cloud.p1.service.TbUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: Zoé
 * @date: 2019/9/12 下午7:57
 * @describe: TODO
 */
@Service
public class TbUserServiceImpl implements TbUserService {

    @Resource
    private TbUserMapper userMapper;

}
