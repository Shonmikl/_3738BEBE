package _30_01_2023.testClasses.spy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class SpyWithoutSpyTest {

    @Mock
    List<String> list = new ArrayList<>();

    @Test
    void testMockReturnZero() {
        String s = "!!!";
        list.add(s);
        Mockito.verify(list).add(s);
        Assertions.assertEquals(0, list.size());
    }
}