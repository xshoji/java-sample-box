package com.georgen.jcommand;

import com.georgen.jcommand.command.*;
import com.google.inject.Inject;
import com.google.inject.Injector;
import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import org.slf4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class CommandFactory {

    protected HashMap<String, Command> commands = new HashMap<>();

    @Inject
    protected Logger logger;

    @Inject
    public void CommandFactory(Injector injector) {
        // 特定のアノテーションが付与されたクラスを実行時に抽出したい - 覚えたら書く http://blog.y-yuki.net/entry/2017/01/31/124000
        // 1. Usage · lukehutch/fast-classpath-scanner Wiki https://github.com/lukehutch/fast-classpath-scanner/wiki/1.-Usage
        List<String> commandClassNames = new FastClasspathScanner("com.georgen.jcommand.command")
                .scan()
                .getNamesOfSubclassesOf(Command.class);

        // java - Class literal from a class object based on an interface - Stack Overflow https://stackoverflow.com/questions/33818338/class-literal-from-a-class-object-based-on-an-interface
        // Java ファイル名から拡張子を取り除く ／ Chat&Messenger http://chat-messenger.net/blog-entry-39.html
        commandClassNames.forEach(commandClass -> {
            try {
                Integer point = commandClass.lastIndexOf(".");
                String commandClassName = commandClass.substring(point + 1);
                this.getCommands().put(commandClassName, (Command)injector.getInstance(Class.forName(commandClass)));
            } catch (ClassNotFoundException e) {
                this.logger.info(commandClass + " is not found.");
            } catch (Throwable th) {
                this.logger.info(commandClass + " cannot create.");
            }
        });
    }

    public Set<String> getCommandNames() {
        return this.getCommands().keySet();
    }

    /**
     *
     * @param name
     * @return
     */
    public Command createCommand(String name) {

        if(this.getCommands().containsKey(name)) {
            return this.getCommands().get(name);
        } else {
            return new NullCommand();
        }
    }


    protected HashMap<String, Command> getCommands() {
        return this.commands;
    }

}