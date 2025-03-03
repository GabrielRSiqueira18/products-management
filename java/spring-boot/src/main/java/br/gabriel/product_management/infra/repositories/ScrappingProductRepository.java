package br.gabriel.product_management.infra.repositories;

import br.gabriel.product_management.infra.models.ScrappingProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScrappingProductRepository extends JpaRepository<ScrappingProductModel, Integer> {
}
