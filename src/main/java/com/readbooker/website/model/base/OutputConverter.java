package com.readbooker.website.model.base;
import com.readbooker.website.util.BeanUtils;
import org.springframework.lang.NonNull;

/**
 * Converter interface for output DTO.
 *
 * <b>The implementation type must be equal to DTO type</b>
 *
 * @param <VO>    the implementation class type
 * @param <Entity> doamin type
 * @author johnniang
 */
public interface OutputConverter<VO extends OutputConverter<VO, Entity>, Entity> {

    /**
     * Convert from domain.(shallow)
     *
     * @param entity domain data
     * @return converted dto data
     */
    @SuppressWarnings("unchecked")
    @NonNull
    default <T extends VO> T convertFrom(@NonNull Entity entity) {

        BeanUtils.updateProperties(entity, this);

        return (T) this;
    }
}
