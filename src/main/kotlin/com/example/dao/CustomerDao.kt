package com.example.dao

import com.example.entiry.Customer
import org.seasar.doma.*
import org.seasar.doma.boot.ConfigAutowireable


@ConfigAutowireable
@Dao
interface CustomerDao {

    data class Condition(val id: Long? = null, val firstName: String? = null, val lastName: String? = null)

    // `@org.seasar.doma.Sql` アノテーションでのテンプレート記述を使った検索処理
    @Sql("""
    SELECT * FROM foo WHERE id = /* id */1
    """)
    @Select
    fun selectById(id: Long): Customer?

    @Select
    fun selectByCondition(condition: Condition): List<Customer>

    @Insert
    fun insert(customer: Customer): Int

    @Update
    fun update(customer: Customer): Int

    @Delete
    fun delete(customer: Customer): Int

}