package ac.kr.ajou.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApi {

    public List<String> filterString(List<String> stringList, String filterString) {
        return stringList.stream()
                .filter(string -> string.equals(filterString))
                .collect(Collectors.toList());
    }
}
