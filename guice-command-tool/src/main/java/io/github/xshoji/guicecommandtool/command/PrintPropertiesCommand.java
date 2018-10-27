package io.github.xshoji.guicecommandtool.command;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 *
 */
public class PrintPropertiesCommand extends Command {

    @Inject
    @Named("app.env")
    protected String appEnv;

    @Inject
    @Named("logback.log.dir")
    protected String loggerDir;

    @Override
    protected void doRun(String[] args) {

        this.systemOutPrintln();
        this.systemOutPrintln("[Info]");
        this.systemOutPrintln("  appEnv : " + this.appEnv);
        this.systemOutPrintln("  loggerDir : " + this.loggerDir);
        this.systemOutPrintln();

    }
}
