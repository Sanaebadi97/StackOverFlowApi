package info.sanaebadi.stackoverflowproject.model.user

import info.sanaebadi.domain.model.base.ViewType
import info.sanaebadi.stackoverflowproject.model.base.AdapterConstants

data class Heading(val title: String) : ViewType {
    override fun getViewType() = AdapterConstants.HEADING
}