package labs.rr.io.elearning.config;

import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import labs.rr.io.filter.elearning.CustomLocationRewriteFilter;

/**
 * 
 * @author regis.rocha
 *
 */
@Configuration
@EnableZuulProxy
public class ZuulProxyConfiguration {
	
	@Bean
    public CustomLocationRewriteFilter locationRewriteFilter() {
        return new CustomLocationRewriteFilter();
	}

}
