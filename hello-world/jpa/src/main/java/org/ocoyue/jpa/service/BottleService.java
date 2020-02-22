package org.ocoyue.jpa.service;

import org.ocoyue.jpa.entity.Bottle;
import org.ocoyue.jpa.jpa.BottleJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Zoé
 * @date: 2019/9/18  上午9:54
 * @describe: TODO
 */
@Service
public class BottleService {

    @Autowired
    public BottleJpa bottleJpa;

    public List<Bottle> findAll(){
        List<Bottle> list = bottleJpa.findAll();
        return list;
    }

    public Object saveAll(List<Bottle> list) {
        bottleJpa.saveAll(list);
        return "OK";
    }
}
