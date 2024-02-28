package lsp.learn;

public class SingleInstance {
    private volatile static SingleInstance instance = null;
    private SingleInstance(){}

    public static SingleInstance getInstance() {
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
