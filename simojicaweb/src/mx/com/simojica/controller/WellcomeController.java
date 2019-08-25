package mx.com.simojica.controller;

import javax.transaction.SystemException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.com.simojica.domain.Expediente;
import mx.com.simojica.exceptions.ExpedientesException;
import mx.com.simojica.service.ExpedienteService;

@RestController
@RequestMapping("/hello")
public class WellcomeController {

	@Autowired
	private ExpedienteService expedienteService;
	
	@RequestMapping(method = RequestMethod.GET)
    public String renderWelcome() {
		System.out.println("Guardando el expediente");
		try {
			Expediente expediente = new Expediente();
			expedienteService.guardarExpediente(expediente);
		} catch (ExpedientesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "welcome";
    }
}


