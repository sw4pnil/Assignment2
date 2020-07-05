package com.test.assignment

import android.os.Bundle
import android.view.WindowManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.assignment.adapters.DetailRecyclerAdapter
import com.test.assignment.adapters.OnDetailClickListener
import com.test.assignment.util.VerticalSpacingItemDecorator
import com.test.assignment.viewmodels.DetailListViewModel
import kotlinx.android.synthetic.main.activity_detail_list.*

/**
 * @author swapnil tripathi 5 july
 * Main screen where all category is showing
 */

class DetailListActivity : BaseActivity(), OnDetailClickListener {

    private var mDetailListViewModel: DetailListViewModel? = null
    private var mRecyclerView: RecyclerView? = null
    private var mAdapter: DetailRecyclerAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_detail_list)
        mRecyclerView = findViewById(R.id.recipe_list)
        this.mDetailListViewModel = ViewModelProviders.of(this).get(DetailListViewModel::class.java)

        initRecyclerView()
        subscribeObservers()
        this.mDetailListViewModel!!.detailList()

    }

    private fun subscribeObservers() {
        mDetailListViewModel?.categoryList?.observe(this, Observer { recipes ->
            if (recipes != null) {
                mDetailListViewModel?.setIsPerformingQuery(false)
                mAdapter?.setRecipes(recipes)
            }
        })

        mDetailListViewModel?.detailPage?.observe(this, Observer { detail ->
            if (detail != null) {
                mDetailListViewModel?.setIsPerformingQuery(false)
                screen_title.text = detail
            }
        })
    }

    private fun initRecyclerView() {
        mAdapter = DetailRecyclerAdapter(this)
        val itemDecorator = VerticalSpacingItemDecorator(30)
        mRecyclerView?.addItemDecoration(itemDecorator)
        val layoutManager = LinearLayoutManager(this)
        mRecyclerView?.adapter = mAdapter
        mRecyclerView?.layoutManager = layoutManager
        mRecyclerView?.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (mRecyclerView?.canScrollVertically(1) != null) { // search for the next page
                    mDetailListViewModel?.searchNextPage()
                }

                if (isLastItemDisplaying(recyclerView)) {
                    //Log.i("Reached end: ", "Load more");
                    mDetailListViewModel?.detailList()
                }
            }
        })
    }

    private fun isLastItemDisplaying(recyclerView: RecyclerView): Boolean {
        //Check if the adapter item count is greater than 0
        if (recyclerView.adapter!!.itemCount != 0) {
            //get the last visible item on screen using the layout manager
            val lastVisibleItemPosition = (recyclerView.layoutManager as LinearLayoutManager?)!!.findLastCompletelyVisibleItemPosition()
            if (lastVisibleItemPosition != RecyclerView.NO_POSITION && lastVisibleItemPosition == recyclerView.adapter!!.itemCount - 1) {
                return true
            }
        }
        return false
    }

    override fun onDetailClick(category: String?) {
        mAdapter?.displayLoading()
    }

    private fun displaySearchCategories() {
        mDetailListViewModel!!.isViewingRecipes = false
    }

    override fun onBackPressed() {
        if (mDetailListViewModel!!.onBackPressed()) {
            super.onBackPressed()
        } else {
            displaySearchCategories()
        }
    }

    companion object {
        private const val TAG = "RecipeListActivity"
    }
}