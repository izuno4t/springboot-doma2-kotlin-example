package com.example.entiry

import org.seasar.doma.*


@Entity(listener = CustomerListener::class, metamodel = Metamodel())
@Table(name = "foo")
class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequence = "customers_id_seq")
    var id: Long = -1

    @Column(name = "first_name")
    var firstName: String? = null

    @Column(name = "last_name")
    var lastName: String? = null

    @Column
    @Version
    var version: Long = -1

    @Column(name = "created_by")
    var createdBy: String? = null

    @Column(name = "updated_by")
    var updatedBy: String? = null

    override fun toString(): String {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s', version=%d, createdBy='%s', updatedBy='%s']", id,
                firstName, lastName, version, createdBy, updatedBy
        )
    }

    companion object {
        fun create(firstName: String?, lastName: String?): Customer {
            return Customer().also {
                it.firstName = firstName
                it.lastName = lastName
            }
        }
    }
}