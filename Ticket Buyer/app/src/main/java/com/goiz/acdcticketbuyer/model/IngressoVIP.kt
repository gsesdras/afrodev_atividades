package com.goiz.acdcticketbuyer.model

class TicketVIP : Ticket() {
    val additionalPrice: Float = 300f

    override fun toString(): String{
        val price = "%.2f".format(super.price + this.additionalPrice)
        return "R$ $price"
    }
}