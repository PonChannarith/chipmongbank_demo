package org.example.chipmongdemotest.repository;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.chipmongdemotest.model.District;
import java.util.List;

@Mapper
public interface DistrictMapper {
    @Select("SELECT * FROM districts WHERE amphur_id = #{amphurId} ORDER BY name")
    List<District> findByAmphurId(Long amphurId);

    @Select("SELECT * FROM districts WHERE id = #{id}")
    District findById(Long id);
}