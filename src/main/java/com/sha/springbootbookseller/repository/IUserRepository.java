package com.sha.springbootbookseller.repository;

import com.sha.springbootbookseller.model.Role;
import com.sha.springbootbookseller.model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
//  kaydetme gibi guncelleme gibi id ile nesneleri bulma gibi temel CRUD veri tabanı islemşlerini otomatik olarak  gerceklewstirir
//  ayrıca JPARepositoory metod adlarından otomatik olarak sorgular olusturulmasını saglar
//  <Class> findBy + fieldName ...
//  User findByName(String name)
//  User findByCreateTimeAfter(LocalDate threshold)

//  @Query ("Select c.from Class where c.fieldNAme=:param")
//  <Class> findByQueryAnnotation(@Param String params..);

//  @Modifying _>  bu annotasyonu   update yada delete queryleri için ekliyoruz
//  @Query("Update or Delete ... where c.fieldName=:param")
//  <Class>updateOrDelete(@PAram String params...);
public interface IUserRepository extends JpaRepository<User,Long> {


    Optional<User> findByUsername(String username);

//  HQL sql sorgusunda table hql de entity  kullanılıyor
    @Modifying  // modifiye eden bir sorgu oldugu için
   @Query("update User set role = :role where username = :username")
    void updateUserRole(@Param("username")String username, @Param("role") Role role);


}
