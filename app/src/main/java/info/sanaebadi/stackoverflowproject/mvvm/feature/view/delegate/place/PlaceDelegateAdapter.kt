package info.sanaebadi.stackoverflowproject.mvvm.feature.view.delegate.place

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import info.sanaebadi.domain.model.base.ViewType
import info.sanaebadi.domain.model.place.places.PlaceItem
import info.sanaebadi.domain.model.place.promoted.PromotedItem
import info.sanaebadi.placeapp.databinding.PlaceItemBinding
import info.sanaebadi.placeapp.mvvm.base.ViewTypeDelegateAdapter
import info.sanaebadi.placeapp.util.loadCircleImage


class PlaceDelegateAdapter(
    private val listener: (PlaceItem, PromotedItem) -> Unit,
    private val getFavView: (View, Int) -> Unit
) :
    ViewTypeDelegateAdapter {


    override fun onCreateViewHolder(parent: ViewGroup) =
        PlaceViewHolder(
            PlaceItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as PlaceViewHolder
        holder.bind(item as PlaceItem, listener, getFavView)
    }

    class PlaceViewHolder(private val placeItemBinding: PlaceItemBinding) :
        RecyclerView.ViewHolder(placeItemBinding.root) {
        @SuppressLint("NewApi")
        fun bind(
            place: PlaceItem, listener: (PlaceItem, PromotedItem) -> Unit,
            getFavView: (View, Int) -> Unit

        ) = with(itemView) {
            placeItemBinding.imagePlaceIcon.loadCircleImage(place.iconUrl!!)
            placeItemBinding.textPlaceTitle.text = place.title
            placeItemBinding.textPlaceShortAddress.text = place.shortAddress



            setOnClickListener {
                listener(
                    place,
                    PromotedItem(
                        place.score,
                        place.shortAddress,
                        place.bannerUrl,
                        place.description,
                        place.id,
                        place.iconUrl,
                        place.title
                    )
                )
            }


            getFavView(placeItemBinding.textFavorite, adapterPosition)

        }



    }


}
