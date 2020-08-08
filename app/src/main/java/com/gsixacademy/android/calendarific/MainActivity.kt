package com.gsixacademy.android.calendarific

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gsixacademy.android.calendarific.api.CalendarApi
import com.gsixacademy.android.calendarific.api.ServiceBuilder
import com.gsixacademy.android.calendarific.models.CalendarResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val request= ServiceBuilder.buildService(CalendarApi::class.java)

        val call=request.getHolidays("37b33d72e7e27eb0375494553844fde7d1c68cd8","MK",2020)

        call.enqueue(object :Callback<CalendarResponse>{

            override fun onFailure(call: Call<CalendarResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity,t.message,Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<CalendarResponse>,
                response: Response<CalendarResponse>
            ) {
                if (response.isSuccessful){
                    var calendarResponse=response.body()

                }
            }

        })

    }
}
