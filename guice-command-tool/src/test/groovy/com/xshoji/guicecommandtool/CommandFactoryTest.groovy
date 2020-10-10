package com.xshoji.guicecommandtool

import com.google.inject.Guice
import com.google.inject.Injector
import com.xshoji.guicecommandtool.command.CallWebApiCommand
import com.xshoji.guicecommandtool.command.LogCommand
import com.xshoji.guicecommandtool.command.NullCommand
import com.xshoji.guicecommandtool.command.ReadFileCommand
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Unit test for simple App.
 */
class CommandFactoryTest extends Specification {
  @Unroll
  def "Command Factory#createCommand"() {
    // spock-workshop/docs at master · yamkazu/spock-workshop https://github.com/yamkazu/spock-workshop/tree/master/docs
    setup:
    Injector injector = Guice.createInjector(new com.xshoji.guicecommandtool.Injector() {})
    CommandFactory factory = injector.getInstance(CommandFactory.class)

    when:
    def actualCommandClass = factory.createCommand(name).getClass()
    
    then:
    assert actualCommandClass == expectedCommandClass

    where:
    name                | expectedCommandClass
    "ReadFileCommand"   | ReadFileCommand.class
    "CallWebApiCommand" | CallWebApiCommand.class
    "LogCommand"        | LogCommand.class
    // "DbCrudCommand"      | DbCrudCommand.class
    // "DbSchemaCommand"    | DbSchemaCommand.class
    "DammyCommand"      | NullCommand.class

  }

}
