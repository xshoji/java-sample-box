package com.georgen.jcommand.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
public class Info {

    /**
     * @see 【Java】定数クラスをどうしたものかと改めて考える - Javaプログラマのはしくれダイアリー http://yyyank.blogspot.jp/2016/09/java.html
     */
    public static final String DATEFORMAT = "YYYY-MM-dd HH:mm:ss";

    protected String user;

    protected String host;

    protected String path;

    protected Date timeStart;

    /**
     *
     * @param user
     * @param host
     * @param path
     * @param timeStart
     */
    public Info(String user, String host, String path, Date timeStart) {
        this.user = user;
        this.host = host;
        this.path = path;
        this.timeStart = timeStart;
    }

    /**
     * Get user
     *
     * @return String
     */
    public String getUser() {
        return this.user;
    }

    /**
     * Get host
     *
     * @return String
     */
    public String getHost() {
        return this.host;
    }

    /**
     * Get path
     *
     * @return String
     */
    public String getPath() {
        return this.path;
    }

    /**
     * Get timeStart
     *
     * @return Date
     */
    public Date getTimeStart() {
        return this.timeStart;
    }

    /**
     * Get timeStart
     *
     * @link Java：Date型⇒String型への変換方法 | 覚え書き.com http://write-remember.com/program/java/parsedatetostring/
     * @link SimpleDateFormat (Java Platform SE 8 ) https://docs.oracle.com/javase/jp/8/docs/api/java/text/SimpleDateFormat.html
     * @return String
     */
    public String getTimeStartStr() {
        return (new SimpleDateFormat(Info.DATEFORMAT)).format(this.getTimeStart());
    }

    public String getTimeCurrentStr() {
        return (new SimpleDateFormat(Info.DATEFORMAT)).format(new Date());
    }

    /**
     *
     * @link テックノート – Javaで2つの時間(Date)の差分秒を取得する方法 http://javatechnology.net/java/date-diff-seconds/
     * @return
     */
    public Long getTimeDurationSec() {
        return ((new Date()).getTime() - this.getTimeStart().getTime()) / 1000;
    }
}
