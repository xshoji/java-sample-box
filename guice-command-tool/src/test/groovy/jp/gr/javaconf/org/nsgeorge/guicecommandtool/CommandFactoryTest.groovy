package jp.gr.javaconf.org.nsgeorge.guicecommandtool

import jp.gr.javaconf.org.nsgeorge.guicecommandtool.CommandFactory
import jp.gr.javaconf.org.nsgeorge.guicecommandtool.command.DbCrudCommand
import jp.gr.javaconf.org.nsgeorge.guicecommandtool.command.DbSchemaCommand
import jp.gr.javaconf.org.nsgeorge.guicecommandtool.command.LogCommand
import jp.gr.javaconf.org.nsgeorge.guicecommandtool.command.NullCommand
import jp.gr.javaconf.org.nsgeorge.guicecommandtool.command.CallWebApiCommand
import jp.gr.javaconf.org.nsgeorge.guicecommandtool.command.ReadFileCommand
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
        Injector injector = Guice.createInjector(new jp.gr.javaconf.org.nsgeorge.guicecommandtool.Injector() {})
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
