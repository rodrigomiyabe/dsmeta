package com.devsuperior.dsmeta.repository;

import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface SaleRepository extends JpaRepository<Sale,Long> {

    @Query(value = "select obj from Sale obj where obj.date between :min and :max order by obj.amount desc ")
    Page<Sale> findSale(LocalDate min, LocalDate max, Pageable pageable);

}
