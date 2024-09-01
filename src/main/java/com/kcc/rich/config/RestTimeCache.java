//package com.kcc.rich.config;
//
//import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.cache.configuration.MutableConfiguration;
//import javax.cache.expiry.CreatedExpiryPolicy;
//import javax.cache.expiry.Duration;
//
//import static java.util.concurrent.TimeUnit.HOURS;
//import static java.util.concurrent.TimeUnit.MINUTES;
//
//@Configuration
//@EnableCaching
//public class RestTimeCache {
//
//    @Bean
//    public JCacheManagerCustomizer cacheManagerCustomizer() {
//        return cacheManager -> {
//            MutableConfiguration<Object, Object> configuration = new MutableConfiguration<>()
//                    .setExpiryPolicyFactory(CreatedExpiryPolicy.factoryOf(new Duration(HOURS, 24)))
//                    .setStoreByValue(false)
//                    .setStatisticsEnabled(true);
//
//            cacheManager.createCache("restaurantCache", configuration);
//        };
//    }
//
//}
