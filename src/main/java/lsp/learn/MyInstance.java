package lsp.learn;

public class MyInstance {
    private static class InstanceHolder {
        public static MyInstance instance = new MyInstance();
    }

    public static MyInstance getMyInstance() {
        return InstanceHolder.instance;
    }

}
