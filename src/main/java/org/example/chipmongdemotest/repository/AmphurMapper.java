package org.example.chipmongdemotest.repository;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.chipmongdemotest.model.Amphur;
import java.util.List;

@Mapper
public interface AmphurMapper {
    @Select("SELECT * FROM amphurs WHERE province_id = #{provinceId} ORDER BY name")
    List<Amphur> findByProvinceId(Long provinceId);

    @Select("SELECT * FROM amphurs WHERE id = #{id}")
    Amphur findById(Long id);
}