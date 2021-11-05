package com.rana.chatapp

class UserData {

    var name: String? = null
    var email : String? = null
    var userId : String? = null



    constructor(){}

    constructor(name : String , email : String , userId : String){
        this.email = email
        this.name = name
        this .userId = userId

    }
}