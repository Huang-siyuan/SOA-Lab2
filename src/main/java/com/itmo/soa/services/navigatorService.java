package com.itmo.soa.services;

import com.itmo.soa.models.DAO.RouteDAO;
import com.itmo.soa.models.Route;

public interface navigatorService {
    RouteDAO findShortestRoute(long fromId, long toId);
    RouteDAO findLongestRoute(long fromId, long toId);
}
