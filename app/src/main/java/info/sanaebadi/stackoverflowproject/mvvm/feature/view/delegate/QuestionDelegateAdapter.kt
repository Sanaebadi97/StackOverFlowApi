package com.example.tamaskozmer.kotlinrxexample.presentation.view.adapters.delegateadapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.tamaskozmer.kotlinrxexample.R
import com.example.tamaskozmer.kotlinrxexample.presentation.view.viewmodels.QuestionViewModel
import com.example.tamaskozmer.kotlinrxexample.util.inflate
import com.example.tamaskozmer.kotlinrxexample.presentation.view.adapters.ViewType
import com.example.tamaskozmer.kotlinrxexample.presentation.view.adapters.ViewTypeDelegateAdapter
import kotlinx.android.synthetic.main.list_item_question.view.*

class QuestionDelegateAdapter(private val listener: (String) -> Unit) : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup) =
            QuestionViewHolder(parent.inflate(R.layout.list_item_question))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as QuestionViewHolder
        holder.bind(item as QuestionViewModel, listener)
    }

    class QuestionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(question: QuestionViewModel, listener: (String) -> Unit) = with(itemView) {
            title.text = question.title
            score.text = "${question.score} points"
            viewCount.text = "Viewed: ${question.viewCount}"

            setOnClickListener { listener(question.link) }
        }
    }
}