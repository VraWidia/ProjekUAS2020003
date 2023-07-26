package com.example.uas2020003.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


import com.example.uas2020003.R
import com.example.uas2020003.adapter.adapterkopi
import com.example.uas2020003.app.ApiConfig.ApiConfig
import com.example.uas2020003.model.KopiModel
import com.example.uas2020003.model.ResponseModel
import retrofit2.Call
import retrofit2.Response

class HomeFragment : Fragment() {

    //
    lateinit var rvKopi: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        init(view)
        getKopi()
        return view
    }

    private var listKopi: ArrayList<KopiModel> = ArrayList()

    fun getKopi(){
        ApiConfig.instanceRetrofit.getKopi().enqueue(object :
            retrofit2.Callback<ResponseModel> {

            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                val res = response.body()!!
                listKopi = res.kopi
                displayKopi()
            }
            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                Toast.makeText(requireActivity(), "Error :"+t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    fun  displayKopi() {
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        rvKopi.adapter = adapterkopi(requireActivity(), listKopi)
        rvKopi.layoutManager = layoutManager
    }

    fun init(view: View) {
        //rvBarang = view.findViewById(R.id.recyler_view)
        rvKopi=view.findViewById(R.id.recyler_view)
    }

}