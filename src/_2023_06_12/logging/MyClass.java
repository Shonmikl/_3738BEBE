package _2023_06_12.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyClass {
  private static final Logger logger
          = LogManager.getLogger(MyClass.class);

  public static void main(String[] args) {
    //System.setProperty("log4j.configurationFile", "E:\\_3738BEBE\\src\\_2023_06_12\\logging\\log4j2.xml");
    //System.setProperty("log4j.configurationFile", "E:\\_3738BEBE\\src\\main\\resources\\log4j2.yaml");

    logger.info("Это информационное сообщение YAML.");
    logger.warn("Это предупреждение YAML.");
    logger.error("Это сообщение об ошибке YAML.");
  }
}