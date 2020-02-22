package org.ocoyue.jpa.web;

import lombok.extern.slf4j.Slf4j;
import org.ocoyue.jpa.entity.Bottle;
import org.ocoyue.jpa.service.BottleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Zoé
 * @date: 2019/9/18  上午9:57
 * @describe: TODO
 */
@Slf4j
@RestController
public class BottleController {

    @Autowired
    public BottleService bottleService;

    @GetMapping(value = "bottle")
    public String getBottles() {
        log.info("bottle");
        List<Bottle> list = bottleService.findAll();
        return list.toString();
    }

    @PutMapping(value = "bottle")
    public String saveBottle(@RequestBody Bottle bottle) {
        // list.add(Bottle.builder().color("red").name("haha").createAt(LocalDateTime.now()).build());
        ArrayList<Bottle> list = new ArrayList<>();
        bottle.setCreateAt(LocalDateTime.now());
        list.add(bottle);
        bottleService.saveAll(list);
        return "ok";
    }

}
