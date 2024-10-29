package org.example.routers;

import org.example.trie.TrieNode;

public class WIldCardmatcherRouter implements IRouter{

    TrieNode root;

    public WIldCardmatcherRouter() {
        root = new TrieNode();
    }


    @Override
    public void addRoute(String route, String callback) {
        String[] subPaths = route.split("/"); // TODO:: check for first element ""
        TrieNode cur = root;
        for (int i=0; i<subPaths.length;i++) {
            if (!cur.childNodes.containsKey(subPaths[i])) {
                TrieNode newNode = new TrieNode();
                cur.childNodes.put(subPaths[i], newNode);
            }
            cur = cur.childNodes.get(subPaths[i]);
        }
        cur.result = callback;
    }

    @Override
    public String callRoute(String route) throws IllegalArgumentException {
        String[] subPaths = route.split("/"); // TODO:: check for first element ""
        return callRouteHelper(subPaths, 0, root);
    }

    private String callRouteHelper(String[] subPaths, int idx, TrieNode cur) {
        if (cur == null) {
            return null;
        }
        if (idx == subPaths.length) {
            return cur.result;
        }

        String callback = callRouteHelper(subPaths, idx+1, cur.childNodes.get(subPaths[idx]));
        if (callback == null) {
            callback = callRouteHelper(subPaths, idx+1, cur.childNodes.get("*"));
        }
        return callback;
    }
}
