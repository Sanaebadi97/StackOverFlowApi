package info.sanaebadi.stackoverflowproject.mvvm.feature.view.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerFragment
import info.sanaebadi.domain.model.UserDetailsModel
import info.sanaebadi.domain.model.user.UserListModel
import info.sanaebadi.stackoverflowproject.databinding.FragmentDetailsBinding
import info.sanaebadi.stackoverflowproject.model.user.UserPresentation
import info.sanaebadi.stackoverflowproject.mvvm.feature.view.adapter.DetailsAdapter
import info.sanaebadi.stackoverflowproject.mvvm.feature.view.viewModel.DetailsViewModel
import info.sanaebadi.stackoverflowproject.mvvm.feature.view.viewModel.UserViewModel
import info.sanaebadi.stackoverflowproject.mvvm.feature.view.viewModel.base.DetailView
import kotlinx.android.synthetic.main.fragment_details.*
import javax.inject.Inject

class DetailsFragment : DaggerFragment(), DetailView {

    companion object {
        const val TAG: String = "DetailsFragment"
    }

    private var binding: FragmentDetailsBinding? = null
    private var navController: NavController? = null

    @Inject
    lateinit var viewModel: DetailsViewModel

    private val detailsAdapter by lazy {
        DetailsAdapter { link ->
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(browserIntent)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.attachView(this)

        initAdapter()
        processArguments()
    }

    override fun onDestroyView() {
        viewModel.detachView()
        super.onDestroyView()
    }

    private fun initAdapter() {
        binding?.recyclerUserDetails?.layoutManager = LinearLayoutManager(context)
        binding?.recyclerUserDetails?.adapter = detailsAdapter
    }

    private fun processArguments() {
        val user = arguments?.getParcelable<UserPresentation>("user")

        if (user != null) {
            detailsAdapter.addItem(user)
            detailsAdapter.notifyDataSetChanged()
            viewModel.getDetails(user.userId)

            swipeRefreshLayout.setOnRefreshListener {
                viewModel.getDetails(user.userId)
            }
        }
    }


    override fun showDetails(details: UserDetailsModel) {
        with(detailsAdapter) {
            removeNonUserItems()
            addItemsWithHeading(details.questions, "Top questions by user")
            addItemsWithHeading(details.answers, "Top answers by user")
            addItemsWithHeading(details.favorites, "Favorited by user")
            notifyDataSetChanged()
        }
    }

    override fun showError(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        detailsAdapter.addLoadingItem()
    }

    override fun hideLoading() {
        detailsAdapter.removeLoadingItem()
        swipeRefreshLayout.isRefreshing = false
    }

}