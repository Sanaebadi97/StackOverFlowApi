package info.sanaebadi.stackoverflowproject.mvvm.feature.view.delegate

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import info.sanaebadi.domain.model.base.ViewType
import info.sanaebadi.domain.model.user.User
import info.sanaebadi.stackoverflowproject.databinding.ListItemUserDetailsBinding
import info.sanaebadi.stackoverflowproject.mvvm.feature.view.delegate.base.ViewTypeDelegateAdapter
import info.sanaebadi.stackoverflowproject.util.isLollipopOrAbove
import info.sanaebadi.stackoverflowproject.util.loadCircleImage

class UserDetailsDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup) =
        UserDetailsViewHolder(
            ListItemUserDetailsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as UserDetailsViewHolder
        holder.bind(item as User)
    }

    class UserDetailsViewHolder(private val binding: ListItemUserDetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("NewApi", "SetTextI18n")
        fun bind(user: User) = with(itemView) {
            binding.profileImage.loadCircleImage(user.profileImage)
            binding.name.text = user.displayName
            binding.reputation.text = "${user.reputation} points"

            isLollipopOrAbove { binding.profileImage.transitionName = "transition${user.userId}" }
        }
    }
}