package com.weather;

import com.eclipsesource.json.JsonObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class execute {

    public static void main(String[] args) throws IOException {
        runSaveToDatabase();
       // selectFrom("User01");
    }

    /**
     * This is the method which is saving data to database.
     * This method is using Hibernate Framework.
     */
    public static void runSaveToDatabase() {
        SessionFactory sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();

        Weather weather = new Weather();
        JsonObject getWeatger = weather.getWeather();


        //save example - without transaction
        Session session = sessionFactory.openSession();
        WeatherEntity weatherEntity = new WeatherEntity();
        weatherEntity = weather.fillFieldsForDB(getWeatger, weatherEntity);


        session.save(weatherEntity);

        System.out.println("*****");
        session.close();
    }

    /**
     * This is the method which is selecting data from database for particular user and saving data into weather entities.
     * This method is using Hibernate Framework.
     * @param login
     * @return weatherEntities
     */
    public List selectFrom(String login) throws IOException {


        SessionFactory sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        WeatherEntity weatherEntity = new WeatherEntity();

        Transaction tx = session.beginTransaction();
        String queryString = String.format("from com.weather.WeatherEntity where login LIKE '%s'", login);
        Query query = session.createQuery(queryString);
        List<WeatherEntity> weatherEntities = query.list();



            ObjectMapper mapper = new ObjectMapper();

            String path = String.format("user_reports/%s.json", login);
            mapper.writeValue(new File(path), weatherEntities);

            String jsonInString = mapper.writeValueAsString(weatherEntities);
            System.out.println("********");
        return weatherEntities;
    }
}