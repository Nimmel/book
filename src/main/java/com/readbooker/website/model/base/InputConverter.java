package com.readbooker.website.model.base;

import com.readbooker.website.util.BeanUtils;
import com.readbooker.website.util.ReflectionUtils;
import java.lang.reflect.ParameterizedType;
import java.util.Objects;
import org.springframework.lang.Nullable;

/**
 * Converter interface for input DTO.
 *
 * @author johnniang
 */
public interface InputConverter<Entity> {

    /**
     * Convert to Entity.(shallow)
     *
     * @return new Entity with same value(not null)
     */
    @SuppressWarnings("unchecked")
    default Entity convertTo() {
        // Get parameterized type
        ParameterizedType currentType = parameterizedType();

        // Assert not equal
        Objects.requireNonNull(currentType, "Cannot fetch actual type because parameterized type is null");

        Class<Entity> EntityClass = (Class<Entity>) currentType.getActualTypeArguments()[0];

        return BeanUtils.transformFrom(this, EntityClass);
    }

    /**
     * Update a Entity by dto.(shallow)
     *
     * @param Entity updated Entity
     */
    default void update(Entity Entity) {
        BeanUtils.updateProperties(this, Entity);
    }

    /**
     * Get parameterized type.
     *
     * @return parameterized type or null
     */
    @Nullable
    default ParameterizedType parameterizedType() {
        return ReflectionUtils.getParameterizedType(InputConverter.class, this.getClass());
    }
}

