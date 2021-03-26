package com.alphabeth.micronaut.requests;

import io.micronaut.core.order.Ordered;
import io.micronaut.http.HttpAttributes;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Filter;
import io.micronaut.http.filter.FilterChain;
import io.micronaut.http.filter.HttpFilter;
import io.micronaut.http.filter.ServerFilterPhase;
import io.micronaut.http.uri.UriMatchTemplate;
import io.micronaut.web.router.UriRoute;
import io.micronaut.web.router.UriRouteMatch;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;


@AllArgsConstructor
@Slf4j
@Filter(patterns = "/**")
public class RequestCountingFilter implements HttpFilter, Ordered {
    private final QueryCountHolder queryCountHolder;

    @Override
    public Publisher<? extends HttpResponse<?>> doFilter(
            HttpRequest<?> request, FilterChain chain
    ) {
        final String path = request
                .getAttributes()
                .get(HttpAttributes.ROUTE_MATCH.toString(), UriRouteMatch.class)
                .map(UriRouteMatch::getRoute)
                .map(UriRoute::getUriMatchTemplate)
                .map(UriMatchTemplate::toPathString)
                .orElse(request.getUri().toString());
        final Publisher<? extends HttpResponse<?>> proceed = chain.proceed(request);

        proceed.subscribe(new Subscriber<HttpResponse<?>>() {
            @Override
            public void onSubscribe(Subscription s) {
                s.request(1);
            }

            @Override
            public void onNext(HttpResponse<?> httpResponse) {
                log.info(
                        "Method {} path {} query count {}",
                        request.getMethodName(),
                        path,
                        queryCountHolder.getQueryCount().getTotal()

                );
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        });
        return proceed;

    }

    @Override
    public int getOrder() {
        return ServerFilterPhase.LAST.order();
    }
}
