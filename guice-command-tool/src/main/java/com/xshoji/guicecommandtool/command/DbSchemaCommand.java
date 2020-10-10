package com.xshoji.guicecommandtool.command;

import com.google.inject.Inject;
import org.hibernate.boot.Metadata;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.kohsuke.args4j.Option;

import java.io.File;
import java.util.EnumSet;

public class DbSchemaCommand extends Command {

  @Inject
  protected Metadata metadata;

  @Option(name = "-output", usage = "Output file for schema sqls", required = true)
  protected String output;

  protected void doRun(String[] args) {

    // java - Perform native SQL Query during Spring startup - Stack Overflow https://stackoverflow.com/questions/40164943/perform-native-sql-query-during-spring-startup
    // ↑でファイルに出力したSQLを実行してスキーマを構成できるようにする


    // Generate Tables from Entity classes in Hibernate http://o7planning.org/en/11223/generate-tables-from-entity-classes-in-hibernate

    // Using Oracle Database.
    SchemaExport export = getSchemaExport();

    this.systemOutPrintln();
    this.systemOutPrintln("Drop Database...");
    // Drop Database
    dropDataBase(export, this.metadata);

    this.systemOutPrintln("Create Database...");
    // Create tables
    createDataBase(export, this.metadata);
    this.systemOutPrintln();

  }

  private SchemaExport getSchemaExport() {

    SchemaExport export = new SchemaExport();
    // Script file.
    File outputFile = new File(this.output);
    String outputFilePath = outputFile.getAbsolutePath();

    this.systemOutPrintln("Export file: " + outputFilePath);

    export.setDelimiter(";");
    export.setOutputFile(outputFilePath);

    // No Stop if Error
    export.setHaltOnError(false);
    //
    return export;
  }


  protected void dropDataBase(SchemaExport export, Metadata metadata) {
    // TargetType.DATABASE - Execute on Databse
    // TargetType.SCRIPT - Write Script file.
    // TargetType.STDOUT - Write log to Console.
    EnumSet<TargetType> targetTypes = EnumSet.of(TargetType.DATABASE, TargetType.SCRIPT, TargetType.STDOUT);

    export.drop(targetTypes, metadata);
  }

  public void createDataBase(SchemaExport export, Metadata metadata) {
    // TargetType.DATABASE - Execute on Databse
    // TargetType.SCRIPT - Write Script file.
    // TargetType.STDOUT - Write log to Console.

    EnumSet<TargetType> targetTypes = EnumSet.of(TargetType.DATABASE, TargetType.SCRIPT, TargetType.STDOUT);

    SchemaExport.Action action = SchemaExport.Action.CREATE;
    //
    export.execute(targetTypes, action, metadata);

    this.systemOutPrintln("Export OK");

  }
}
