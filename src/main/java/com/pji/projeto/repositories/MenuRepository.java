package com.pji.projeto.repositories;

import com.pji.projeto.models.Bebida;
import com.pji.projeto.models.Lanche;
import com.pji.projeto.models.Menu;
import com.pji.projeto.models.Porcao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long>{
    @Query(value = "SELECT m, l from Menu m, Lanche l where m.id=:id and m.id=l.id")
    public Optional<Lanche> selectByIdLanche(@Param("id")Long id);
    @Query(value = "SELECT m, b from Menu m, Bebida b where m.id=:id and m.id=b.id")
    public Optional<Bebida> selectByIdBebida(@Param("id")Long id);
    @Query(value = "SELECT m, p from Menu m, Porcao p where m.id=:id and m.id=p.id")
    public Optional<Porcao> selectByIdPorcao(@Param("id")Long id);
    @Query(value = "SELECT m, l from Menu m, Lanche l where m.id=l.id")
    List<Lanche> findAllLanches();
    @Query(value = "SELECT m, b from Menu m, Bebida b where m.id=b.id")
    List<Bebida> findAllBebidas();
    @Query(value = "SELECT m, p from Menu m, Porcao p where m.id=p.id")
    List<Porcao> findAllPorcoes();

}
    

