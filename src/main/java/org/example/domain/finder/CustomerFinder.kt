package org.example.domain.finder

import io.ebean.Finder
import org.example.domain.Customer
import org.example.domain.query.QCustomer
import java.util.*

open class CustomerFinder : Finder<Long,Customer> {

  val alias = QCustomer._alias

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(Customer::class.java)

  /**
   * Construct with a given EbeanServer.
   */
  constructor(serverName: String) : super(Customer::class.java, serverName)

  /**
   * Start a new typed query.
   */
  fun where(): QCustomer {
     return QCustomer(db())
  }

  /**
   * Start a new document store query.
   */
  fun text(): QCustomer {
     return QCustomer(db()).text()
  }

  fun one(id: Long): Optional<Customer> {
    val cust = byId(id)
    return Optional.ofNullable(cust)
//    if (cust != null) {
//    }
//    return Optional.empty<Customer>()
  }
}
