package com.example.entiry

import org.seasar.doma.jdbc.entity.EntityListener
import org.seasar.doma.jdbc.entity.PreInsertContext
import org.seasar.doma.jdbc.entity.PreUpdateContext
import org.springframework.stereotype.Component

@Component
class CustomerListener : EntityListener<Customer> {
    override fun preInsert(entity: Customer, context: PreInsertContext<Customer>) {
        entity.createdBy = "登録担当者"
        entity.updatedBy = "登録担当者"
    }

    override fun preUpdate(entity: Customer, context: PreUpdateContext<Customer>) {
        entity.updatedBy = "更新担当者"
    }
}