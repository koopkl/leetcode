package lsp.learn;

public class SingleInstance {
    private volatile static SingleInstance instance;
    public static SingleInstance getSingle() {
        if (instance == null) {
            synchronized (SingleInstance.class) {
                if (instance == null) {
                    instance = new SingleInstance();
                }
            }
        }
        return instance;
    }
}
