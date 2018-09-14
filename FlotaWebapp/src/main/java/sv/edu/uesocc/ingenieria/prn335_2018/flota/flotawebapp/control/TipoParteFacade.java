/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2018.flota.flotawebapp.control;

import java.io.Serializable;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.TipoParte;

/**
 *
 * @author gabriel
 */
@Stateless
@LocalBean
public class TipoParteFacade implements Serializable{
    
    @PersistenceContext
    public EntityManager em; 
    
    public TipoParte findMasUsadaPorIdMarca(final Integer idMarca) {
        TipoParte tipoParte = null;
        TipoParte maximo = null;
                
        String query = "SELECT m.nombre, tpr.nombre, COUNT(mpl.idModelo) AS ctip FROM Marca AS m JOIN m.modeloList AS ml JOIN ml.modeloParteList AS mpl JOIN mpl.idParte AS prt JOIN prt.idSubTipoParte.idTipoParte AS tpr WHERE m.idMarca = " + idMarca + "";

        if (em != null && idMarca > 0) {
            tipoParte = (TipoParte) em.createQuery(query).getResultList();
        } else if (em == null) {
            throw new java.lang.IllegalStateException("Entity Manager nulo");
        } else {
            throw new IllegalArgumentException("Valor no valido");
        }

        return tipoParte;
    }
}
