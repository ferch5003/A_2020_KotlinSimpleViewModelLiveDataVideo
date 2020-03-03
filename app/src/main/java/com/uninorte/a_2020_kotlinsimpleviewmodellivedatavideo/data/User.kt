package com.uninorte.a_2020_kotlinsimpleviewmodellivedatavideo.data

data class User(val name: String, val age: Int){

    override fun toString(): String {
        return "$name" + "$age"
    }
}