package com.test.assignment.adapters

import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.test.assignment.R
import de.hdodenhof.circleimageview.CircleImageView

/**
 * @author swapnil tripathi 5 july
 * ViewHolder for Detail List items
 */

class DetailViewHolder(itemView: View, var onDetailListener: OnDetailClickListener) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
    @JvmField
    var title: TextView = itemView.findViewById(R.id.title)

    @JvmField
    var description: TextView = itemView.findViewById(R.id.sub_title)

    @JvmField
    var image: CircleImageView = itemView.findViewById(R.id.image)

    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        //for showing detail page.
    }
}