package com.dsapr.dsaprmusic.utils;

import com.github.ksuid.KsuidGenerator;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

/**
 * @author: chenyi.Wangwangwang
 * @date: 2022/2/10 16:42
 */
public class KsuidIdentifierGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {

        return KsuidGenerator.generate();

    }
}
