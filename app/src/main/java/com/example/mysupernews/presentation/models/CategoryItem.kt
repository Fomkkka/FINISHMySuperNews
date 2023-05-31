package com.example.mysupernews.presentation.models

import android.view.View
import com.example.mysupernews.R
import com.example.mysupernews.databinding.ItemNewsCategoryBinding
import com.xwray.groupie.viewbinding.BindableItem

class CategoryItem(val category: String): BindableItem<ItemNewsCategoryBinding>() {


    override fun bind(viewBinding: ItemNewsCategoryBinding, position: Int) {
        viewBinding.categoryText.text = category
    }

    override fun getLayout(): Int {
        return R.layout.item_news_category
    }

    override fun initializeViewBinding(view: View): ItemNewsCategoryBinding {
        return  ItemNewsCategoryBinding.bind(view)
    }
}