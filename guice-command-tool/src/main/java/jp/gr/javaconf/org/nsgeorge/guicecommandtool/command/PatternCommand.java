package jp.gr.javaconf.org.nsgeorge.guicecommandtool.command;

import org.kohsuke.args4j.Option;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternCommand extends Command {

    @Option(name="-pattern",usage="Sets a pattern string",required=true)
    public String patternString;

    @Option(name="-target",usage="Sets a target string",required=true)
    public String targetString;


    /**
     * @link Jackson使い方メモ - Qiita http://qiita.com/opengl-8080/items/b613b9b3bc5d796c840c
     * @link java - NoClassDefFoundError of com/fasterxml/jackson/databind/ObjectMapper with Maven https://stackoverflow.com/questions/43826718/noclassdeffounderror-of-com-fasterxml-jackson-databind-objectmapper-with-maven
     * @param args
     */
    protected void doRun(String[] args) {

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(targetString);

        this.systemOutPrintln("<< Info >>");
        this.systemOutPrintln("patternString:" + patternString);
        this.systemOutPrintln("targetString:" + targetString);
        this.systemOutPrintln("");
        this.systemOutPrintln("<< Pattern and Matcher >>");
        this.systemOutPrintln("[ find 1 ]");
        this.systemOutPrintln(String.valueOf(matcher.find()));
        this.systemOutPrintln("[ find 2 ]");
        this.systemOutPrintln(String.valueOf(matcher.find()));
        this.systemOutPrintln("[ find 3 ]");
        this.systemOutPrintln(String.valueOf(matcher.find()));
        this.systemOutPrintln("[ macthes ]");
        this.systemOutPrintln(String.valueOf(matcher.matches()));
        this.systemOutPrintln("");

        this.systemOutPrintln("<< targetString.matches() >>");
        this.systemOutPrintln(String.valueOf(targetString.matches(patternString)));
        this.systemOutPrintln("");

        this.systemOutPrintln("<< Pattern.matches() >>");
        this.systemOutPrintln(String.valueOf(Pattern.matches(patternString, targetString)));
        this.systemOutPrintln("");
    }
}