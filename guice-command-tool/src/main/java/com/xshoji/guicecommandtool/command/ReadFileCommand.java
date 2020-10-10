package com.xshoji.guicecommandtool.command;

import org.kohsuke.args4j.Option;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ReadFileCommand extends Command {

  /**
   * @link How to parse command line arguments in Java · Martin Thoma https://martin-thoma.com/how-to-parse-command-line-arguments-in-java/
   */
  @Option(name = "-input", usage = "Input file path", required = true)
  protected File input;

  @Option(name = "-output", usage = "Output file path", required = true)
  protected File output;

  @Override
  protected void doRun(String[] args) {


    this.systemOutPrintln();
    this.systemOutPrintln("[Info]");
    this.systemOutPrintln("  Input : " + this.input.getAbsolutePath());
    this.systemOutPrintln("  Output: " + this.output.getAbsolutePath());

    if (!this.input.exists()) {
      this.systemOutPrintln("[Error] Not found " + this.input.getName());
      System.exit(1);
    }

    if (this.output.exists()) {
      this.systemOutPrintln("[Warning] " + this.output.getName() + " is existed. Delete and Re-create this file.");
      this.output.delete();
    }

    PrintWriter output = null;
    try {
      this.output.createNewFile();
      output = new PrintWriter(this.output);
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(1);
    }

    // Java – Stream has already been operated upon or closed https://www.mkyong.com/java8/java-stream-has-already-been-operated-upon-or-closed/
    Supplier<Stream<String>> fileStreamSupplier = () -> {
      try {
        return Files.lines(Paths.get(this.input.getAbsolutePath()), Charset.forName("UTF-8"));
      } catch (IOException e) {
        e.printStackTrace();
        return null;
      }
    };

    this.systemOutPrintln("  Input and Output are existed!");
    this.systemOutPrintln();
    this.systemOutPrintln("[Line count in an input file]");
    //get new stream
    this.systemOutPrintln("  " + String.valueOf(fileStreamSupplier.get().count()));

    // 拡張for文(for-each文) - 繰り返し処理 - Java入門 https://www.javadrive.jp/start/for/index8.html
    //get another new stream
    fileStreamSupplier.get().forEach(output::println);
    output.close();
    this.systemOutPrintln("Contents in input file were written to the output file.");
    this.systemOutPrintln();

  }
}
