package com.goiz.acdcticketbuyer.model

open class Ticket{
    protected val price: Float = 200f

    override fun toString() : String{
        val price = "%.2f".format(this.price)
        return "R$ $price"
    }

}