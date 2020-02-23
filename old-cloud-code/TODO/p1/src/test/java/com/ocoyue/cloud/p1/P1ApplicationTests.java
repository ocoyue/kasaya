package com.ocoyue.cloud.p1;

import com.ocoyue.cloud.p1.domain.TbUser;
import com.ocoyue.cloud.p1.mapper.TbUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.ocoyue.cloud.p1.mapper")
public class P1ApplicationTests {

    @Autowired
    private TbUserMapper tbUserMapper;

        @Test
        public void contextLoads() {
            System.out.println("单元测试");
        }

        @Test
        public void testSelectAll() {
            // List<TbUser> tbUsers = tbUserMapper.selectAll();
            // tbUsers.forEach(tbUser -> {
            //     System.out.println(tbUser);
            // });
            System.out.println("空方法测试");
            List<TbUser> tbUsers = tbUserMapper.selectAll();
            System.out.println("鸣谢");
        }



}
