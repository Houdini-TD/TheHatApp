package com.example.feature_home.main_screen.pictures

import android.graphics.BlurMaskFilter
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.core.theme.AppTheme
import com.example.core.theme.custom.CustomTheme
import com.example.feature_home.domain.DetailedEstablishment
import kotlinx.coroutines.Dispatchers

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CardBlockUi(component: ICardBlock) {
    val establishmentList by component.establishmentList.collectAsState(Dispatchers.Main)

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        color = Color.Transparent
    ){
        Column {
            Text(
                modifier = Modifier.padding(start = 30.dp),
                text = "Наши заведения",
                style = CustomTheme.typography.title.h2,
                color = CustomTheme.colors.text.primary)

            val pagerState = rememberPagerState(pageCount = {establishmentList.size})
            HorizontalPager(state = pagerState) {page ->
                PagerCard(establishment = establishmentList[page])
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(establishmentList.size){
                    val dotColor = if (it == pagerState.currentPage)
                        CustomTheme.colors.overlay.primary
                    else
                        CustomTheme.colors.background.card
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(dotColor)
                            .size(10.dp)
                            .padding(20.dp)
                    )
                    Spacer(Modifier.width(6.dp))
                }
            }
        }
    }
}


@Composable
fun PagerCard(establishment: DetailedEstablishment){
    Box(
        modifier = Modifier
            .padding(vertical = 6.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(30.dp))
            .height(250.dp),
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(establishment.imageUrl)
                .crossfade(true)
                .build(),
            contentScale = ContentScale.Crop,
            contentDescription = "Establishment photo",
            modifier = Modifier
                .fillMaxSize()
                .background(color = CustomTheme.colors.background.card)
                .innerBottomShadow(
                    blur = 200f,
                    width = 300f
                )
        )

        Text(
            modifier = Modifier
                .padding(end = 30.dp, bottom = 10.dp)
                .align(Alignment.BottomEnd),
            text = establishment.name,
            style = CustomTheme.typography.title.h2,
            color = CustomTheme.colors.text.primary)


    }
}


@Preview(backgroundColor = 0xFF000000)
@Composable
fun CardBlockPreview(){
    AppTheme {
        CardBlockUi(component = FakeCardBlock())
    }
}

fun Modifier.innerBottomShadow(
    blur: Float = 0f,
    width: Float,
) = drawWithContent {

    drawContent()

    val rect = Rect(Offset.Zero, size)
    val paint = Paint().apply {
        strokeWidth = width // Задайте нужную толщину линии
        isAntiAlias = true // Включите сглаживание для размытия
    }
    paint.color = Color.Red

    drawIntoCanvas {

        val canvasWidth = size.width
        val canvasHeight = size.height

        val frameworkPaint = paint.asFrameworkPaint()
        frameworkPaint.color = Color.Red.toArgb()
        frameworkPaint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OUT)
        frameworkPaint.maskFilter = BlurMaskFilter(blur, BlurMaskFilter.Blur.NORMAL)

        it.drawLine(
            p1 = Offset(0f - blur, canvasHeight),
            p2 = Offset(canvasWidth + blur, canvasHeight),
            paint
        )
    }
}