package com.kcc.rich.config;



import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.spi.CachingProvider;
import java.net.URISyntaxException;

@Configuration
@EnableCaching
public class RestTimeCache {

//    @Bean
//    public CacheManager cacheManager() throws URISyntaxException {
//        // Ehcache XML 설정을 기반으로 CacheManager를 설정
//        CachingProvider provider = Caching.getCachingProvider();
//        javax.cache.CacheManager cacheManager = provider.getCacheManager(
//                getClass().getResource("/ehcache.xml").toURI(),
//                getClass().getClassLoader()
//        );
//        return cacheManager;
//    }


}
