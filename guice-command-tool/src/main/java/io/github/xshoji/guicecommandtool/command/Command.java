package io.github.xshoji.guicecommandtool.command;

import io.github.xshoji.guicecommandtool.Injector;
import io.github.xshoji.guicecommandtool.dto.Info;
import com.google.inject.Guice;
import com.google.inject.Inject;

import com.google.inject.name.Named;
import org.apache.commons.lang3.StringUtils;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

/**
 *
 */
abstract public class Command {

    protected com.google.inject.Injector injector;

    protected Info info;

    @Option(name="-h", aliases="--help", usage="print usage message and exit")
    protected boolean usageFlag;

    @Inject
    @Named("app.env")
    protected String env;

    /**
     *
     * @link Jarファイルのパスを取得する - hiiragi's ブログ http://hiiragi.hateblo.jp/entry/2012/11/12/192202
     * @link url - Java: Get URI from FilePath - Stack Overflow https://stackoverflow.com/questions/8323760/java-get-uri-from-filepath
     * @link network programming - Recommended way to get hostname in Java - Stack Overflow https://stackoverflow.com/questions/7348711/recommended-way-to-get-hostname-in-java
     * @link java - InetAddress.getLocalHost() slow to run (30+ seconds) - Stack Overflow https://stackoverflow.com/questions/33289695/inetaddress-getlocalhost-slow-to-run-30-seconds
     */
    public Command() {

        this.injector = Guice.createInjector(new Injector() {});

        String classFileName = "/" + this.getClass().getName().replaceAll("\\.", "/") + ".class";
        String classFilePath = this.getClass().getResource(classFileName).getPath();
        File jarFilePath = new File(classFilePath.replaceFirst("!/.*$", ""));
        String jarFilePathString = StringUtils.removeStart(jarFilePath.getPath(), "file:");

        String host;
        try {
            host = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            host = "Unknown host";

        }

        this.info = new Info(
            System.getProperty("user.name"),
            host,
            jarFilePathString,
            new Date()
        );
    }

    public boolean validateArgs(String[] args) {

        CmdLineParser parser = new CmdLineParser(this);

        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            this.systemOutPrintln(e.getMessage());
            this.systemOutPrintln(this.env);
            if (this.env.equals("dev")) {
                e.printStackTrace();
            }
            this.printUsage(parser);
            return false;
        }

        if (this.usageFlag) {
            this.printUsage(parser);
            return false;
        }

        return true;
    }

    public void printUsage(CmdLineParser parser) {
        this.systemOutPrintln();
        this.systemOutPrintln("Usage:");
        this.systemOutPrintln(" Shell [options]");
        this.systemOutPrintln(" Shell [options] script [arguments]");
        this.systemOutPrintln();
        this.systemOutPrintln("Options:");
        parser.printUsage(System.out);
        this.systemOutPrintln();
        this.after();
    }

    public void run(String[] args) {

        boolean isValid = this.validateArgs(args);

        if (isValid) {
            this.doRun(args);
        } else {
            // Do nothing.
        }
        this.after();
    }

    abstract protected void doRun(String[] args);

    /**
     * After action
     */
    protected void after() {}

    public void systemOutPrintln(String value) {
        System.out.println(value);
    }

    public void systemOutPrintln() {
        System.out.println("");
    }

    /**
     * Get info
     *
     * @return Info
     */
    public Info getInfo() {
        return this.info;
    }
}
