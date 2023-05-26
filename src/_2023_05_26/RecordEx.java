package _2023_05_26;

import lombok.*;

//since java 14
public record RecordEx(String name, int age) {
}

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
final class Pavel {
    final String name;
    final int age;
}