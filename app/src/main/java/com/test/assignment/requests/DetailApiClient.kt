package com.test.assignment.requests

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.test.assignment.AppExecutors
import com.test.assignment.models.Detail
import com.test.assignment.util.Constants
import okhttp3.Call
import okhttp3.Callback
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.lang.Exception
import java.util.*
import java.util.concurrent.TimeUnit


/**
 * @author swapnil tripathi 5 july
 */

class DetailApiClient private constructor() {
    private val mCategory: MutableLiveData<List<Detail>?> = MutableLiveData()
    private val mDetailPage: MutableLiveData<String?> = MutableLiveData()
    private var mRetrieveDetailRunnable: RetrieveDetailArrayRunnable? = null
    private var mDetailDataRunnable: DetailDataRunnable? = null
    var arrayListDetails: ArrayList<Detail> = ArrayList()
    private var itemCount = 0

    val category: LiveData<List<Detail>?>
        get() = mCategory

    val detailPage: LiveData<String?>
        get() = mDetailPage

    fun detailApi() {
        if (mRetrieveDetailRunnable != null) {
            mRetrieveDetailRunnable = null
        }
        mRetrieveDetailRunnable = RetrieveDetailArrayRunnable()
        val handler = AppExecutors.get()?.networkIO()?.submit(mRetrieveDetailRunnable)
        AppExecutors.get()?.networkIO()?.schedule({
            handler?.cancel(true)
        }, Constants.NETWORK_TIMEOUT.toLong(), TimeUnit.MILLISECONDS)
    }

    private inner class RetrieveDetailArrayRunnable : Runnable {
        private var cancelRequest = false
        override fun run() {
            run(ServiceGenerator.getDetailApiCall(Constants.BASE_URL))
        }

        private fun run(call: Call) {
            call.enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    //Log.d("Error:",e)
                }

                override fun onResponse(call: Call, response: okhttp3.Response) {
                    val strResponse = response.body()!!.string()
                    val array = JSONArray(strResponse)
                    val limit = itemCount+20
                    for (i in itemCount until limit) {
                        itemCount++

                        if (mDetailDataRunnable != null) {
                            mDetailDataRunnable = null
                        }

                        try {
                            mDetailDataRunnable = DetailDataRunnable(array[i])
                            val handler = AppExecutors.get()?.networkIO()?.submit(mDetailDataRunnable)
                            AppExecutors.get()?.networkIO()?.schedule({
                                handler?.cancel(true)
                            }, Constants.NETWORK_TIMEOUT.toLong(), TimeUnit.MILLISECONDS)

                        }catch (e: Exception){

                        }

                    }
                    mDetailPage.postValue("About Page")
                    mCategory.postValue(arrayListDetails)
                }
            })
        }
        fun cancelRequest() {
            cancelRequest = true
        }
    }

    private inner class DetailDataRunnable(val id: Any) : Runnable {
        private var cancelRequest = false
        override fun run() {
            run(ServiceGenerator.getDetailApiCall("item/$id.json"))
        }

        private fun run(call: Call) {
            call.enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    //Log.d("Error:",e)
                }

                override fun onResponse(call: Call, response: okhttp3.Response) {
                    val strResponse = response.body()!!.string()
                    //creating json object
                    val jsonObjectDetail = JSONObject(strResponse)
                    val model = Detail()

                    try {
                        model.setImageHref("url")

                    } finally {
                        model.setTitle(jsonObjectDetail.getString("title"))
                        model.setby(jsonObjectDetail.getString("by"))
                        arrayListDetails.add(model)
                    }
                }
            })
        }

        fun cancelRequest() {
            cancelRequest = true
        }

    }

    fun cancelRequest() {
        if (mRetrieveDetailRunnable != null) {
            mRetrieveDetailRunnable!!.cancelRequest()
        }
    }

    companion object {
        private const val TAG = "RecipeApiClient"

        @JvmStatic
        var instance: DetailApiClient? = null
            get() {
                if (field == null) {
                    field = DetailApiClient()
                }
                return field
            }
            private set
    }

}