package com.example.mysupernews.presentation.models

import android.view.View
import com.bumptech.glide.Glide
import com.example.mysupernews.R
import com.example.mysupernews.data.models.SuperNews
import com.example.mysupernews.databinding.ItemNewsBinding
import com.xwray.groupie.viewbinding.BindableItem

class NewsItem(val news: SuperNews): BindableItem<ItemNewsBinding>() {
    override fun bind(viewBinding: ItemNewsBinding, position: Int) {
        val imageView = viewBinding.articleImg
        Glide.with(imageView.context)
            .load(news.imageUrl)
            .into(imageView)

        viewBinding.author.text = news.author
        viewBinding.title.text = news.title
        viewBinding.dateTime.text = news.date
    }

    override fun getLayout(): Int {
        return R.layout.item_news
    }

    override fun initializeViewBinding(view: View): ItemNewsBinding {
        return ItemNewsBinding.bind(view)
    }
}