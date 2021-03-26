package com.alphabeth.micronaut.requests;

import io.micronaut.runtime.http.scope.RequestScope;
import lombok.Getter;
import net.ttddyy.dsproxy.QueryCount;

@RequestScope
@Getter
public class RequestQueryCountHolder implements QueryCountHolder {
    private final QueryCount queryCount = new QueryCount();
}
