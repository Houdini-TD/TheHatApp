package com.example.feature_feed.feed_screen

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.core.theme.AppTheme
import com.example.core.theme.custom.CustomTheme
import com.example.core.utils.compose.ExpandableText
import com.example.feature_feed.domain.Post

@Composable
fun FeedScreenUI(component: IFeedScreen){
    val posts by component.posts.collectAsState()

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        color = Color.Transparent
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(posts.size) {
                PostView(post = posts[it])
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Composable
fun PostView(post: Post){
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CustomTheme.m3Colors.cardColors.primary
    ) {
        Column(
            Modifier.padding(8.dp)
        ) {
            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = post.header,
                style = CustomTheme.typography.title.h3,
                color = CustomTheme.colors.text.secondary
            )
            ExpandableText(
                text = post.content,
                style = CustomTheme.typography.body.regular,
                showMoreText = " ...Показать",
                showLessText = " Скрыть",
                showMoreStyle = CustomTheme.typography.body.regular
                    .copy(
                        color = Color(0xFF2689AF),
                        fontWeight = FontWeight.Bold
                    ).toSpanStyle()
            )

            Spacer(modifier = Modifier.height(12.dp))

            ImagePager(post)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImagePager(post: Post){
    Box(
        contentAlignment = Alignment.BottomCenter
    ){
        val pagerState = rememberPagerState(pageCount = {post.images.size})
        HorizontalPager(state = pagerState) {page ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .clip(RoundedCornerShape(8.dp)),
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(post.images[page])
                        .crossfade(true)
                        .build(),
                    contentScale = ContentScale.Crop,
                    contentDescription = "Post photo",
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Gray)
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.Center,
        ) {
            repeat(post.images.size){
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


@Composable
@Preview(
    showSystemUi = true,
    backgroundColor = 0xFFF7931E
)
fun FeedScreenPreview(){
    AppTheme {
        FeedScreenUI(FakeFeedScreen())
    }
}