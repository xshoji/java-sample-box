package com.georgen.jcommand;

import com.georgen.jcommand.command.Command;
import com.georgen.jcommand.command.NullCommand;
import com.georgen.jcommand.dao.HibernateUtil;
import com.google.inject.Guice;
import org.kohsuke.args4j.CmdLineException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class App {

    protected static com.google.inject.Injector injector;

    public static void main(String[] args) throws CmdLineException {

        injector = Guice.createInjector(new Injector() {});

        String commandName = "NullCommand";
        if (args.length > 0) {
            commandName = args[0];
            // String配列から指定要素を削除する。 - 悪あがきプログラマー http://yoonchulkoh.hatenablog.com/entry/20091006/1254840771
            List<String> list = new ArrayList<String>(Arrays.asList(args));
            list.remove(0);
            args = list.toArray(new String[list.size()]);
        }


        CommandFactory factory = injector.getInstance(CommandFactory.class);
        Command command = factory.createCommand(commandName);

        if (command instanceof NullCommand) {
            System.out.println();
            System.out.println("Usage:");
            factory.getCommandNames().forEach(v -> System.out.println("  App.jar " + v + " -h"));
            System.out.println();
            System.exit(1);
        }

        command.run(args);


        HibernateUtil.closeSession();
    }
}
