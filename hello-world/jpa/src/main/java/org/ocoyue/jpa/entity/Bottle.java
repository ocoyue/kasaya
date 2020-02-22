package org.ocoyue.jpa.entity;


import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author: Zoé
 * @date: 2019/9/18  上午9:42
 * @describe: TODO
 */
@Data
@Builder
@Entity
@Table(name="bottle")

public class Bottle {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false,length = 32)
    private String color;

    @Column(nullable = false, unique = true,length = 32)
    private String name;

    @Column(name = "create_at")
    // @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime createAt;


}
