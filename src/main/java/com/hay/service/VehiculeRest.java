package com.hay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hay.dao.AutoRepo;
import com.hay.dao.VehiculeRepo;
import com.hay.entities.Auto;
import com.hay.entities.Vehicule;

@RestController
@CrossOrigin("*")
public class VehiculeRest {

	@Autowired
	private VehiculeRepo repoVehicule;
	
	@Autowired
	private AutoRepo repoRep;
	
	
	@RequestMapping(value="/Vehicule/ajouter/{idAuto}",method=RequestMethod.POST)
	public Vehicule saveVehiculeAuto(@RequestBody Vehicule service,@PathVariable("idAuto") long idAuto) {
		Auto auto =(Auto)repoRep.findById(idAuto).get();
		service.setAutoContrat(auto);
		return  repoVehicule.save(service);
	}
	
	
	@RequestMapping(value = "/Vehicule/modifier/{id}", method = RequestMethod.PUT)
	Vehicule modifierVehicule(@PathVariable("id") long idVehicule,@RequestBody Vehicule vehicule) {
		Vehicule newVehicule = (Vehicule)repoVehicule.findById(idVehicule).get();
		newVehicule.setDatePremierMiseService(vehicule.getDatePremierMiseService());
		newVehicule.setMarque(vehicule.getMarque());
		newVehicule.setMatriculation(vehicule.getMatriculation());
		newVehicule.setNbrChevaux(vehicule.getNbrChevaux());
		newVehicule.setNbrPlace(vehicule.getNbrPlace());
		newVehicule.setTypeMoteur(vehicule.getTypeMoteur());
		newVehicule.setUsageVehicule(vehicule.getUsageVehicule());		
		return repoVehicule.save(newVehicule);
	}

	@RequestMapping(value = "/Vehicule/delete/{id}", method = RequestMethod.DELETE)
	public Long deleteVehicue(@PathVariable("id") long idVehicule) {
		 repoVehicule.deleteById(idVehicule);
		 return idVehicule;
	}
	
	
	
	
	
}
