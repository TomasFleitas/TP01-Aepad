package utn.frsf.mst.aepad.tp01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utn.frsf.mst.aepad.tp01.MODELO.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String> {

    /*
    EJEMPLO FIRMAS

    public List<Tarea> findByProyectoIdAndFinalizada(Integer idProyecto,Boolean finalizada);

	public List<Tarea> findByProyectoId(Integer idProyecto);

    * */

}
