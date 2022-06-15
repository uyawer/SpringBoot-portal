package com.uyawer.portal.repository;

import com.uyawer.portal.model.entity.RoleEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<RoleEntity, Long> {

}
