package com.example.apicallusingretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var updatedArrayList: ArrayList<MyDataClass> = ArrayList()
    var myAdapter: MyAdapter= MyAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadData()
    }

    private fun loadData() {
        val api = MySingleton.myApiInterface.getProductsData()
        api.enqueue(object : Callback<List<MyDataClass>>{
            override fun onResponse(
                call: Call<List<MyDataClass>>,
                response: Response<List<MyDataClass>>
            ) {
                val myResponse: List<MyDataClass>? = response.body()
                if (myResponse != null) {
                    for (i in 0 until myResponse.size) {
                        val myDataClass = MyDataClass(
                            myResponse.get(i).image,
                            myResponse.get(i).category,
                            myResponse.get(i).price,
                            myResponse.get(i).title,
                            myResponse.get(i).description
                        )
                        updatedArrayList.add(myDataClass)
                    }
                }

                recyclerView.layoutManager = LinearLayoutManager(applicationContext)
                myAdapter.updateArrayList(updatedArrayList)
                recyclerView.adapter = myAdapter
                Log.d("MM", "ldjflkjd: $updatedArrayList")
            }

            override fun onFailure(call: Call<List<MyDataClass>>, t: Throwable) {
                Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
            }
        })


    }

}