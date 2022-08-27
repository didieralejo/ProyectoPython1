package com.toku.prestamos_sga.persistence.mapper;

import com.toku.prestamos_sga.domain.Category;
import com.toku.prestamos_sga.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * Indicamos es un mapeador @Mapper
 */
@Mapper(componentModel = "spring")
public interface CategoryMapper {
    /**
     * Metodo que Mappea una Categoria a Category
     * @Mappings le indicamos que va a mapear
     * @Mapping(source = "campo origen", target = "campo destino")
     * Ejemplo
     * @Mapping(source = "idCategoria", target = "categoryId")
     * @param categoria
     * @return
     */
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active")
    })
    Category toCategory(Categoria categoria);

    //Metodo que Mappea una Category a Categoria
    //@InheritInverseConfiguration indica que el mapeo es el inverso del metodo anterior
    //Categoria (target) espera un atributo productos que no esta en el origen Category, se debe ignorar
    //@Mapping(target = "productos", ignore = true)
    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria (Category category);
}
