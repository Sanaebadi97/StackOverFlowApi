package info.sanaebadi.stackoverflowproject.mapper.base;


import info.sanaebadi.domain.model.base.BaseDomainModel;
import info.sanaebadi.stackoverflowproject.model.base.PresentationModel;

public interface PresentationLayerMapper<P extends PresentationModel, D extends BaseDomainModel> {

    D toDomain(P p);

    P toPresentation(D d);

}

