package info.sanaebadi.stackoverflowproject.mapper

import info.sanaebadi.stackoverflowproject.mapper.base.PresentationLayerMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserPresentationMapper @Inject constructor():PresentationLayerMapper<User>