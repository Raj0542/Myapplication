package com.raj.mynewbook.Adapter

import android.content.Context
import android.content.Intent
import android.icu.text.Transliterator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.raj.mynewbook.Activity.DescriptionActivity
import com.raj.mynewbook.R
import com.raj.mynewbook.model.Book
import com.squareup.picasso.Picasso

class DashboardRecyclerAdpater(val context:Context,val ItemList:ArrayList<Book>):RecyclerView.Adapter<DashboardRecyclerAdpater.DashboardViewHolder>() {
    class DashboardViewHolder(view:View):RecyclerView.ViewHolder(view){
        val txtBookName:TextView=view.findViewById(R.id.txtBookName)
        val txtBookAuthor:TextView=view.findViewById(R.id.txtBookAuthor)
        val txtBookPrice:TextView=view.findViewById(R.id.txtBookPrice)
        val txtBookRating:TextView=view.findViewById(R.id.txtBookRating)
        val bookImage:ImageView=view.findViewById(R.id.imgBookImage)
        val liContent:LinearLayout=view.findViewById(R.id.liContent)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.recycler_dashboard_single_row,parent,false)
        return  DashboardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return ItemList.size

    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        val book=ItemList[position]
        holder.txtBookName.text=book.bookName
        holder.txtBookAuthor.text=book.bookAuthor
        holder.txtBookPrice.text=book.bookPrice
        holder.txtBookRating.text=book.bookRating
        Picasso.get().load(book.bookImage).error(R.drawable.default_book_cover).into(holder.bookImage)
      //  holder.bookImage.setImageResource(book.bookImage)
        holder.liContent.setOnClickListener {

            val intent= Intent(context,DescriptionActivity::class.java)
            intent.putExtra("book_id",book.book_id)
            context.startActivity(intent)
        }

    }
}