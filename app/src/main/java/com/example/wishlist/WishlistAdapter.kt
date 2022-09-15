package com.example.wishlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class WishlistAdapter(private val wishlist: List<Wishlist>): RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {
    class ViewHolder(private val wishlist: List<Wishlist>, private val context: Context, itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val nameTextView: TextView = itemView.findViewById(R.id.name)
        val urlTextView: TextView = itemView.findViewById(R.id.url)
        val priceTextView: TextView = itemView.findViewById(R.id.price)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                val wish = wishlist[position]
                Toast.makeText(context, nameTextView.text, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val listView = inflater.inflate(R.layout.wish_item, parent, false)

        return ViewHolder(wishlist, context, listView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val wish = wishlist[position]

        holder.nameTextView.text = wish.name
        holder.urlTextView.text = wish.url
        holder.priceTextView.text = wish.price

    }

    override fun getItemCount(): Int {
        return wishlist.size
    }
}