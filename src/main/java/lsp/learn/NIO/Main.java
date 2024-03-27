package lsp.learn.NIO;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        Thread reactor = new Thread(new Reactor(8888));
        reactor.start();
    }
}
