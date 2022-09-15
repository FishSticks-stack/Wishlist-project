package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var wishlist: List<Wishlist>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wishlistRecyclerView = findViewById<RecyclerView>(R.id.wishRV)
        val submitButton = findViewById<Button>(R.id.buttonET)
        val nameEditText = findViewById<EditText>(R.id.productET)
        val priceEditText = findViewById<EditText>(R.id.priceET)
        val urlEditText = findViewById<EditText>(R.id.storeET)

        wishlist = WishlistData.getWishes()
        val adapter = WishlistAdapter(wishlist)
        wishlistRecyclerView.adapter = adapter
        wishlistRecyclerView.layoutManager = LinearLayoutManager(this)

        submitButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val price = priceEditText.text.toString()
            val url = urlEditText.text.toString()

            if (name.isEmpty() || url.isEmpty() || price.isEmpty()) {
                Toast.makeText(this, "Fields need to be filled", Toast.LENGTH_SHORT).show()
            }
            else {
                nameEditText.text.clear()
                priceEditText.text.clear()
                urlEditText.text.clear()

                WishlistData.addWish(name, url, price.toDouble())
                adapter.notifyDataSetChanged()
            }
        }
    }
}