import java.util.HashMap;
import java.util.Map;

public class Codec {
    private Map<Integer, String> map = new HashMap<>();
    private int id = 0;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        map.put(id, longUrl);
        return "http://tinyurl.com/" + id++;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int index = Integer.parseInt(shortUrl.replace("http://tinyurl.com/", ""));
        return map.get(index);
    }
}
