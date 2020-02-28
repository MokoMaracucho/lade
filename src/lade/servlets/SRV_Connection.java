package lade.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lade.beans.BN_Utilisateur;
import lade.formulaires.FORM_TraitementFormulaireConnection;

@WebServlet("/Connection")
public class SRV_Connection extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public static final String VUE_CONNECTION = "/WEB-INF/jsp_connection.jsp";
	
	public static final String ATT_TRAITEMENT_FORMULAIRE_CONNECTION 	= "traitementFormulaireConnection";
	public static final String ATT_UTILISATEUR							= "utilisateur";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher(VUE_CONNECTION).forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FORM_TraitementFormulaireConnection traitementFormulaireConnection = new FORM_TraitementFormulaireConnection(); 

		BN_Utilisateur utilisateur = traitementFormulaireConnection.traitementFormulaireConnection(request);
		
		request.setAttribute(ATT_TRAITEMENT_FORMULAIRE_CONNECTION, 	traitementFormulaireConnection);
		request.setAttribute(ATT_UTILISATEUR, 						utilisateur);
			
		this.getServletContext().getRequestDispatcher(VUE_CONNECTION).forward(request, response);
    }
}
