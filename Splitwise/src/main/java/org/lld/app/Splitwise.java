package org.lld.app;

public class Splitwise {
    private static Splitwise splitwise = null;

    public synchronized Splitwise getInstance() {
        if (splitwise == null) {
            splitwise = new Splitwise();
        }
        return splitwise;
    }
}
