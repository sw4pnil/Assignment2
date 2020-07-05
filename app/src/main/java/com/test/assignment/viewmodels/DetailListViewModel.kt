package com.test.assignment.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.test.assignment.models.Detail
import com.test.assignment.repositories.DetailRepository

/**
 * @author swapnil tripathi 5 july
 * view model for list data handling
 */

class DetailListViewModel : ViewModel() {
    private val mDetailRepository: DetailRepository? = DetailRepository.instance
    var isViewingRecipes = false
    private var mIsPerformingQuery: Boolean
    val categoryList: LiveData<List<Detail>?>?
        get() = mDetailRepository?.categoryName
    val detailPage : LiveData<String?>?
        get() = mDetailRepository?.detailPage

    fun detailList() {
        isViewingRecipes = true
        mIsPerformingQuery = true
        mDetailRepository?.detailApi()
    }

    fun setIsPerformingQuery(isPerformingQuery: Boolean) {
        mIsPerformingQuery = isPerformingQuery
    }

    fun onBackPressed(): Boolean {
        if (mIsPerformingQuery) {
            mDetailRepository?.cancelRequest()
        }
        if (isViewingRecipes) {
            isViewingRecipes = false
            return false
        }
        return true
    }

    fun searchNextPage() {
        if (!mIsPerformingQuery
                && isViewingRecipes) {
            mDetailRepository?.searchNextPage()
        }
    }

    companion object {
        private const val TAG = "DetailListViewModel"
    }

    init {
        mIsPerformingQuery = false
    }
}