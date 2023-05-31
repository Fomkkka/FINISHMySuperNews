package com.example.mysupernews.presentation.fragments.newspage


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import androidx.navigation.fragment.navArgs
import com.example.mysupernews.R
import com.example.mysupernews.databinding.FragmentNewsPageBinding

class NewsPageFragment : Fragment(R.layout.fragment_news_page) {
    private lateinit var binding: FragmentNewsPageBinding

    private val args: NewsPageFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewsPageBinding.bind(view)

        val news = args.news
        Glide.with(binding.root)
            .load(news.imageUrl)
            .into(binding.newsImage)

        binding.newsDate.text = news.date
        binding.newsAuthor.text = news.author

        binding.newsTitle.text = news.title
        binding.newsDescription.text = news.content

        binding.newsReadmoreLink.setOnClickListener {
            if (news.readMoreUrl != null) {
                val intentBrowser = Intent(Intent.ACTION_VIEW)
                intentBrowser.setData(Uri.parse(news.readMoreUrl))
                startActivity(intentBrowser)
            }
            else {
                Toast.makeText(requireContext(), "Не завантажується сторінка", Toast.LENGTH_SHORT).show()
            }
        }
    }
}