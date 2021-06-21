package com.example.dao

import com.example.entiry.Customer
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.seasar.doma.internal.util.AssertionUtil.assertEquals
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.test.jdbc.JdbcTestUtils
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional
class CustomerControllerDaoTest @Autowired constructor(private val dao: CustomerDao, private val jdbcTemplate: JdbcTemplate) {

    @BeforeEach
    fun setup() {
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "customer")
        jdbcTemplate.execute("select setval('customer_id_seq',1)")
    }

    @Test
    fun testInsert() {
        val entity = Customer.create("foo", "bar");
        dao.insert(entity);

        val actual = dao.selectById(entity.id);
        with(actual) {
            assertEquals("foo", this?.firstName)
            assertEquals("bar", this?.lastName)
        }
    }
}