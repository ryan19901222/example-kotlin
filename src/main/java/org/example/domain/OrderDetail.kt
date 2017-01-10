package org.example.domain

import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.validation.constraints.NotNull

/**
 * Order Detail entity bean.
 */
@Entity
@Table(name = "o_order_detail")
class OrderDetail() : BaseModel() {

  /**
   * Construct with product, order quantity and unit price.
   */
  constructor(product: Product, orderQty: Int, unitPrice: Double) : this() {
    this.product = product
    this.orderQty = orderQty
    this.unitPrice = unitPrice
  }

  /**
   * The owning order - should be not null really.
   */
  @NotNull
  @ManyToOne
  var order: Order? = null

  var orderQty: Int? = null

  var shipQty: Int? = null

  var unitPrice: Double? = null

  @NotNull
  @ManyToOne
  var product: Product? = null

  /**
   * Helper method to set some properties.
   */
  fun set(product: Product, orderQty: Int, unitPrice: Double) {
    this.product = product;
    this.unitPrice = unitPrice
    this.orderQty = orderQty
  }


}
