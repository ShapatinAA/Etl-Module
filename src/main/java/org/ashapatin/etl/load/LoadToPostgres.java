package org.ashapatin.etl.load;

import javax.management.RuntimeErrorException;
import org.ashapatin.etl.load.exception.UnableToInsertInPostgresException;
import org.ashapatin.etl.model.WeatherAggregatedData;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LoadToPostgres implements Load<WeatherAggregatedData[]> {

  @Override
  public void load(WeatherAggregatedData[] data) throws UnableToInsertInPostgresException {
    Configuration configuration = createConfig();

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
    } catch (RuntimeErrorException | HibernateException e) {
      throw new UnableToInsertInPostgresException(e.getMessage(), e.getCause());
    }


  }

  private Configuration createConfig() {
    Configuration configuration = new Configuration();
    configuration.configure("hibernate.cfg.xml");
    return configuration;
  }
}
