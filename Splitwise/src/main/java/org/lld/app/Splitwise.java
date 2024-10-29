package org.lld.app;

public class Splitwise {
    private static Splitwise splitwise = null;

    private Splitwise() {

    }

    public static synchronized Splitwise getInstance() {
        if (splitwise == null) {
            synchronized (Splitwise.class) {
                splitwise = new Splitwise();
            }
        }
        return splitwise;
    }
}
