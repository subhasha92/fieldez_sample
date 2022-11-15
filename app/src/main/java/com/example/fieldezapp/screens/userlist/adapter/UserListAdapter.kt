package com.example.fieldezapp.screens.userlist.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fieldezapp.R
import com.example.fieldezapp.data.DataUtil
import com.example.fieldezapp.data.SelectionModal

class UserListAdapter(private val param: (String) -> Unit) : RecyclerView.Adapter<UserListAdapter.VH>() {

    val dataList = DataUtil.getUserList()

    inner class VH(private val itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                val name=dataList[adapterPosition]
                param.invoke(name.content.toString())
            }
        }

        @SuppressLint("UseCompatLoadingForDrawables")
        fun bind(model: SelectionModal) {

            tvName.text = model.content
            tvDate.text = model.time
            if (model.dotColor != 0)
                ivDot.setImageDrawable(
                    itemView.resources.getDrawable(R.drawable.ic_orange_dot)
                )
        }

        val tvName: AppCompatTextView = itemView.findViewById(R.id.tvName)
        val tvDate: AppCompatTextView = itemView.findViewById(R.id.tvDate)
        val ivDot: AppCompatImageView = itemView.findViewById(R.id.ivDot)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(
            LayoutInflater.from(parent.context).inflate(R.layout.item_user_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val model = dataList[position]
        holder.bind(model)
    }

    override fun getItemCount(): Int = dataList.size

}
