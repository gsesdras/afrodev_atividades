package com.goiz.acdcticketbuyer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import com.goiz.acdcticketbuyer.model.Ticket
import com.goiz.acdcticketbuyer.model.TicketVIP

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnBuy = findViewById<Button>(R.id.btnBuy)
        val txtPrice = findViewById<TextView>(R.id.ticketPrice)

        btnBuy.setOnClickListener{
            Toast.makeText(
                this,
                "Você comprou o ingresso por ${txtPrice.text}",
                Toast.LENGTH_SHORT).show()
        }

    }
    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            
            val checked = view.isChecked

            when (view.getId()) {
                R.id.radio_commom ->
                    if (checked) {
                        val ticket = Ticket()
                        val price = findViewById<TextView>(R.id.ticketPrice)
                        price.text = ticket.toString()
                        price.visibility = View.VISIBLE
                    }
                R.id.radio_vip ->
                    if (checked) {
                        val ticketVip = TicketVIP()
                        val price = findViewById<TextView>(R.id.ticketPrice)
                        price.text = ticketVip.toString()
                        price.visibility = View.VISIBLE
                    }
            }
        }
    }
}