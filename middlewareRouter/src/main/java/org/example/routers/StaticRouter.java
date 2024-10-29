package org.example.routers;

import java.util.HashMap;
import java.util.Map;

public class StaticRouter implements IRouter{
    Map<String, String> routerCallbackMap;

    public StaticRouter() {
        routerCallbackMap = new HashMap<>();
    }

    @Override
    public void addRoute(String route, String callback) {
        routerCallbackMap.put(route, callback);
    }

    @Override
    public String callRoute(String route) throws IllegalArgumentException {
        if (!routerCallbackMap.containsKey(route)) {
            throw new IllegalArgumentException("route does not exist");
        }

        return routerCallbackMap.get(route);
    }
}
