package ua.com.shop.course_shop_np_371_372_2023.config;

import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.MemoryUnit;
import org.ehcache.jsr107.Eh107Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.com.shop.course_shop_np_371_372_2023.entity.Product;

import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.spi.CachingProvider;
import java.time.Duration;
@Configuration
public class AppConfiguration {

    @Bean
    public CacheManager EhcacheManager() {

        CacheConfiguration<String, Product> cacheConfig = CacheConfigurationBuilder
                .newCacheConfigurationBuilder(String.class,
                        Product.class,
                        ResourcePoolsBuilder.newResourcePoolsBuilder()
                                .offheap(10, MemoryUnit.MB)
                                .build())
                .withExpiry(ExpiryPolicyBuilder.timeToIdleExpiration(Duration.ofSeconds(10)))
                .build();

        CachingProvider cachingProvider = Caching.getCachingProvider();
        CacheManager cacheManager = cachingProvider.getCacheManager();

        var configuration = Eh107Configuration.fromEhcacheCacheConfiguration(cacheConfig);
        cacheManager.createCache("prod", configuration);
        return cacheManager;
    }
}
