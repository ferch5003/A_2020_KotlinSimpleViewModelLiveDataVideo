package com.uninorte.a_2020_kotlinsimpleviewmodellivedatavideo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.uninorte.a_2020_kotlinsimpleviewmodellivedatavideo.data.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var userList = mutableListOf<User>()
    lateinit var model: MyViewModel
    var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("VideoViewModel", "onCreate")

        model = ViewModelProvider(this).get(MyViewModel::class.java)

        model.getUser().observe(this, Observer { users ->
            run {
                textViewSize.text = "${users.size}"
                count = users.size
                userList = users as MutableList<User>
                users.forEach{ user ->
                    Log.d("VideoViewModel", "${user.name} ${user.age}")
                }
                Log.d("VideoViewModel", "${users.size}")
            }
        })
    }

    fun onCLick(view: View){
        userList.add(User(editText.text.toString(), count + 50))
        model.getUser().value = userList
    }
}
