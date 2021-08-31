package com.backend.assignmentapp.daos;

import com.backend.assignmentapp.entities.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface RoleDao extends JpaRepository<Role, Long> {
    @Query(value = "select * from role where id <> :id and name = :name", nativeQuery = true)
    Optional<Role> findDuplicateRole(@Param("id") Long id, @Param("name") String name);

    @Query(value = "select * from role where name = :name", nativeQuery = true)
    Optional<Role> findDuplicateRoleName(@Param(("name")) String name);

    @Modifying
    @Transactional
    @Query(value = "delete from role where id in ?1", nativeQuery = true)
    void deleteMultiRoleByIds(List<Long> ids);

    Page<Role> findByName(String name, Pageable pageable);

}
