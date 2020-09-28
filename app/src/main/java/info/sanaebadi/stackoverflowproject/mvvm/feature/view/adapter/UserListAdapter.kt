package info.sanaebadi.stackoverflowproject.mvvm.feature.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import info.sanaebadi.stackoverflowproject.databinding.ListItemUserBinding
import info.sanaebadi.stackoverflowproject.model.user.UserPresentation
import info.sanaebadi.stackoverflowproject.util.loadUrl
import info.sanaebadi.stackoverflowproject.util.onItemClickListener

class UserListAdapter (
    val listener: onItemClickListener,
    private val users: MutableList<UserPresentation>
) : RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {


    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) =
        holder.bind(users[position])

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding =
            ListItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)

    }

    fun addUsers(newUsers: List<UserPresentation>) {
        users.addAll(newUsers)
        notifyDataSetChanged()
    }

    fun clearUsers() {
        users.clear()
    }

    open class UserViewHolder(private val binding: ListItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("NewApi", "SetTextI18n")
        fun bind(user: UserPresentation) =
            with(itemView) {

                binding.textUserName.text = user.displayName
                binding.textUserReputation.text = "${user.reputation} points"
                binding.imageUserAvatar.loadUrl(user.profileImage)


                setOnClickListener {
                    listener.onItemClick(it)
                }


            }
    }


}
