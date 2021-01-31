package com.example.retrofitsample.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitsample.adapters.UsersAdapter
import com.example.retrofitsample.api.ApiClient
import com.example.retrofitsample.response.User
import com.example.retrofitsample.utils.Utility.isInternetAvailable
import com.example.shimmereffectrecyclerviewsample.R
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var usersList: MutableList<User> = mutableListOf<User>()
    private var usersAdapter: UsersAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usersList = mutableListOf()

        recycler_view_main.layoutManager = LinearLayoutManager(this@MainActivity)
        usersAdapter = UsersAdapter(
            this,
            usersList
        )
        recycler_view_main.adapter = usersAdapter

        if (isInternetAvailable()) {
            getUsersData()
        }

    }

    private fun getUsersData() {

        ApiClient.apiService.getUsers().enqueue(object : Callback<MutableList<User>> {
            override fun onFailure(call: Call<MutableList<User>>, t: Throwable) {
                shimmer_frame_main.stopShimmerAnimation()
                shimmer_frame_main.visibility = View.GONE
                Log.e("error", t.localizedMessage)
            }

            override fun onResponse(
                call: Call<MutableList<User>>,
                response: Response<MutableList<User>>
            ) {
                shimmer_frame_main.stopShimmerAnimation()
                shimmer_frame_main.visibility = View.GONE
                recycler_view_main.visibility = View.VISIBLE
                val usersResponse = response.body()
                usersList.clear()
                usersResponse?.let { usersList.addAll(it) }
                usersAdapter?.notifyDataSetChanged()
            }

        })

    }

    override fun onResume() {
        super.onResume()
        shimmer_frame_main.startShimmerAnimation()
    }

    override fun onPause() {
        shimmer_frame_main.stopShimmerAnimation()
        super.onPause()
    }

}
