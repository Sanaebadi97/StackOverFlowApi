package info.sanaebadi.stackoverflowproject.mvvm.feature.view.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import info.sanaebadi.domain.model.base.ViewType
import info.sanaebadi.stackoverflowproject.databinding.ListItemHeadingBinding
import info.sanaebadi.stackoverflowproject.model.user.Heading
import info.sanaebadi.stackoverflowproject.mvvm.feature.view.delegate.base.ViewTypeDelegateAdapter

class HeadingDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup) =
        HeadingViewHolder(
            ListItemHeadingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as HeadingViewHolder
        holder.bind(item as Heading)
    }

    class HeadingViewHolder(private val binding: ListItemHeadingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(heading: Heading) = with(itemView) {
            binding.title.text = heading.title
        }
    }
}