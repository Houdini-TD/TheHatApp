package com.example.feature_home.main_screen

import com.example.feature_home.main_screen.AboutUsBlock.FakeAboutUsBlock
import com.example.feature_home.main_screen.pictures.FakeCardBlock

class FakeMainScreen(): IMainScreen {

    override val cardBlock = FakeCardBlock()

    override val aboutUsBlock = FakeAboutUsBlock()

}