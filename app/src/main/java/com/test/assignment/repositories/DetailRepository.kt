package com.test.assignment.repositories

import androidx.lifecycle.LiveData
import com.test.assignment.models.Detail
import com.test.assignment.requests.DetailApiClient

/**
 * @author swapnil tripathi 5 july
 * repository for API data handle
 */


class DetailRepository private constructor() {
    private val mDetailApiClient: DetailApiClient? = DetailApiClient.instance

    val categoryName: LiveData<List<Detail>?>?
        get() = mDetailApiClient?.category

    val detailPage: LiveData<String?>?
        get() = mDetailApiClient?.detailPage


    fun detailApi() {
        mDetailApiClient?.detailApi()
    }

    fun searchNextPage() {
        detailApi()
    }

    fun cancelRequest() {
        mDetailApiClient?.cancelRequest()
    }

    companion object {
        var instance: DetailRepository? = null
            get() {
                if (field == null) {
                    field = DetailRepository()
                }
                return field
            }
            private set
    }
}