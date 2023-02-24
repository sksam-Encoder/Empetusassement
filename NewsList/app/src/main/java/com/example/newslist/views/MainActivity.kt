package com.example.newslist.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import com.example.newslist.common.BasicScreenState
import com.example.newslist.data.dto.NewsModel
import com.example.newslist.ui.theme.NewsListTheme
import com.example.newslist.viewmodel.NewsViewModel
import java.util.*

class MainActivity : ComponentActivity() {
    val viewModel by viewModels<NewsViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsListTheme(darkTheme = false) {
                Scaffold(topBar = {
                    TopAppBar(title = {
                        Text(text = "News List")
                    })
                }) {
                    NewsList(
                        Modifier
                            .fillMaxSize()
                            .padding(it)
                    )
                }
            }
        }
    }

    @Composable
    fun NewsList(modifier: Modifier) {
        LaunchedEffect(key1 = viewModel.change, block = {
            viewModel.getNews()
        })
        BasicScreenState(state = viewModel.state) {
            Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
                HeaderSection(Modifier.fillMaxWidth())
                viewModel.state.value.receivedResponse?.let {
                    Items(it)
                }
            }
        }
    }

    @Composable
    fun Items(newsModel: NewsModel) {
        LazyColumn {
            items(newsModel.size) { indeic ->
                if (newsModel[indeic].title?.contains(viewModel.search) == true)
                {   MoviesListDesign(newsModel[indeic]) }
                else if (newsModel[indeic].title?.contains((viewModel.search.replaceFirstChar {
                        if (it.isLowerCase()) it.titlecase(
                            Locale.US
                        ) else it.toString()
                    })) == true) {
                    MoviesListDesign(newsModel[indeic])
                }
            }
        }
    }

    private @Composable
    fun HeaderSection(modifier: Modifier) {
        Box(modifier = modifier)
        {
            OutlinedTextField(value = viewModel.search, onValueChange = {
                viewModel.search = it
            }, placeholder = {
                Text(text = "Search news here")
            }, modifier = Modifier
                .fillMaxWidth(.9f)
                .padding(vertical = 5.dp)
                .align(Alignment.Center)
            )
        }
    }
}
