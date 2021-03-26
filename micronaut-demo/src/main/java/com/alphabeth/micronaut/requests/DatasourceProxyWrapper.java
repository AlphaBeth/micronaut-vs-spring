package com.alphabeth.micronaut.requests;

import io.micronaut.context.event.BeanCreatedEvent;
import io.micronaut.context.event.BeanCreatedEventListener;
import io.micronaut.core.order.Ordered;
import lombok.AllArgsConstructor;
import net.ttddyy.dsproxy.listener.logging.SLF4JLogLevel;
import net.ttddyy.dsproxy.support.ProxyDataSource;
import net.ttddyy.dsproxy.support.ProxyDataSourceBuilder;

import javax.inject.Provider;
import javax.inject.Singleton;
import javax.sql.DataSource;

@Singleton
@AllArgsConstructor
public class DatasourceProxyWrapper implements BeanCreatedEventListener<DataSource>, Ordered {

    private final Provider<QueryCountHolder> holder;

    private ProxyDataSource getProxyDataSource(DataSource ds) {
        return ProxyDataSourceBuilder
                .create(ds)
                .countQuery(dataSourceName -> {
                    return holder.get().getQueryCount();
                })
                .logQueryBySlf4j(SLF4JLogLevel.DEBUG)
                .build();
    }

    @Override
    public DataSource onCreated(BeanCreatedEvent<DataSource> event) {
        return getProxyDataSource(event.getBean());
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE - 10;
    }
}
