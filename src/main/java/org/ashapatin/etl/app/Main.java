package org.ashapatin.etl.app;


/**
 * <p>Старт Etl-модуля. Стурктуру пытался сделать удобной под расширение и поддержку функционала.
 * Само приложение состоит из 3х основых частей - extract, transform,load.<p/>
 * <p>Extract - достёт либо из api, делая один запрос, либо из файла json и сразу же мапит в
 * pojo.<p/>
 * <p>Transform - преобразует pojo в другой pojo согласно заданию. На выходе получается массив из
 * объектов, олицетворяющих средние значения/конвертированные значения показателей погоды по дням
 * указанным в интервале.</p>
 * <p>Load - загружает либо в файл csv, полученный из transform pojo; либо в базу данных
 * PostgreSQL используя Hibernate.</p>
 * <p>Тесты и часть документации кода дописать не успел :/</p>
 */



public class Main {
  public static void main(String[] args) throws Exception {
    EtlApplication app = new EtlApplication(args);
    app.run();
  }
}
