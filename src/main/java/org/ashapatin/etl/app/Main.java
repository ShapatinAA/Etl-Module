package org.ashapatin.etl.app;

import java.net.Socket;

public class Main {

  public static boolean isReachable(String host, int port) {
    try (Socket socket = new Socket(host, port)) {
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public static void main(String[] args) throws Exception {
    EtlApplication app = new EtlApplication(args);
    app.run();
  }
}
