package org.example.chipmongdemotest.repository;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.chipmongdemotest.model.Province;
import java.util.List;

@Mapper
public interface ProvinceMapper {
    @Select("SELECT * FROM provinces ORDER BY name")
    List<Province> findAll();

    @Select("SELECT * FROM provinces WHERE id = #{id}")
    Province findById(Long id);
}