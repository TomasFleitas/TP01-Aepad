package utn.frsf.mst.aepad.tp01.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import utn.frsf.mst.aepad.tp01.MODELO.Cliente;

public interface DetallePedidoRepository extends JpaRepository<Cliente, Integer> {
}
