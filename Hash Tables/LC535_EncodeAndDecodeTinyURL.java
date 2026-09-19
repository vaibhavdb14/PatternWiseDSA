import java.util.HashMap;

public class LC535_EncodeAndDecodeTinyURL {

    HashMap<String, String> tinytolong = new HashMap<>();
    HashMap<String, String> longtotiny = new HashMap<>();
    int counter = 0;
    String urlstring = "https://tinyurl.com/";

    public String encode(String longUrl) {

        if(!longtotiny.containsKey(longUrl)){
            longtotiny.put(longUrl, urlstring + (++counter));
            tinytolong.put(urlstring + counter, longUrl);
        }

        return longtotiny.get(longUrl);
    }

    public String decode(String shortUrl) {
        return tinytolong.get(shortUrl);
    }

    public static void main(String[] args) {
        LC535_EncodeAndDecodeTinyURL codec = new LC535_EncodeAndDecodeTinyURL();
        String url = "https://leetcode.com/problems/encode-and-decode-tinyurl";
        String encodedUrl = codec.encode(url);
        System.out.println("Encoded URL: " + encodedUrl);
        String decodedUrl = codec.decode(encodedUrl);
        System.out.println("Decoded URL: " + decodedUrl);
    }
}

/**
 * 
 * leetcode 535. Encode and Decode TinyURL
 * link: https://leetcode.com/problems/encode-and-decode-tinyurl/
 * 
 * Time Complexity: O(1) for both encode and decode operations, as we are using HashMaps for constant time lookups.
 * Space Complexity: O(n), where n is the number of unique URLs encoded, as we are storing mappings in two HashMaps.
 * 
 * Approach1: (Using two HashMaps)
 * 1. We maintain two HashMaps: one for mapping long URLs to their corresponding short URLs (longtotiny) and another for mapping short URLs back to their original long URLs (tinytolong).
 * 2. We use a counter to generate unique short URLs by appending the counter value to a base URL (https://tinyurl.com/).
 * 
 * Approach2: (Using one HashMap)
 * 1. We can also use a single HashMap to store the mapping from short URLs to long URLs.
 *   - When encoding, we generate a unique short URL and store the mapping in the HashMap.
 *  - When decoding, we simply look up the short URL in the HashMap to retrieve the original long URL.
 * 
 * difference between two approaches:
 * - The first approach uses two HashMaps to maintain a bidirectional mapping between long and short URLs, allowing for quick lookups in both directions. 
 * - The second approach uses a single HashMap, which simplifies the implementation but may require additional logic to ensure unique short URL generation.
 * 
 */