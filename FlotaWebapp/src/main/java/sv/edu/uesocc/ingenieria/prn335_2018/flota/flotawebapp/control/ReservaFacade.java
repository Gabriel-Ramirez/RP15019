/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2018.flota.flotawebapp.control;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.TipoVehiculo;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.TipoVehiculo_;

/**
 *
 * @author gabriel
 */
@Stateless
@LocalBean
public class ReservaFacade implements Serializable{
    
    @PersistenceContext
    EntityManager em;
    
   
    public Map<Integer,Object[]> findTopClientePorAnioAprobado(int anio){
        Map<Integer,Object[]> nuevo = new HashMap<>();
        List<sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.Reserva> reservas = new ArrayList<>();
        
        Integer mes;
        Object[] datos;
       em.createQuery("SELECT r.cliente, r.fechaReserva, COUNT(r.cliente) FROM Reserva AS r JOIN r.estadoReservaList AS er JOIN er.idTipoEstadoReserva AS edr WHERE edr.indicaAprobacion = 1").getResultList();
      
        return nuevo;
    
           
     
    }
}
