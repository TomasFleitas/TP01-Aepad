package utn.frsf.mst.aepad.tp01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utn.frsf.mst.aepad.tp01.MODELO.Producto;

public interface ProductoRepository extends JpaRepository<Producto,Integer> {
}
