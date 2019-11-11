package mx.com.simojica.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.com.simojica.domain.Expediente;
import mx.com.simojica.exceptions.ExpedientesException;
import mx.com.simojica.service.ExpedienteService;

@RestController
@RequestMapping("/expediente")
public class WellcomeController {

	private static final Logger LOGGER = LogManager.getLogger(WellcomeController.class);
	
	@Autowired
	private ExpedienteService expedienteService;
	

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(method = RequestMethod.GET)
    public Expediente renderExpediente() {
		LOGGER.info("Guardando el expediente");
		Expediente expediente = new Expediente();
		//try {
			//expedienteService.getExpediente();
			//expedienteService.guardarExpediente(expediente);
		//} catch (ExpedientesException e) {
			
		//	e.printStackTrace();
		//}
		expediente.setIdExpediente(1);
		expediente.setName("Jesus");
		expediente.setApellidoPaterno("TestHolaMundoApellido");
        return expediente;

    }
}


