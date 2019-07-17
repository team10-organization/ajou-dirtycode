package ac.kr.ajou.steam;

import ac.kr.ajou.stream.StreamApi;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class StreamApiTest {

    @Test
    public void filterString_제대로_필터된_스트링을_반환() {
        StreamApi streamApi = new StreamApi();
        List<String> testStringList = new ArrayList<>();
        testStringList.add("a");
        testStringList.add("b");
        testStringList.add("b");
        testStringList.add("c");
        testStringList.add("c");

        List<String> result = streamApi.filterString(testStringList, "c");
        assertTrue(result.size() == 2);
        assertTrue(result.get(0).equals("c"));
        assertTrue(result.get(1).equals("c"));

    }
}
