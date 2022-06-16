package com.samsclub.spirebatch.testapp;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = KafkaTestApplication.class)
public class KafkaTestApplicationTest {

    @Mock
    KafkaTestApplication app;
    @Test
    public void test() {
        String args[] = {};
        app.main(args);
    }
}
