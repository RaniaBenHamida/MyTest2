package com.example.mytest2.views

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.mytest2.R
import com.example.mytest2.response.Astro
import com.example.mytest2.web_service.GetDataService
import com.example.mytest2.web_service.RetrofitClientInstance
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import retrofit2.HttpException


class MainActivity : AppCompatActivity() {

    var astros: MutableLiveData<List<Astro>> = MutableLiveData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        astros.observe(this, Observer {
            data ->
            if (data == null) {
                setError()
            } else {
                setListView(data)
            }
        })

        spinnerAstro.visibility=View.VISIBLE
        listViewAstros.visibility=View.GONE

        if (astros.value != null) {

            setListView(astros.value!!)
            return
        }

        GlobalScope.launch(Dispatchers.IO) {
            val service = RetrofitClientInstance.retrofitInstance.create(GetDataService::class.java)
            val request = service.astros()
            try {
                astros.postValue(request.await())
            } catch (e: HttpException) {
                astros.postValue(null)
            } catch (e: Throwable) {
                astros.postValue(null)
            }
        }
    }

    fun setListView(data: List<Astro>) {
        val adapter = AdapterTest(applicationContext,data!!, this@MainActivity)
        listViewAstros.adapter = adapter
        spinnerAstro.visibility=View.GONE
        listViewAstros.visibility=View.VISIBLE
    }

    fun setError() {
        spinnerAstro.visibility=View.GONE
        listViewAstros.visibility=View.GONE
        Toast.makeText(
            applicationContext,
            "error when call api", Toast.LENGTH_LONG)
            .show()
    }
}
