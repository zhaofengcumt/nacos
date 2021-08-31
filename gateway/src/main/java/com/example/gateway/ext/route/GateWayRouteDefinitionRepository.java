package com.example.gateway.ext.route;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhaofeng
 * @Date: 2021/8/24 13:39
 */
@Component
public class GateWayRouteDefinitionRepository implements RouteDefinitionRepository {



    private ApplicationEventPublisher publisher;


    private GatewayRouteDefinitionDao gatewayRouteDefinitionDao;

    private ObjectMapper objectMapper;

    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        return Flux.fromStream(gatewayRouteDefinitionDao.selectList(null).stream().map(this::convert));
    }

    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        return null;
    }

    @Override
    public Mono<Void> delete(Mono<String> routeId) {
        return null;
    }


    public RouteDefinition convert(GatewayRouteDefinition gatewayRouteDefinition) {
        RouteDefinition routeDefinition = new RouteDefinition();
        routeDefinition.setPredicates(jsonToList(gatewayRouteDefinition.getPredicates(), PredicateDefinition.class));
        routeDefinition.setFilters(jsonToList(gatewayRouteDefinition.getFilters(), FilterDefinition.class));
        routeDefinition.setUri(URI.create(gatewayRouteDefinition.getUri()));
        routeDefinition.setId(gatewayRouteDefinition.getName());
        routeDefinition.setOrder(gatewayRouteDefinition.getOrderId());
        return routeDefinition;
    }

    public <T> List<T> jsonToList(String json, Class<T> object) {
        try {
            CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, object);
            List<T>        list     = objectMapper.readValue(json, listType);
            return list;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void refresh() {
        this.publisher.publishEvent(new RefreshRoutesEvent(this));
    }

    @Autowired
    public void setPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Autowired
    public void setGatewayRouteDefinitionDao(GatewayRouteDefinitionDao gatewayRouteDefinitionDao) {
        this.gatewayRouteDefinitionDao = gatewayRouteDefinitionDao;
    }

    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
}
