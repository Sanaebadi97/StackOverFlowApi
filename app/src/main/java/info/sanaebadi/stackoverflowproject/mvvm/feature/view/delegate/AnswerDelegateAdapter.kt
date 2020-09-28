package info.sanaebadi.stackoverflowproject.mvvm.feature.view.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import info.sanaebadi.domain.model.base.ViewType
import info.sanaebadi.domain.model.details.AnswerViewModel
import info.sanaebadi.stackoverflowproject.databinding.ListItemAnswerBinding
import info.sanaebadi.stackoverflowproject.mvvm.feature.view.delegate.base.ViewTypeDelegateAdapter

class AnswerDelegateAdapter(private val listener: (String) -> Unit) : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup) =
        AnswerViewHolder(
            ListItemAnswerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as AnswerViewHolder
        holder.bind(item as AnswerViewModel, listener)
    }

    class AnswerViewHolder(private val binding: ListItemAnswerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(answer: AnswerViewModel, listener: (String) -> Unit) = with(itemView) {
            binding.score.text = "${answer.score} points"
            binding.questionTitle.text = answer.questionTitle

            setOnClickListener { listener("https://stackoverflow.com/a/${answer.answerId}") }
        }
    }
}