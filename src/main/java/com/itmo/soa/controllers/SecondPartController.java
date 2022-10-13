package com.itmo.soa.controllers;

import com.itmo.soa.models.DAO.RouteDAO;
import com.itmo.soa.models.Route;
import com.itmo.soa.services.NavigatorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @program: SOA-Lab2
 * @description: This controller is for the second service.
 * @author: Siyuan
 * @create: 2022-10-11 20:58
 **/

@AllArgsConstructor
@RestController
@RequestMapping(value = "/navigator/routes", produces = "application/xml")
public class SecondPartController {
    private final NavigatorService navigatorService;

    @GetMapping("/{id-from}/{id-to}/{shortest}")
    public Route findLongestOrShortestRoute(@PathVariable("id-from") int idFrom,
                          @PathVariable("id-to") int idTo,
                          @PathVariable boolean shortest) {
        RouteDAO targetRouteDAO;
        if (shortest) {
            targetRouteDAO = navigatorService.findShortestRoute(idFrom, idTo);
        } else {
            targetRouteDAO = navigatorService.findLongestRoute(idFrom, idTo);
        }

        return navigatorService.toRoute(targetRouteDAO);
    }

    @PostMapping("/{id-from}/{id-to}/{distance}")
    public Route addRoute(@PathVariable("id-from") int idFrom,
                          @PathVariable("id-to") int idTo,
                          @PathVariable int distance) {
        RouteDAO targetRouteDAO = navigatorService.addRouteBetweenLocations(idFrom, idTo, distance);

        return navigatorService.toRoute(targetRouteDAO);
    }
}
