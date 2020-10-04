package io.github.xshoji.samplecode.bestpractice.testingtarget;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class EpochSecondFormatter {
  public String format(Instant instant) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    return "DATE: " + LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).format(formatter);
  }
}
