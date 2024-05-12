package com.example.feature_home.main_screen

import com.arkivanov.decompose.ComponentContext
import com.example.feature_home.main_screen.AboutUsBlock.IAboutUsBlock
import com.example.feature_home.main_screen.pictures.ICardBlock

//Компонент не скрывает что у него есть дочерние компоненты, а наоборот заявляет о них в своем интерфейсе
interface IMainScreen {
    val cardBlock: ICardBlock

    val aboutUsBlock: IAboutUsBlock

    fun interface Factory{
        operator fun invoke(componentContext: ComponentContext): IMainScreen
    }
}