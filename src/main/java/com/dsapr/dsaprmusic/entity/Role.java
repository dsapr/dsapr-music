package com.dsapr.dsaprmusic.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author: chenyi.Wangwangwang
 * @date: 2022/2/11 11:53
 */
@Entity
@Data
public class Role extends AbstractEntity{

    private String name;

    private String title;

}
