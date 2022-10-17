package com.itmo.soa.services;

import com.itmo.soa.models.Coordinates;
import com.itmo.soa.models.DAO.CoordinatesDAO;
import com.itmo.soa.models.DAO.LocationDAO;
import com.itmo.soa.models.DAO.RouteDAO;
import com.itmo.soa.models.Location;
import com.itmo.soa.models.Route;

public interface NavigatorService {
    RouteDAO findShortestRoute(int fromId, int toId);
    RouteDAO findLongestRoute(int fromId, int toId);

    RouteDAO addRouteBetweenLocations(int fromId, int toId, Integer distance);

    Route toRoute(RouteDAO routeDAO);

    Location toLocation(LocationDAO locationDAO);

    Coordinates toCoordinates(CoordinatesDAO coordinatesDAO);

    RouteDAO getRouteById(int id);
}
