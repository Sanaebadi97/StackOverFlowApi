package info.sanaebadi.stackoverflowproject.mvvm.feature.view.adapter

import android.view.ViewGroup
import androidx.collection.SparseArrayCompat
import androidx.recyclerview.widget.RecyclerView
import info.sanaebadi.domain.model.base.ViewType
import info.sanaebadi.stackoverflowproject.model.base.AdapterConstants
import info.sanaebadi.stackoverflowproject.model.user.Heading
import info.sanaebadi.stackoverflowproject.mvvm.feature.view.delegate.*
import info.sanaebadi.stackoverflowproject.mvvm.feature.view.delegate.base.ViewTypeDelegateAdapter

class DetailsAdapter(listener: (String) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: MutableList<ViewType> = ArrayList()
    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()

    private val loadingItem = object : ViewType {
        override fun getViewType() = AdapterConstants.LOADING
    }

    init {
        delegateAdapters.put(AdapterConstants.USER_DETAILS, UserDetailsDelegateAdapter())
        delegateAdapters.put(AdapterConstants.HEADING, HeadingDelegateAdapter())
        delegateAdapters.put(AdapterConstants.QUESTION, QuestionDelegateAdapter(listener))
        delegateAdapters.put(AdapterConstants.ANSWER, AnswerDelegateAdapter(listener))
        delegateAdapters.put(AdapterConstants.LOADING, LoadingDelegateAdapter())
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        delegateAdapters[viewType]!!.onCreateViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        delegateAdapters[getItemViewType(position)]!!.onBindViewHolder(holder, items[position])

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return items[position].getViewType()
    }

    private fun addItems(newItems: List<ViewType>) {
        items.addAll(newItems)
    }

    fun addItem(item: ViewType) {
        items.add(item)
    }

    fun addLoadingItem() {
        items.add(loadingItem)
    }

    fun removeLoadingItem() {
        items.remove(loadingItem)
    }

    fun removeNonUserItems() {
        items.removeAll { it.getViewType() != AdapterConstants.USER_DETAILS }
    }

    fun addItemsWithHeading(items: List<ViewType>, headingTitle: String) {
        if (!items.isEmpty()) {
            addItem(Heading(headingTitle))
            addItems(items)
        }
    }
}