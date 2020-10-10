package com.xshoji.guicewebapicommandset.command;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.xshoji.guicewebapicommandset.AppInjector;
import com.xshoji.guicewebapicommandset.entity.Person;
import com.xshoji.guicewebapicommandset.repository.PersonRepositroy;
import com.xshoji.guicewebapicommandset.service.Calculator;
import com.xshoji.guicewebapicommandset.service.Caller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class HelloapiCommand {
  public static void main(String[] args) {
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
   * @param name
   */
  public static void call(String name) {
    Caller caller = new Caller();
    System.out.println(caller.getStringHello(name));
  }

  /**
   * @param x
   * @param y
   */
  public static void sum(Integer x, Integer y) {
    Calculator calculator = new Calculator();
    System.out.println(calculator.getStringFormula(x, y));
  }

  /**
   * @param id
   * @param name
   */
  public static void add(Integer id, String name) {
    Injector injector = Guice.createInjector(new AppInjector() {
    });

    PersonRepositroy rep = injector.getInstance(PersonRepositroy.class);
    rep.add(id, name);

    Person person = rep.findOne(id);
    System.out.println("id: " + person.getId() + " | name: " + person.getName());
  }

}
