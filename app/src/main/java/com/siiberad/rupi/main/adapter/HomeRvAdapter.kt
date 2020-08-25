package com.siiberad.rupi.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.siiberad.rupi.R
import com.siiberad.rupi.main.model.RvDataModel
import kotlinx.android.synthetic.main.item_rv.view.*

class HomeRvAdapter(private val data: List<RvDataModel>) : RecyclerView.Adapter<HomeRvAdapter.RvHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): RvHolder {
        return RvHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_rv, viewGroup, false))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RvHolder, position: Int) {
        holder.bind(data[position])
    }

    class RvHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(rv: RvDataModel) {
            itemView.rv_img.setImageResource(rv.image)
            itemView.txt_title.text = rv.title
            itemView.txt_desc.text = rv.desc
        }
    }
}

