package com.zeng.aop;

import com.google.inject.Inject;
import org.springframework.cache.annotation.Cacheable;

public class Test {

    @Cacheable(cacheName="infoCache", keyGeneratorName="infoKeyGenerator")
    Info getInfo(Long id) throws Exception;

    @TriggersRemove(cacheName="infoCache", keyGeneratorName="infoKeyGenerator")
    void updateCustomer(Long id, Info info) throws Exception;


}
