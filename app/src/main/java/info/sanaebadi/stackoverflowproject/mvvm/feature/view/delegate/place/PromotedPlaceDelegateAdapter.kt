package info.sanaebadi.stackoverflowproject.mvvm.feature.view.delegate.place

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import info.sanaebadi.domain.model.base.ViewType
import info.sanaebadi.domain.model.place.places.PlaceItem
import info.sanaebadi.domain.model.place.promoted.PromotedItem
import info.sanaebadi.placeapp.databinding.PromotedItemBinding
import info.sanaebadi.placeapp.mvvm.base.ViewTypeDelegateAdapter
import info.sanaebadi.placeapp.util.loadCircleImage

class PromotedPlaceDelegateAdapter(
    private val listener: (PlaceItem, PromotedItem) -> Unit,

) :
    ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup) =
        PromotedPlaceViewHolder(
            PromotedItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as PromotedPlaceViewHolder
        holder.bind(item as PromotedItem, listener)
    }

    class PromotedPlaceViewHolder(private val promotedItemBinding: PromotedItemBinding) :
        RecyclerView.ViewHolder(promotedItemBinding.root) {
        @SuppressLint("NewApi")
        fun bind(promoted: PromotedItem, listener: (PlaceItem, PromotedItem) -> Unit ) =
            with(itemView) {
                promotedItemBinding.imagePlaceIcon.loadCircleImage(promoted.iconUrl!!)
                promotedItemBinding.textPlaceTitle.text = promoted.title
                promotedItemBinding.textPlaceShortAddress.text = promoted.shortAddress

                setOnClickListener {
                    listener(
                        PlaceItem(
                            promoted.score,
                            promoted.shortAddress,
                            promoted.bannerUrl,
                            promoted.description,
                            promoted.id,
                            promoted.iconUrl,
                            promoted.title
                        ), promoted
                    )
                }

            }
    }
}
