package info.sanaebadi.stackoverflowproject.mvvm.feature.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.android.support.DaggerFragment
import info.sanaebadi.stackoverflowproject.databinding.FragmentUserListBinding
import info.sanaebadi.stackoverflowproject.mvvm.feature.view.viewModel.UserViewModel
import info.sanaebadi.stackoverflowproject.mvvm.feature.view.viewModel.base.UserListView
import javax.inject.Inject

class UserListFragment : DaggerFragment(), UserListView {

    companion object {
        const val TAG: String = "UserListFragment"
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private var binding: FragmentUserListBinding? = null

    private val viewModel: UserViewModel by lazy {
        ViewModelProvider(requireActivity(), viewModelFactory).get(UserViewModel::class.java)
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
    }


    private fun setUpRecyclerView() {
        val layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding?.recyclerUser?.layoutManager = layoutManager
        binding?.recyclerUser?.setHasFixedSize(true)

    }

    override fun showLoading() {
        TODO("Not yet implemented")
    }

    override fun hideLoading() {
        TODO("Not yet implemented")
    }

    override fun addUsersToList(users: List<UserViewModel>) {
        TODO("Not yet implemented")
    }

    override fun showEmptyListError() {
        TODO("Not yet implemented")
    }

    override fun hideEmptyListError() {
        TODO("Not yet implemented")
    }

    override fun showToastError() {
        TODO("Not yet implemented")
    }

    override fun clearList() {
        TODO("Not yet implemented")
    }
}