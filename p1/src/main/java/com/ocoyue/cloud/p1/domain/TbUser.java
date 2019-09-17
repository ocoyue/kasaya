package com.ocoyue.cloud.p1.domain;

import javax.persistence.*;

@Table(name = "tb_user")
public class TbUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer uname;

    private Integer uage;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return uname
     */
    public Integer getUname() {
        return uname;
    }

    /**
     * @param uname
     */
    public void setUname(Integer uname) {
        this.uname = uname;
    }

    /**
     * @return uage
     */
    public Integer getUage() {
        return uage;
    }

    /**
     * @param uage
     */
    public void setUage(Integer uage) {
        this.uage = uage;
    }
}