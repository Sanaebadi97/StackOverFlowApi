package info.sanaebadi.stackoverflowproject.mvvm.feature.view.delegate

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import info.sanaebadi.domain.model.base.ViewType
import info.sanaebadi.stackoverflowproject.R
import info.sanaebadi.stackoverflowproject.model.user.Heading
import info.sanaebadi.stackoverflowproject.mvvm.feature.view.delegate.base.ViewTypeDelegateAdapter
import info.sanaebadi.stackoverflowproject.util.inflate

class HeadingDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup) =
        HeadingViewHolder(parent.inflate(R.layout.list_item_heading))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as HeadingViewHolder
        holder.bind(item as Heading)
    }

    class HeadingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(heading: Heading) = with(itemView) {
            title.text = heading.title
        }
    }
}