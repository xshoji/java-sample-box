package io.github.xshoji.guicecommandtool

import io.github.xshoji.guicecommandtool.CommandFactory
import io.github.xshoji.guicecommandtool.command.DbCrudCommand
import io.github.xshoji.guicecommandtool.command.DbSchemaCommand
import io.github.xshoji.guicecommandtool.command.LogCommand
import io.github.xshoji.guicecommandtool.command.NullCommand
import io.github.xshoji.guicecommandtool.command.CallWebApiCommand
import io.github.xshoji.guicecommandtool.command.ReadFileCommand
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
        Injector injector = Guice.createInjector(new io.github.xshoji.guicecommandtool.Injector() {})
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
