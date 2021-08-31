package com.example.gateway.ext.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhaofeng
 * @Date: 2021/8/27 13:16
 */
@RestController
@RequestMapping("/admin/route")
public class GateWayRouteDefinitionController {

    GateWayRouteDefinitionRepository gateWayRouteDefinitionRepository;

    @RequestMapping("/refresh")
    public void refresh() {
        gateWayRouteDefinitionRepository.refresh();
    }

    @Autowired
    public void setGateWayRouteDefinitionRepository(GateWayRouteDefinitionRepository gateWayRouteDefinitionRepository) {
        this.gateWayRouteDefinitionRepository = gateWayRouteDefinitionRepository;
    }
}
