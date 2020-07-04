package com.test.assignment.requests

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.test.assignment.AppExecutors
import com.test.assignment.models.Country
import com.test.assignment.models.LoggedInUser
import com.test.assignment.models.Result
import com.test.assignment.requests.api.CredentialCheckApi
import com.test.assignment.util.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import okhttp3.Call
import okhttp3.Callback
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginApiClient internal constructor() {
    var loginApiInterface = (CredentialCheckApi::class.java)

    private val mCategory: MutableLiveData<List<Country>?> = MutableLiveData()
    private val mCountryName: MutableLiveData<String?> = MutableLiveData()
    private var mRetrieveCredentialRunnable: CredentialCheckRunnable? = null

    fun login(username: String, password: String): Result<LoggedInUser> {
        return try {

            CoroutineScope(IO).launch {
                loginCall(username, password)
            }

            val fakeUser = LoggedInUser(UUID.randomUUID().toString(), username, password)
            Result.Success(fakeUser)
        } catch (e: Throwable) {
            Result.Error(IOException("Error logging in", e))
        }
    }

    private suspend fun loginCall(username: String, password: String) =
            loginApiInterface.login(username, password)
                    .run {
                        if (isSuccessful && body() != null) {

                            Log.d("swapnil", body()?.code)
                            /* stringKeyValueDao.insert(
                                     Utils.getCurrentTimeKeyValuePair(Utils.LAST_WEATHER_API_CALL_TIMESTAMP)
                             )
                             weatherDao.deleteAllAndInsert(WeatherMapper(body()!!).map())
                             getDataOrError(NoDataException())*/
                        } else {
                            /* Error(
                                     NoResponseException(
                                             ErrorHandler.parseError<ErrorResponse>(errorBody()?.message
                                     )
                             )*/
                        }
                    }

    fun logout() {
        // TODO: revoke authentication
    }

    private var mRetrieveCountryRunnable: CredentialCheckRunnable? = null
    var arrayListDetails: ArrayList<Country> = ArrayList()

    val category: LiveData<List<Country>?>
        get() = mCategory

    val countryName: LiveData<String?>
        get() = mCountryName

    fun countryDetailApi() {
        if (mRetrieveCountryRunnable != null) {
            mRetrieveCountryRunnable = null
        }
        mRetrieveCountryRunnable = CredentialCheckRunnable()
        val handler = AppExecutors.get()?.networkIO()?.submit(mRetrieveCountryRunnable)
        AppExecutors.get()?.networkIO()?.schedule({
            handler?.cancel(true)
        }, Constants.NETWORK_TIMEOUT.toLong(), TimeUnit.MILLISECONDS)
    }

    private inner class CredentialCheckRunnable : Runnable {
        private var cancelRequest = false
        override fun run() {
            run(ServiceGenerator.getCountryApiCall())
        }

        private fun run(call: Call) {
            call.enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    //Log.d("Error:",e)
                }

                override fun onResponse(call: Call, response: okhttp3.Response) {
                    val strResponse = response.body()!!.string()
                    //creating json object
                    val jsonContact = JSONObject(strResponse)
                    //creating json array
                    val jsonArrayInfo: JSONArray = jsonContact.getJSONArray("rows")
                    val jsonTitleString: String = jsonContact.getString("title")
                    val size: Int = jsonArrayInfo.length()
                    arrayListDetails = ArrayList()
                    for (i in 0 until size) {
                        val jsonObjectDetail: JSONObject = jsonArrayInfo.getJSONObject(i)
                        val model = Country()
                        model.setImageHref(jsonObjectDetail.getString("imageHref"))
                        model.setTitle(jsonObjectDetail.getString("title"))
                        model.setDescription(jsonObjectDetail.getString("description"))
                        arrayListDetails.add(model)
                    }

                    mCountryName.postValue(jsonTitleString)
                    mCategory.postValue(arrayListDetails)

                }
            })
        }

        fun cancelRequest() {
            cancelRequest = true
        }

    }

    fun cancelRequest() {
        if (mRetrieveCountryRunnable != null) {
            mRetrieveCountryRunnable!!.cancelRequest()
        }
    }

}