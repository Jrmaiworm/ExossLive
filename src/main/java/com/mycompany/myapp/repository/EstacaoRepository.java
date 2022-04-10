package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Estacao;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Estacao entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EstacaoRepository extends JpaRepository<Estacao, Long> {}
