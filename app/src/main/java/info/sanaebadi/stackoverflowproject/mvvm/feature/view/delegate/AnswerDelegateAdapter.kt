package info.sanaebadi.stackoverflowproject.mvvm.feature.view.delegate

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import info.sanaebadi.domain.model.base.ViewType
import info.sanaebadi.domain.model.details.AnswerViewModel
import info.sanaebadi.stackoverflowproject.R
import info.sanaebadi.stackoverflowproject.mvvm.feature.view.delegate.base.ViewTypeDelegateAdapter
import info.sanaebadi.stackoverflowproject.util.inflate

class AnswerDelegateAdapter(private val listener: (String) -> Unit) : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup) =
        AnswerViewHolder(parent.inflate(R.layout.list_item_answer))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as AnswerViewHolder
        holder.bind(item as AnswerViewModel, listener)
    }

    class AnswerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(answer: AnswerViewModel, listener: (String) -> Unit) = with(itemView) {
            score.text = "${answer.score} points"
            questionTitle.text = answer.questionTitle

            setOnClickListener { listener("https://stackoverflow.com/a/${answer.answerId}") }
        }
    }
}