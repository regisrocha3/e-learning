package labs.rr.io.filter.elearning;

import org.springframework.cloud.netflix.zuul.filters.post.LocationRewriteFilter;
import org.springframework.http.HttpStatus;

import com.netflix.zuul.context.RequestContext;

/**
 * 
 * @author regis.rocha
 *
 */
public class CustomLocationRewriteFilter extends LocationRewriteFilter {

	 @Override
	    public boolean shouldFilter() {
	        final RequestContext ctx = RequestContext.getCurrentContext();
	        int statusCode = ctx.getResponseStatusCode();
	        return HttpStatus.valueOf(statusCode).is3xxRedirection() || HttpStatus.valueOf(statusCode) == HttpStatus.CREATED;
	}
	
}
