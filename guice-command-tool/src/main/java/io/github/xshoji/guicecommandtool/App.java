package io.github.xshoji.guicecommandtool;

import io.github.xshoji.guicecommandtool.command.Command;
import io.github.xshoji.guicecommandtool.command.NullCommand;
import io.github.xshoji.guicecommandtool.dao.HibernateUtil;
import com.google.inject.Guice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class App {

    protected static com.google.inject.Injector injector;

    public static void main(String[] args) {

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
