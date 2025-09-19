package org.example.chipmongdemotest.repository;

import org.apache.ibatis.annotations.*;
import org.example.chipmongdemotest.model.Contact;
import java.util.List;

@Mapper
public interface ContactMapper {

    @Select("SELECT * FROM contacts")
    List<Contact> findAll();

    @Select("SELECT * FROM contacts WHERE id = #{id}")
    Contact findById(Long id);

    @Insert("INSERT INTO contacts(address1, district, amphur, province, postal_code1, telephone, fax, " +
            "address2, city, state_province, postal_code2, country, contact_person, email) " +
            "VALUES(#{address1}, #{district}, #{amphur}, #{province}, #{postalCode1}, #{telephone}, #{fax}, " +
            "#{address2}, #{city}, #{stateProvince}, #{postalCode2}, #{country}, #{contactPerson}, #{email})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Contact contact);

    @Update("UPDATE contacts SET address1=#{address1}, district=#{district}, amphur=#{amphur}, province=#{province}, " +
            "postal_code1=#{postalCode1}, telephone=#{telephone}, fax=#{fax}, " +
            "address2=#{address2}, city=#{city}, state_province=#{stateProvince}, postal_code2=#{postalCode2}, " +
            "country=#{country}, contact_person=#{contactPerson}, email=#{email} " +
            "WHERE id=#{id}")
    void update(Contact contact);

    @Delete("DELETE FROM contacts WHERE id=#{id}")
    void delete(Long id);
}
