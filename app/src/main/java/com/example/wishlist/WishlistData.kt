package com.example.wishlist

class WishlistData {
    companion object {
        private var wishlist: MutableList<Wishlist> = ArrayList()

        fun addWish(name: String, url: String, price: Double) {
            wishlist.add(Wishlist(name, url, String.format("%.2f", price)))
        }

        fun getWishes(): MutableList<Wishlist> {
            return wishlist
        }
    }
}