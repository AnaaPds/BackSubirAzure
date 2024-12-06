package academia.demo.academia.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import academia.demo.academia.model.academiaModel;

@Repository
public interface academiaRepository extends JpaRepository<academiaModel, UUID> {
    // Você pode adicionar métodos customizados aqui, se necessário.
}
