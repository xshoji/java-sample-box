package com.georgen.helloapi.command;

import com.georgen.helloapi.AppInjector;
import com.georgen.helloapi.entity.Person;
import com.georgen.helloapi.repository.PersonRepositroy;
import com.georgen.helloapi.service.Calculator;
import com.georgen.helloapi.service.Caller;
import com.georgen.helloapi.service.MyBatisManager;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provides;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class HelloapiCommand
{
    public static void main(String[] args)
    {
        Logger logger = LoggerFactory.getLogger("HelloapiCommand");
        String mode = args[1];

        logger.info("mode : " + mode);
        logger.info("args count : " + args.length);

        if (mode.equals("call")) {
            HelloapiCommand.call(args[2]);
        } else if (mode.equals("sum")) {
            HelloapiCommand.sum(Integer.valueOf(args[2]), Integer.valueOf(args[3]));
        } else if (mode.equals("add")) {
            HelloapiCommand.add(Integer.valueOf(args[2]), String.valueOf(args[3]));
        } else {
            System.out.println("Undefined command mode: " + mode);
        }
    }

    /**
     *
     * @param name
     */
    public static void call(String name)
    {
        Caller caller = new Caller();
        System.out.println(caller.getStringHello(name));
    }

    /**
     *
     * @param x
     * @param y
     */
    public static void sum(Integer x, Integer y)
    {
        Calculator calculator = new Calculator();
        System.out.println(calculator.getStringFormula(x, y));
    }

    /**
     *
     * @param id
     * @param name
     */
    public static void add(Integer id, String name)
    {
        Injector injector = Guice.createInjector(new AppInjector() {});

        PersonRepositroy rep = injector.getInstance(PersonRepositroy.class);
        rep.add(id, name);

        Person person = rep.findOne(id);
        System.out.println("id: " + person.getId() + " | name: " + person.getName());
    }

}
