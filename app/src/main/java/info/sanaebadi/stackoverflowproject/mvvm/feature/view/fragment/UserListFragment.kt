package info.sanaebadi.stackoverflowproject.mvvm.feature.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.android.support.DaggerFragment
import info.sanaebadi.stackoverflowproject.R
import info.sanaebadi.stackoverflowproject.databinding.FragmentUserListBinding
import info.sanaebadi.stackoverflowproject.model.user.UserPresentation
import info.sanaebadi.stackoverflowproject.mvvm.feature.view.MainActivity
import info.sanaebadi.stackoverflowproject.mvvm.feature.view.adapter.UserListAdapter
import info.sanaebadi.stackoverflowproject.mvvm.feature.view.viewModel.UserViewModel
import info.sanaebadi.stackoverflowproject.mvvm.feature.view.viewModel.base.UserListView
import info.sanaebadi.stackoverflowproject.util.isOnline
import info.sanaebadi.stackoverflowproject.util.mOnItemClickListener
import javax.inject.Inject

class UserListFragment : DaggerFragment(), UserListView, mOnItemClickListener {

    private lateinit var adapter: UserListAdapter


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

        if (requireContext().isOnline()) viewModel.getUserList(1) else showError(getString(R.string.check_internet))

        setUpObserver()
    }

    private fun setUpRecyclerview() {
        val layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding?.recyclerUser?.layoutManager = layoutManager
        binding?.recyclerUser?.setHasFixedSize(true)

//        binding?.recyclerUser?.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                super.onScrolled(recyclerView, dx, dy)
//
//                val lastVisibleItemPosition =
//                    layoutManager.findFirstVisibleItemPosition() + layoutManager.childCount
//                val totalItemCount = layoutManager.itemCount
//                viewModel.onScrollChanged(lastVisibleItemPosition, totalItemCount)
//            }
//        })
    }

    private fun initAdapter(data: MutableList<UserPresentation>) {
        setUpRecyclerview()
        adapter = UserListAdapter(this, data)
        binding?.recyclerUser?.adapter = adapter


    }

    private fun setUpObserver() {
        viewModel.userList.observe(viewLifecycleOwner, Observer { mutableViewModelModel ->

            when {
                mutableViewModelModel.isLoading() -> {
                    showLoading()
                    hideEmptyListError()
                }
                mutableViewModelModel.getThrowable() != null -> {
                    hideLoading()
                    hideEmptyListError()
                    mutableViewModelModel.getThrowable()!!.message?.let {
                        showToastError()
                    }
                }
                else -> {
                    hideLoading()
                    hideEmptyListError()
                    val data = mutableViewModelModel.getData()


                    if (data?.items?.isNotEmpty()!!) {
                        initAdapter(data.items)
                    } else {
                        showEmptyListError()
                    }
                }
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }


    override fun showLoading() {
        binding?.swipeRefreshLayout?.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding?.swipeRefreshLayout?.visibility = View.GONE
    }

    override fun addUsersToList(users: List<UserPresentation>) {
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

    private fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }


    override fun onItemClick(userViewModel: UserPresentation, view: View) {
        openDetailFragment(userViewModel, view)
    }

    private fun openDetailFragment(user: UserPresentation, transitioningView: View) {
        val detailsFragment = DetailsFragment.newInstance(user)
        (activity as MainActivity).addDetailsFragmentWithTransition(
            detailsFragment,
            transitioningView
        )
    }

}