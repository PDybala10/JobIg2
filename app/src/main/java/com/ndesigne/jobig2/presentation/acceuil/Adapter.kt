package com.ndesigne.jobig2.presentation.acceuil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.ndesigne.jobig2.R
import kotlinx.android.synthetic.main.item_recycleview.view.*

class Adapter(private val list: List<Item>,
              private val listener: OnItemClickListener
) : RecyclerView.Adapter<Adapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_recycleview,
            parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = list[position]
        holder.image.setImageResource(currentItem.image)
        holder.title.text = currentItem.title
        holder.company.text = currentItem.company
        holder.type.text = currentItem.type
        holder.location.text = currentItem.location
        holder.date.text = currentItem.date
    }

    override fun getItemCount() = list.size


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val image = itemView.itemImage
        val title = itemView.title_offre
        val company = itemView.company_offre
        val type = itemView.offre_type
        val location = itemView.location_offre
        val date = itemView.text_date_card_offre
        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}