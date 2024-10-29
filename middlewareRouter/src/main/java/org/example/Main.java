package org.example;

import org.example.routers.IRouter;
import org.example.routers.StaticRouter;
import org.example.routers.WIldCardmatcherRouter;

public class Main {
    public static void main(String[] args) {
        IRouter router = new StaticRouter();
        router.addRoute("/users", "GetUser");

        router.addRoute("/users/profile", "GetUserProfile");

//        System.out.println(router.callRoute("/users"));
//
//        System.out.println(router.callRoute("/users/profile"));
//        System.out.println(router.callRoute("/users/otp"));


//        GetUserById -> userId1

        // /foo/{id}/address, id
        // callRoute("/foo/blah") -> result, list<string>

        router = new WIldCardmatcherRouter();
        router.addRoute("/foo/*/bar", "foo*bar");
        router.addRoute("/foo/bar", "foo-bar");
        router.addRoute("/foo", "foo");
        System.out.println(router.callRoute("/foo/*/bar"));
        System.out.println(router.callRoute("/foo/abc/bar"));
        System.out.println(router.callRoute("/foo/def/bar"));
        System.out.println(router.callRoute("/foo/bar"));
        System.out.println(router.callRoute("/foo"));
        System.out.println(router.callRoute("/*"));

    }
}