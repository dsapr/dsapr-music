package com.dsapr.dsaprmusic.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * @author: chenyi.Wangwangwang
 * @date: 2022/2/10 16:29
 */
@MappedSuperclass
@Data
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(generator = "ksuid")
    @GenericGenerator(name="ksuid", strategy = "com.dsapr.dsaprmusic.utils.KsuidIdentifierGenerator")
    private String id;

    @CreationTimestamp
    private Date createdTime;

    @UpdateTimestamp
    private Date updatedTime;

}
