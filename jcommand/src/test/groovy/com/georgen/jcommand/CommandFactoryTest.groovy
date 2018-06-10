package com.georgen.jcommand

import com.georgen.jcommand.command.DbCrudCommand
import com.georgen.jcommand.command.DbSchemaCommand
import com.georgen.jcommand.command.LogCommand
import com.georgen.jcommand.command.NullCommand
import com.georgen.jcommand.command.CallWebApiCommand
import com.georgen.jcommand.command.ReadFileCommand
import com.google.inject.Guice
import com.google.inject.Injector
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Unit test for simple App.
 */
class CommandFactoryTest extends Specification
{
    @Unroll
    def "Command Factory#createCommand"() {
        // spock-workshop/docs at master · yamkazu/spock-workshop https://github.com/yamkazu/spock-workshop/tree/master/docs
        setup:
        Injector injector = Guice.createInjector(new com.georgen.jcommand.Injector() {})
        CommandFactory factory = injector.getInstance(CommandFactory.class)

        expect:
        assert factory.createCommand(name).getClass() == command

        where:
        name                 | command
        "ReadFileCommand"    | ReadFileCommand.class
        "CallWebApiCommand"  | CallWebApiCommand.class
        "LogCommand"         | LogCommand.class
        // "DbCrudCommand"      | DbCrudCommand.class
        // "DbSchemaCommand"    | DbSchemaCommand.class
        "DammyCommand"       | NullCommand.class

    }

}
