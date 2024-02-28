package lsp.learn;

public class MyInstance {
    private MyInstance() { }
    private static class InstanceHolder{
        public static MyInstance instance = new MyInstance();
    }
    public static MyInstance getInstance(){
        return InstanceHolder.instance;
    }

}
