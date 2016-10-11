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
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.springframework.context.ApplicationContext;

import com.proxibanquev4trio.domaine.Conseiller;
import com.proxibanquev4trio.domaine.Gerant;
import com.proxibanquev4trio.domaine.Virement;
import com.proxibanquev4trio.services.IClientService;
import com.proxibanquev4trio.services.IConseillerService;
import com.proxibanquev4trio.services.IVirementService;

@ManagedBean(name = "transactionBean")
@SessionScoped
public class TransactionBean implements Serializable {
	
		private static final long serialVersionUID = 1L;

		private Gerant gerant;
	
		private boolean loggedIn;
		
		private List<Virement> liste;
		private LoginBean loginBean;
		private LineChartModel dateModel;
		
		@Inject
		private IVirementService virementService;

		@ManagedProperty(value = "#{navigateBean}")
		@Inject
		private NavigateBean navigateBean;
		
		
		@PostConstruct
	    public void init() {
	        createDateModel();
	    }
	 
	    
	     
	    private void createDateModel() {
	        dateModel = new LineChartModel();
	        LineChartSeries series1 = new LineChartSeries();
	        series1.setLabel("Series 1");
	 
	        series1.set("2016-01-01", 51D);
	        series1.set("2016-01-06", 22D);
	        series1.set("2016-01-12", 65D);
	        series1.set("2016-01-18", 74D);
	        series1.set("2016-01-24", 24D);
	        series1.set("2016-01-30", 51D);
	        

	        dateModel.addSeries(series1);
	         
	        dateModel.setTitle("Rapport Transactions 2016");
	        dateModel.setZoom(true);
	        dateModel.getAxis(AxisType.Y).setLabel("Valeurs en euros");
	        DateAxis axis = new DateAxis("Dates");
	        axis.setTickAngle(-50);
	        axis.setMax("2016-12-31");
	        axis.setTickFormat("%b %#d, %y");
	         
	        dateModel.getAxes().put(AxisType.X, axis);
	    }
		
		
		
		private void createDateModel2() {
			dateModel = new LineChartModel();
			LineChartSeries series1 = new LineChartSeries();
	        series1.setLabel("Valeurs transferts d'argent");
	 
	        
	        series1.set("2016-01-01", 51);
	        series1.set("2016-01-06", 22);
	        series1.set("2016-01-12", 65);
	        series1.set("2016-01-18", 74);
	        series1.set("2016-01-24", 24);
	        series1.set("2016-01-30", 51);
//	        for(int i=0 ; i<liste.size() ; i++){
//	        	
//	        	series1.set("2016-10-01", 5);
//	        }

	        dateModel.addSeries(series1);
	        
	        dateModel.setTitle("Virements");
	        dateModel.setZoom(true);
	        dateModel.getAxis(AxisType.Y).setLabel("Valeur");
	        DateAxis axisy = new DateAxis("Dates");
	        axisy.setTickAngle(-50);
	        axisy.setMax("2016-02-01");
	        axisy.setTickFormat("%b %#d, %y");
	         
	        dateModel.getAxes().put(AxisType.X, axisy);
	            
	    }
		
		
		
		public TransactionBean() {
			
			loginBean = (LoginBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginBean");
			ApplicationContext context = loginBean.getContext();
			virementService = context.getBean(IVirementService.class);
			loggedIn = true;
			
			HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
					.getRequest();

			this.liste= virementService.getAllVirement();
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

		public LoginBean getLoginBean() {
			return loginBean;
		}

		public void setLoginBean(LoginBean loginBean) {
			this.loginBean = loginBean;
		}

		public LineChartModel getDateModel() {
			return dateModel;
		}

		public void setDateModel(LineChartModel dateModel) {
			this.dateModel = dateModel;
		}

		
		
	}


