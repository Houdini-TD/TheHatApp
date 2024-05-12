package com.example.feature_home.main_screen.AboutUsBlock

import kotlinx.coroutines.flow.MutableStateFlow

class FakeAboutUsBlock() : IAboutUsBlock {
    override val header = MutableStateFlow("КТО МЫ ТАКИЕ")
    override val content = MutableStateFlow("Группа компаний \"The Hat Group\" ворвалась в барную жизнь Санкт-Петербурга более 6 лет назад: всё началось с первого и культового \"Терминала\", который тогда располагался на улице Рубинштейна. Потом появился джаз-бар \"Шляпа\", очень быстро ставший символом нашего города: именно со \"Шляпы\" началась ресторанная история улицы Белинского, которая на данный момент является второй барной улицей города.")

}
