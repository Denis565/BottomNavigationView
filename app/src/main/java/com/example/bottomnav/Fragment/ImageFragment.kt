package com.example.bottomnav.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.bottomnav.ApiInterface
import com.example.bottomnav.Models.UrlImageModel
import com.example.bottomnav.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_image.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ImageFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_image, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        load.setOnClickListener {

            val builder = Retrofit.Builder()
                .baseUrl("https://aws.random.cat/")
                .addConverterFactory(GsonConverterFactory.create())
            val retrofit = builder.build()
            val apiInterface: ApiInterface = retrofit.create<ApiInterface>(ApiInterface::class.java)
            val call: retrofit2.Call<UrlImageModel> = apiInterface.getFile()
            call.enqueue(object : Callback<UrlImageModel> {
                override fun onFailure(call: Call<UrlImageModel>, t: Throwable) {
                    Log.i("LOG", t.message.toString())
                }

                override fun onResponse(call: Call<UrlImageModel>, response: Response<UrlImageModel>) {
                    Picasso
                        .get()
                        .load(response.body()?.file)
                        .fit()
                        .placeholder(R.drawable.ic_launcher_foreground)
                        .error(R.drawable.ic_launcher_background)
                        .into(image_view)
                }

            })
        }
    }

}

