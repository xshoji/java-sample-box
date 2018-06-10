package com.georgen.jcommand.command;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.kohsuke.args4j.Option;
import org.slf4j.Logger;

/**
 *
 */
public class LogCommand extends Command {

    @Inject
    protected Logger logger;

    @Inject
    @Named("logback.log.dir")
    protected String loggerDir;

    /**
     * @link How to parse command line arguments in Java · Martin Thoma https://martin-thoma.com/how-to-parse-command-line-arguments-in-java/
     */
    @Option(name="-string",usage="Logging string",required=true)
    protected String string;

    @Override
    protected void doRun(String[] args) {

        this.systemOutPrintln();
        this.systemOutPrintln("[Info]");
        this.systemOutPrintln("  See log dir: " + this.loggerDir);
        this.systemOutPrintln();

        this.logger.info("StartTime: " + this.getInfo().getTimeStartStr());
        this.logger.info("     user: " + this.getInfo().getUser());
        this.logger.info("     host: " + this.getInfo().getHost());
        this.logger.info("     path: " + this.getInfo().getPath());

    }
}
