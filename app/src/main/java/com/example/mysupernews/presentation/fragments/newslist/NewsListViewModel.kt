package com.example.mysupernews.presentation.fragments.newslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mysupernews.data.local.SuperNewsCategories
import com.example.mysupernews.data.models.SuperNews
import com.example.mysupernews.domain.NewsUseCase
import kotlinx.coroutines.launch

class NewsListViewModel: ViewModel() {

    private val _newsLiveData= MutableLiveData<List<SuperNews>>()
    val newsLiveData: LiveData<List<SuperNews>> = _newsLiveData

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _categoryLiveDate = MutableLiveData<List<String>>()
    val categoryLiveData: LiveData<List<String>> = _categoryLiveDate

    init{
        getNewsData("technology")
        _categoryLiveDate.postValue(SuperNewsCategories.getSuperNewsCategories())
    }

    fun getNewsData(category: String){
        viewModelScope.launch {
            _isLoading.postValue(true)
            val news = NewsUseCase.getNews(category)
            _newsLiveData.postValue(news.data)
            _isLoading.postValue(false)
        }
    }
}