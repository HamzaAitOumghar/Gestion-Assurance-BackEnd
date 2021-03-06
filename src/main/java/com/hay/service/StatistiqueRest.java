package com.hay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hay.dao.AutoRepo;
import com.hay.dao.ClientRepo;
import com.hay.dao.HabitationRepo;
import com.hay.dao.SanteRepo;

@RestController
@CrossOrigin("*")
public class StatistiqueRest {

	@Autowired
	private ClientRepo repoClient;
	
	@Autowired
	private AutoRepo repoAuto;
	
	@Autowired
    private SanteRepo repoSante;
	
	@Autowired
   private HabitationRepo repoHabitation;
	
	
	@RequestMapping(value="/statistique/statusClient",method=RequestMethod.GET)
	public Object[]  getAllContratAuto(){
		return repoClient.getStatusClient();
	}
	@RequestMapping(value="/statistique/statesContrat",method=RequestMethod.GET)
	public long[] contratState() {
		 long[] states= {0,0,0,0} ;
		states[0]=this.repoClient.count();
		states[1]=this.repoAuto.count();
		states[2]=this.repoHabitation.count();
		states[3]=this.repoSante.count();
		return states;
	}
	
	@RequestMapping(value="/statistique/evolutionContratAuto",method=RequestMethod.GET)
	public Object[] contratAutoEvolutions() {
		return repoAuto.statContrat();
	}
	@RequestMapping(value="/statistique/evolutionContratHabitation",method=RequestMethod.GET)
	public Object[] contratHabitationEvolutions() {
		return repoHabitation.getStatHabitation();
	}
	@RequestMapping(value="/statistique/evolutionContratSante",method=RequestMethod.GET)
	public Object[] contratSanteEvolutions() {
		return repoSante.getStatSante();
	}
	@RequestMapping(value="/statistique/budjetContratAuto",method=RequestMethod.GET)
	public Object[] contratAutoBudjet() {
		return repoAuto.statMontantContrat();
	}
	@RequestMapping(value="/statistique/budjetContratHabitation",method=RequestMethod.GET)
	public Object[] contratHabitationBudjet() {
		return repoHabitation.getBudgetHabitation();
	}
	@RequestMapping(value="/statistique/budjetContratSante",method=RequestMethod.GET)
	public Object[] contratSanteBudjet() {
		return repoSante.getBudgetSante();
	}
	
}
