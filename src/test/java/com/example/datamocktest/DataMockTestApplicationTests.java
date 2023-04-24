package com.example.datamocktest;

import static org.junit.Assert.assertTrue;

import javax.sql.DataSource;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {pService.class})
@Import({
	JdbcConfiguration.class
})
class DataMockTestApplicationTests {

	@MockBean
	private DataSource dataSource;

	@Test
	void contextLoads() {
		assertTrue(true);
	}

}
