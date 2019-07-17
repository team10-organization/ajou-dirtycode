package ac.kr.ajou.stream;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {
    private String name;
    private String address;
    private int age;
}
