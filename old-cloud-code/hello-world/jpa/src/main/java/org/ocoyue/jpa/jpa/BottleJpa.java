package org.ocoyue.jpa.jpa;


import org.ocoyue.jpa.entity.Bottle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: Zoé
 * @date: 2019/9/18  上午9:52
 * @describe: TODO
 */
public interface BottleJpa extends JpaRepository<Bottle,Long> {

    List<Bottle> findAll();

    @Override
    <S extends Bottle> List<S> saveAll(Iterable<S> entities);
}
