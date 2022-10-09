package com.itmo.soa.services.Impl;

import com.itmo.soa.models.DAO.RouteDAO;
import com.itmo.soa.models.mappers.RouteMapper;
import com.itmo.soa.services.navigatorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @program: SOA-Lab2
 * @author: Siyuan
 * @create: 2022-10-08 21:59
 **/

@Service
@AllArgsConstructor
public class navigatorServiceImpl implements navigatorService {
    private final RouteMapper routeMapper;

    @Override
    public RouteDAO findShortestRoute(long fromId, long toId) {
//        if(fromId <= 0 || toId <= 0) throw new ; TODO: 2022-10-08 Need to create some exceptions classes.
        return routeMapper.findShortestRoute(fromId, toId);
    }

    @Override
    public RouteDAO findLongestRoute(long fromId, long toId) {
        return routeMapper.findLongestRoute(fromId, toId);
    }
}
