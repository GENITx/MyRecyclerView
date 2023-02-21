package com.example.myrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardViewHeroAdapter(private val listHeroes: ArrayList<Hero>): RecyclerView.Adapter<CardViewHeroAdapter.CardViewHolder>() {

    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvFrom: TextView = itemView.findViewById(R.id.tv_item_from)
        var btnFav: Button = itemView.findViewById(R.id.btn_set_fav)
        var btnShare: Button = itemView.findViewById(R.id.btn_set_share)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_cardview_hero, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val (name, from, photo) = listHeroes[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)

        holder.tvName.text = name
        holder.tvFrom.text = from

        holder.btnFav.setOnClickListener{
            Toast.makeText(holder.itemView.context, "Favorite " + listHeroes[position].name, Toast.LENGTH_SHORT).show()
        }

        holder.btnShare.setOnClickListener{
            Toast.makeText(holder.itemView.context, "Share " + listHeroes[position].name, Toast.LENGTH_SHORT).show()
        }

        holder.itemView.setOnClickListener{
            Toast.makeText(holder.itemView.context, "Kamu memilih " + listHeroes[position].name, Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int {
        return listHeroes.size
    }

}