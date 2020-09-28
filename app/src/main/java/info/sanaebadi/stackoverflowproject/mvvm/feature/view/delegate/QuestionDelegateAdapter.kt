package info.sanaebadi.stackoverflowproject.mvvm.feature.view.delegate

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import info.sanaebadi.domain.model.base.ViewType
import info.sanaebadi.domain.model.details.QuestionViewModel
import info.sanaebadi.stackoverflowproject.databinding.ListItemQuestionBinding
import info.sanaebadi.stackoverflowproject.mvvm.feature.view.delegate.base.ViewTypeDelegateAdapter

class QuestionDelegateAdapter(private val listener: (String) -> Unit) : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup) =
        QuestionViewHolder(
            ListItemQuestionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as QuestionViewHolder
        holder.bind(item as QuestionViewModel, listener)
    }

    class QuestionViewHolder(private val binding: ListItemQuestionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(question: QuestionViewModel, listener: (String) -> Unit) = with(itemView) {
            binding.title.text = question.title
            binding.score.text = "${question.score} points"
            binding.viewCount.text = "Viewed: ${question.viewCount}"

            setOnClickListener { listener(question.link) }
        }
    }
}