package org.example.routers;

public interface IRouter {
    void addRoute(String route, String callback);
    String callRoute(String route);

}
