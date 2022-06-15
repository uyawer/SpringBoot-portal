package com.uyawer.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uyawer.portal.model.entity.RoleEntity;

@Repository
public interface RolesRepository extends JpaRepository<RoleEntity, Long> {

}
