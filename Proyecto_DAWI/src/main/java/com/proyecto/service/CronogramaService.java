package com.proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.dao.CronogramaRepository;
import com.proyecto.dao.InspeccionesCronogramaRepository;
import com.proyecto.entity.Cronograma;
import com.proyecto.entity.InspeccionesCronograma;
import com.proyecto.entity.InspeccionesCronogramaPK;



@Service
public class CronogramaService {

	@Autowired
	private CronogramaRepository repoCronograma;
	
	@Autowired
	private InspeccionesCronogramaRepository repoInspeccionesCronograma;
	
	@Transactional
	public void registrarCronograma(Cronograma obj) {
		try {
			//grabar Requerimiento
			repoCronograma.save(obj);
			//bucle
			for(InspeccionesCronograma det:obj.getListaInspeccionesCronograma()) {
				//crear objeto de la clase 	BienRequerimientoPK
				InspeccionesCronogramaPK id=new InspeccionesCronogramaPK();
				//setear
				id.setId_crono(obj.getCodigo());
				id.setId_insp(det.getInspecciones().getCodigo());
				//setear PK
				det.setPk(id);
				//grabar detalle Requerimiento
				repoInspeccionesCronograma.save(det);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
