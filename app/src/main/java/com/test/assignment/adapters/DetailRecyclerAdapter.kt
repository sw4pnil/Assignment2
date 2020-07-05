package com.test.assignment.adapters

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.test.assignment.R
import com.test.assignment.models.Detail
import java.util.*

/**
 * @author swapnil tripathi 5 july
 * Recycler view for Detail List items
 */


class DetailRecyclerAdapter(private val mOnDetailClickListener: OnDetailClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var mCategory: List<Detail>

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): RecyclerView.ViewHolder {
        var view: View?
        return when (i) {
            LOADING_TYPE -> {
                view = LayoutInflater.from(viewGroup.context).inflate(R.layout.layout_loading_list_item, viewGroup, false)
                LoadingViewHolder(view)
            }
            else -> {
                view = LayoutInflater.from(viewGroup.context).inflate(R.layout.layout_category_list_item, viewGroup, false)
                DetailViewHolder(view, mOnDetailClickListener)
            }
        }
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, i: Int) {
        val itemViewType = getItemViewType(i)
        if (itemViewType == RECIPE_TYPE) { // set the image
            val options = RequestOptions()
                    .centerCrop()
                    .error(R.drawable.ic_launcher_background)
            val path = Uri.parse(mCategory[i].getImageHref())
            Glide.with((viewHolder as DetailViewHolder).itemView)
                    .setDefaultRequestOptions(options)
                    .load(path)
                    .into(viewHolder.image)
            viewHolder.title.text = mCategory[i].getTitle()
            viewHolder.description.text = mCategory[i].getBy()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == mCategory.size  && position != 0 && mCategory[position].getTitle() != "EXHAUSTED...") {
                LOADING_TYPE
            } else {
                RECIPE_TYPE
            }
    }

    override fun getItemCount(): Int {
        return mCategory.size
    }

    fun displayLoading() {
        if (!isLoading) {
            val recipe = Detail()
            recipe.setTitle("LOADING...")
            val loadingList: MutableList<Detail> = ArrayList()
            loadingList.add(recipe)
            mCategory = loadingList
            notifyDataSetChanged()
        }
    }

    private val isLoading: Boolean
        get() {
            if (mCategory.isNotEmpty()) {
                if (mCategory[mCategory.size - 1].getTitle() == "LOADING...") {
                    return true
                }
            }
            return false
        }

    fun setRecipes(recipes: List<Detail>) {
        mCategory = recipes
        notifyDataSetChanged()
    }

    companion object {
        private const val RECIPE_TYPE = 1
        private const val LOADING_TYPE = 2
    }

    init {
        mCategory = ArrayList()
    }
}