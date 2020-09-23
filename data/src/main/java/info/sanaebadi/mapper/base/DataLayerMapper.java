package info.sanaebadi.mapper.base;


import info.sanaebadi.data.entity.base.BaseEntity;
import info.sanaebadi.domain.model.base.BaseDomainModel;

public interface DataLayerMapper<E extends BaseEntity, D extends BaseDomainModel> {

    D toDomain(E e);

    E toEntity(D d);

}
