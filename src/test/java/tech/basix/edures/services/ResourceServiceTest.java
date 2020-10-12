package tech.basix.edures.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class ResourceServiceTest {
    @Autowired ResourceService resourceService;

    @Test
    void postResource() {

    }

    @Test
    void like() {
    }

    @Test
    void getPage() {
    }
}