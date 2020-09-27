package info.sanaebadi.stackoverflowproject.model.user

import info.sanaebadi.stackoverflowproject.model.base.PresentationModel


data class OwnerPresentation(var userId: Long) : PresentationModel {

    constructor() : this(-1)
}