package org.ashapatin.etl.load;

import java.util.List;
import javax.management.RuntimeErrorException;
import org.ashapatin.etl.load.exception.UnableToInsertInPostgresException;
import org.ashapatin.etl.model.WeatherAggregatedData;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;

public class LoadToPostgres implements Load<WeatherAggregatedData[]> {

  @Override
  public void load(WeatherAggregatedData[] data) throws UnableToInsertInPostgresException {
    Configuration configuration = createConfig();

//    Configuration configuration = new Configuration();
//    configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
//    configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://db:5432/postgres");
//    configuration.setProperty("hibernate.connection.username", "root");
//    configuration.setProperty("hibernate.connection.password", "mypassword");
//
//    configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
//    configuration.setProperty("hibernate.hbm2ddl.auto", "update");
//    configuration.setProperty("hibernate.show_sql", "true");
//    configuration.setProperty("hibernate.format_sql", "true");
//
//    configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());

// Register annotated class
//    configuration.addAnnotatedClass(WeatherAggregatedData.class);

    // JDBC and Hibernate settings for PostgreSQL Docker

    try (var sessionFactory = configuration.buildSessionFactory();
        var session = sessionFactory.openSession()) {
      Transaction transaction = session.beginTransaction();
      for (WeatherAggregatedData item : data) {
        WeatherAggregatedData existing = session.createQuery(
            "FROM WeatherAggregatedData WHERE sunsetIso = :sunsetIso", WeatherAggregatedData.class)
            .setParameter("sunsetIso", item.getSunsetIso())
            .uniqueResult();

        if (existing == null) {
          session.persist(item);
        }
      }
      transaction.commit();
    } catch (RuntimeErrorException e) {
      throw new UnableToInsertInPostgresException("Insertion in postgres db failed.", e.getCause());
    } catch (HibernateException e) {
      throw new UnableToInsertInPostgresException("Could not open the session.", e.getCause());
    }


  }

  private Configuration createConfig() {
    Configuration configuration = new Configuration();
    configuration.configure("hibernate.cfg.xml");
//    configuration.setProperty("connection.username", System.getenv("POSTGRES_USER"));
//    configuration.setProperty("connection.password", System.getenv("POSTGRES_PASSWORD"));
    return configuration;
  }
}
