package com.uninorte.a_2020_kotlinsimpleviewmodellivedatavideo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.uninorte.a_2020_kotlinsimpleviewmodellivedatavideo.data.User

class MyViewModel: ViewModel() {

    private val userList = mutableListOf<User>()

    private val users = MutableLiveData<List<User>>()

    init{

        for(i in 1..5){
            userList.add(User("TestUser", i + 20))

            users.value = userList
        }

    }

    fun getUser(): MutableLiveData<List<User>>{
        return users
    }

}