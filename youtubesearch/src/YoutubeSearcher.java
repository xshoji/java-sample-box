import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class YoutubeSearcher {
  /**
   * YouTubeのこのチャンネルの、タイトルに｢○○｣っていう単語が含まれてる動画を、再生回数が多い順に並べる
   *
   * @param args
   */
  public static void main(String[] args) throws Exception {
    // 検索対象の文字列を定義
    String videoNamePart = "種明かし";
    // Youtubeの動画一覧ページのURLを設定する
    String channelUrl = "https://www.youtube.com/channel/UC6pyjcvkrwbQJaC8cj8kxFQ/videos";
    // HTMLを取得する
    String html = getHTML(channelUrl);
    // HTMLから動画の情報を取得する
    List<String> videoInfoList = extractVideoInfo(html);
    // 動画の情報を再生回数でソートする
    Map<Double, String> playCountVideoInfoMap = toSortedPlayCountVideoInfoMap(videoInfoList);
    // 特定の文字列が含まれる動画にフィルタリングする
    List<String> filteredVideoInfoList = playCountVideoInfoMap //
            .entrySet() //
            .stream() //
            .filter(e -> e.getValue().contains(videoNamePart)) //
            .map(Map.Entry::getValue) //
            .collect(Collectors.toList());
    // 動画のタイトルとURLのMapに変換する
    Map<String, String> videoTitleAndUrlList = toVideoTitleAndUrlMap(filteredVideoInfoList);
    // 標準出力する
    videoTitleAndUrlList.entrySet().forEach(System.out::println);
  }

  /**
   * Gets HTML Content as String
   * <p>
   * How do I do a HTTP GET in Java? - Stack Overflow
   * https://stackoverflow.com/questions/1485708/how-do-i-do-a-http-get-in-java
   *
   * @param urlToRead
   * @return
   * @throws Exception
   */
  public static String getHTML(String urlToRead) throws Exception {
    StringBuilder result = new StringBuilder();
    URL url = new URL(urlToRead);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("GET");
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
      for (String line; (line = reader.readLine()) != null; ) {
        result.append(line);
      }
    }
    return result.toString();
  }

  /**
   * Extracts video information from json in HTML.
   *
   * @param html
   * @return
   */
  public static List<String> extractVideoInfo(String html) {
//    String exp = "\"title\":\\{\"runs\":\\[\\{\"text\":\".*?\"}],";
    String exp = "\"title\":\\{\"runs\":\\[\\{\"text\":\".*?videoId";
    Pattern pattern = Pattern.compile(exp);
    Matcher matcher = pattern.matcher(html);
    List stringList = new ArrayList();
    while (matcher.find()) {
      stringList.add(matcher.group());
    }
    return stringList;
  }

  /**
   * Converts to Map of play count and video information.
   *
   * @param videoInfoList
   * @return
   */
  public static Map<Double, String> toSortedPlayCountVideoInfoMap(List<String> videoInfoList) {
    String exp = "秒 .*? 回視聴";
    Pattern pattern = Pattern.compile(exp);
    // 降順でソートされたMapを定義
    // TreeMapのメモ: http://dabiyone.webcrow.jp/java/jv00004a.html  
    Map<Double, String> playCountVideoInfoMap = new TreeMap<>(Collections.reverseOrder());
    for (String videoInfo : videoInfoList) {
      // ... powered by MAGICA 6 か月前 3 分 45 秒 7,081 回視聴"}}},"publish ... 
      // ↓
      // 秒 7,081 回視聴
      Matcher matcher = pattern.matcher(videoInfo);
      String playCountString = "0";
      if (matcher.find()) {
        // 秒 10,773 回視聴
        // → 10,773 回視聴
        // → 10773 回視聴
        // → 10773
        playCountString = matcher.group().replace("秒 ", "").replace(",", "").replace(" 回視聴", "");
      }
      playCountVideoInfoMap.put(Double.valueOf(playCountString), videoInfo);
    }

    return playCountVideoInfoMap;
  }

  /**
   * Converts to Map of play count and video information.
   *
   * @param videoInfoList
   * @return
   */
  public static Map<String, String> toVideoTitleAndUrlMap(List<String> videoInfoList) {

    // 動画タイトル用
    String expVideoTitle = "\"title\":\\{\"runs\":\\[\\{\"text\":\".*?\"}],\"accessibility";
    Pattern patternVideoTitle = Pattern.compile(expVideoTitle);

    // 動画URL用
    String expVideoUrl = "\"webCommandMetadata\":\\{\"url\":\".*?\",\"webPageType";
    Pattern patternVideoUrl = Pattern.compile(expVideoUrl);
    Map<String, String> videoTitleAndUrlMap = new HashMap<>();
    for (String videoInfo : videoInfoList) {
      Matcher matcherVideoTitle = patternVideoTitle.matcher(videoInfo);
      Matcher matcherVideoUrl = patternVideoUrl.matcher(videoInfo);
      String videoTitle = null;
      String videoUrl = null;
      if (matcherVideoTitle.find()) {
        // 秒 10,773 回視聴
        // → 10,773 回視聴
        // → 10773 回視聴
        // → 10773
        videoTitle = matcherVideoTitle.group().replace("\"title\":{\"runs\":[{\"text\":\"", "").replace("\"}],\"accessibility", "");
      }      
      if (matcherVideoUrl.find()) {
        // 秒 10,773 回視聴
        // → 10,773 回視聴
        // → 10773 回視聴
        // → 10773
        videoUrl = "https://www.youtube.com" + matcherVideoUrl.group().replace("\"webCommandMetadata\":{\"url\":\"", "").replace("\",\"webPageType", "");
      }
      videoTitleAndUrlMap.put(videoTitle, videoUrl);
    }
    return videoTitleAndUrlMap;
  }
}
