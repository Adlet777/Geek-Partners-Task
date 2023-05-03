package kz.adilet.tleubay.code.generator.repository;

import kz.adilet.tleubay.code.generator.entity.CodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CodeRepository extends JpaRepository<CodeEntity, Long> {
    Optional<CodeEntity> findTopByOrderByCreatedAtDesc();
}
