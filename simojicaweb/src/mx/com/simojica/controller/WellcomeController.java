package mx.com.simojica.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.com.simojica.domain.Expediente;
import mx.com.simojica.exceptions.ExpedientesException;
import mx.com.simojica.service.ExpedienteService;

@RestController
@RequestMapping("/hello")
public class WellcomeController {

	private static final Logger LOGGER = LogManager.getLogger(WellcomeController.class);
	
	@Autowired
	private ExpedienteService expedienteService;
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded;charset=UTF-16", produces = "application/x-www-form-urlencoded;charset=UTF-16")
    public String renderWelcome(@RequestParam(name = "imagenComprimida") String imagenComprimida) {
		LOGGER.info("Guardando el expediente");
		
		LOGGER.info("imagenComprimida : {}",imagenComprimida);
//		try {
//			Expediente expediente = new Expediente();
//			expedienteService.guardarExpediente(expediente);
//		} catch (ExpedientesException e) {
//			
//			e.printStackTrace();
//		}
        return "welcome";
    }
}


