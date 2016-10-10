package com.proxibanquev4trio.presentation;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import com.proxibanquev4trio.domaine.Conseiller;
import com.proxibanquev4trio.domaine.Gerant;
import com.proxibanquev4trio.domaine.Virement;
import com.proxibanquev4trio.services.IConseillerService;
import com.proxibanquev4trio.services.IVirementService;

@ManagedBean(name = "transactionBean")
@SessionScoped
public class TransactionBean implements Serializable {
	
		private static final long serialVersionUID = 1L;

		private Gerant gerant;
	
		private boolean loggedIn;
		
		private List<Virement> liste;

		private LineChartModel lineModel1;
		
		@Inject
		private IVirementService virementService;

		@ManagedProperty(value = "#{navigateBean}")
		@Inject
		private NavigateBean navigateBean;
		
		
		
		
		@PostConstruct
	    public void init() {
	        createLineModels();
	    }
		
		private void createLineModels() {
	        lineModel1 = initLinearModel();
	        lineModel1.setTitle("Linear Chart");
	        lineModel1.setLegendPosition("e");
	        Axis yAxis = lineModel1.getAxis(AxisType.Y);
	        yAxis.setLabel("Valeur");
	        yAxis.setMin(0);
	        yAxis.setMax(maxTransaction());
	            
	    }
		
		private double maxTransaction(){
			
			double max =0;
			for(int i=0 ; i<liste.size() ; i++){
				
				double valeur=liste.get(i).getMontant();
				if(valeur>max){
					max=valeur;
				}
				
			}
			
			return max;
			
			
		}
		private LineChartModel initLinearModel() {
	        LineChartModel model = new LineChartModel();
	 
	        LineChartSeries series1 = new LineChartSeries();
	        series1.setLabel("Valeurs transferts d'argent");
	 
	        for(int i=0 ; i<liste.size() ; i++){
	        	series1.set(liste.get(i).getDate(), liste.get(i).getMontant());
	        }

	        model.addSeries(series1);
	       
	        return model;
	    }
		
		public TransactionBean() {
			loggedIn = true;
			
			HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
					.getRequest();

			List<Virement> liste= virementService.getAllVirement();
		}

		public boolean isGerant() {
			HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
					.getRequest();
			if (request.isUserInRole("Gerant")) {
				return true;
			} else {
				return false;
			}

		}

		

		public String disconnect() {
			loggedIn = false;
			
			//
			gerant = null;
			//
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			return "plouf";
		}

		public Gerant getGerant() {
			return gerant;
		}

		public void setGerant(Gerant gerant) {
			this.gerant = gerant;
		}

		public boolean isLoggedIn() {
			return loggedIn;
		}

		public void setLoggedIn(boolean loggedIn) {
			this.loggedIn = loggedIn;
		}

		public List<Virement> getListe() {
			return liste;
		}

		public void setListe(List<Virement> liste) {
			this.liste = liste;
		}

		public IVirementService getVirementService() {
			return virementService;
		}

		public void setVirementService(IVirementService virementService) {
			this.virementService = virementService;
		}

		public NavigateBean getNavigateBean() {
			return navigateBean;
		}

		public void setNavigateBean(NavigateBean navigateBean) {
			this.navigateBean = navigateBean;
		}

		
	}


