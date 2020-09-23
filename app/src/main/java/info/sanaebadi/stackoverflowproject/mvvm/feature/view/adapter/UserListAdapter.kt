package info.sanaebadi.stackoverflowproject.mvvm.feature.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import info.sanaebadi.domain.model.user.User
import info.sanaebadi.stackoverflowproject.databinding.ListItemUserBinding
import info.sanaebadi.stackoverflowproject.util.loadUrl

class UserListAdapter(
    private val users: MutableList<User>,
    private val listener: (User, View) -> Unit

) : RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) =
        holder.bind(users[position], listener)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding =
            ListItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)

    }

    fun addUsers(newUsers: List<User>) {
        users.addAll(newUsers)
        notifyDataSetChanged()
    }

    fun clearUsers() {
        users.clear()
    }

    open class UserViewHolder(private val binding: ListItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("NewApi", "SetTextI18n")
        fun bind(user: User, listener: (User, View) -> Unit) = with(itemView) {

            binding.textUserName.text = user.displayName
            binding.textUserReputation.text = "${user.reputation} points"
            binding.imageUserAvatar.loadUrl(user.profileImage)

        }
    }
}