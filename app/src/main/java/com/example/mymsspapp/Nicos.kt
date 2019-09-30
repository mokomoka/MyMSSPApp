package com.example.mymsspapp

class NicoResponse {
    var meta : Meta? = null
    var data = mutableListOf<Nicos>()
}

class Meta {
    var status : Int? = null
    var totalCount : Int? = null
    var id : String? = null
}

class Nicos {
    var contentId : String? = null
    var title : String? = null
    var viewCounter : Int? = null
    var lengthSeconds : Int? = null
    var thumbnailUrl : String? = null
    var startTime : String? = null
    var commentCounter : Int? = null
}