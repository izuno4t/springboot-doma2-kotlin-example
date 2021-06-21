package com.example.service

import com.example.dao.CustomerDao
import com.example.entiry.Customer
import com.example.entiry.Customer_
import org.seasar.doma.jdbc.Config
import org.seasar.doma.jdbc.criteria.KEntityql
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class CustomerService(private val config: Config, private val customerDao: CustomerDao) {

    fun findByPK(id: Long): Customer? {
        return customerDao.selectById(id)
    }

    fun findAll(): List<Customer> {
        // `Kotlin specific Criteria API` を使った検索処理
        val entityql = KEntityql(config)
        val e = Customer_()
        return entityql.from(e).orderBy { asc(e.id) }.fetch()

//        return customerDao.selectAll()

    }

    fun findByLastName(lastName: String): List<Customer> {
        return customerDao.selectByCondition(CustomerDao.Condition(null, null, lastName))
    }

    @Transactional
    fun insert(entity: Customer) {
        customerDao.insert(entity)
    }

    @Transactional
    fun update(entity: Customer) {
        customerDao.update(entity)
    }

    @Transactional
    fun delete(entity: Customer) {
        customerDao.delete(entity)
    }
}