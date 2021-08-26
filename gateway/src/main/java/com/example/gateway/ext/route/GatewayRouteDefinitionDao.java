package com.example.gateway.ext.route;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: zhaofeng
 * @Date: 2021/8/24 13:42
 */

@Mapper
@TableName("gateway_route_definition")
public interface GatewayRouteDefinitionDao extends BaseMapper<GatewayRouteDefinition> {
}
