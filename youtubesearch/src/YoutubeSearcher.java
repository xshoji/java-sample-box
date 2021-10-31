import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class YoutubeSearcher {
  /**
   * YouTubeのこのチャンネルの、タイトルに｢○○｣っていう単語が含まれてる動画を、再生回数が多い順に並べる
   *
   * @param args
   */
  public static void main(String[] args) throws Exception {
    String channelUrl = "https://www.youtube.com/channel/UC6pyjcvkrwbQJaC8cj8kxFQ/videos";
    String html = getHTML(channelUrl);
    List<String> videoInfoList = extractVideoInfo(html);
    System.out.println(videoInfoList);
  }

  /**
   * Gets HTML Content as String
   * 
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
}
