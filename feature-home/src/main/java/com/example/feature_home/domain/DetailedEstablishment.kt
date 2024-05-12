package com.example.feature_home.domain

data class DetailedEstablishment(
    val id: Int,
    val name: String,
    val imageUrl: String,
) {

    companion object{
         fun Placeholder(variation: Int = 0) : DetailedEstablishment {
             when (variation){
                 0 -> return DetailedEstablishment(
                     id = -1,
                     name = "placeholder0",
                     imageUrl = "https://hatgroup.ru/wp-content/uploads/2013/12/DSC_1755-2-620x420.jpg"
                 )
                 1 -> return DetailedEstablishment(
                     id = -2,
                     name = "placeholder1",
                     imageUrl = "https://hatgroup.ru/wp-content/uploads/2015/12/thehatbar008-620x420.jpg"
                 )
                 2 -> return DetailedEstablishment(
                     id = -3,
                     name = "placeholder2",
                     imageUrl = "https://hatgroup.ru/wp-content/uploads/2015/12/thehatbar007-e1450683898921.jpg"
                 )
                 else -> return DetailedEstablishment(
                     id = -4,
                     name = "placeholder3",
                     imageUrl = "https://hatgroup.ru/wp-content/uploads/2017/11/The-Hat-Bar-Berlin_07-620x420.jpg"
                 )
             }
        }
    }
}