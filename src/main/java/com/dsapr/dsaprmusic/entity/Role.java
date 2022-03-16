package com.dsapr.dsaprmusic.entity;

import lombok.Data;

import javax.persistence.Entity;

/**
 * @author: chenyi.Wangwangwang
 * @date: 2022/2/11 11:53
 */
@Entity
@Data
public class Role extends BaseEntity{

    private String name;

    private String title;

}
