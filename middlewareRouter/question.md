MiddlewareRouter

addRoute(route: string, result: string)
callRoute(route) -> result

========================================================
HashMap
    route -> result
    
->  put/get



/v1
    /users  -> GetUser()
    /users/profile -> GetUserProfile

    

    /foo/*/bar

    "/foo/*/bar"
    /foo/lkwjlkj/bar
    addRoute("/foo/*/bar", "whatever")

    callRoute("/foo/abc/bar") -> "whatever"


    /foo/abc/bar  -> whatever
    /foo/def/bar  -> whatever


    /foo/*/bar -> whatever
            

    
     /foo/abc/bar -> foo, abc, bar

    result
    map<String, ChildNode>


                root(/)

            /foo        /bar

        child1                child2
            
        /*      \abc
    child1         child3
    /bar            \ bar

    final (result)      final (result2)
    

    /foo
        /*
            /bar
    



