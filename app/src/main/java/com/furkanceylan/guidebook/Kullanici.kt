package com.furkanceylan.guidebook

class Kullanici {
    var id: Int = 0
    var adsoyad: String =" "
    var yasi: Int = 0
    constructor(){

    }
    constructor(adsoyad: String, yasi: Int){
        this.adsoyad = adsoyad
        this.yasi = yasi
    }

}