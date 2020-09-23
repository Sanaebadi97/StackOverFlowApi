package info.sanaebadi.stackoverflowproject.mvvm.feature.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.android.support.DaggerFragment
import info.sanaebadi.domain.model.user.User
import info.sanaebadi.stackoverflowproject.R
import info.sanaebadi.stackoverflowproject.databinding.FragmentUserListBinding
import info.sanaebadi.stackoverflowproject.mvvm.feature.view.adapter.UserListAdapter
import info.sanaebadi.stackoverflowproject.mvvm.feature.view.viewModel.UserViewModel
import info.sanaebadi.stackoverflowproject.mvvm.feature.view.viewModel.base.UserListView
import kotlinx.android.synthetic.main.fragment_user_list.*
import javax.inject.Inject

class UserListFragment : DaggerFragment(), UserListView {

    companion object {
        const val TAG: String = "UserListFragment"
    }

    private lateinit var layoutManager: LinearLayoutManager

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private var binding: FragmentUserListBinding? = null

    private val viewModel: UserViewModel by lazy {
        ViewModelProvider(requireActivity(), viewModelFactory).get(UserViewModel::class.java)
    }


    private val adapter by lazy {
        val userList = mutableListOf<User>()
        UserListAdapter(userList) { user, view ->
           // openDetailFragment(user, view)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getUserList(1)
        initAdapter()
    }


    private fun initAdapter() {
        layoutManager = LinearLayoutManager(context)
        binding?.recyclerUser?.layoutManager = layoutManager
        binding?.recyclerUser?.adapter = adapter

    }

    private fun setUpRecyclerView() {
        val layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding?.recyclerUser?.layoutManager = layoutManager
        binding?.recyclerUser?.setHasFixedSize(true)

    }

    override fun showLoading() {
        binding?.swipeRefreshLayout?.isRefreshing = true
    }

    override fun hideLoading() {
        binding?.swipeRefreshLayout?.isRefreshing = false
    }

    override fun addUsersToList(users: List<User>) {
        val adapter = binding?.recyclerUser?.adapter as UserListAdapter
        adapter.addUsers(users)
    }

    override fun showEmptyListError() {
        binding?.errorView?.visibility = View.VISIBLE
    }

    override fun hideEmptyListError() {
        binding?.errorView?.visibility = View.GONE
    }

    override fun showToastError() =
        Toast.makeText(context, getString(R.string.error_fetching_data), Toast.LENGTH_SHORT).show()

    override fun clearList() {
        adapter.clearUsers()
    }
}