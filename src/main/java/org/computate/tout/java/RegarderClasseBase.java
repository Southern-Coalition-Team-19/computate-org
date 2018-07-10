package org.computate.tout.java;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.configuration2.INIConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaField;
import com.thoughtworks.qdox.model.JavaMethod;
import com.thoughtworks.qdox.model.JavaType;

public class RegarderClasseBase {

	protected String[] args;

	/**	
	 * var.enUS: appPath
	 * frFR: Le chemin vers l'lappli. 
	 * enUS: The path to the application. 
	 * **/
	protected String cheminAppli;
	protected void _cheminAppli() throws Exception {
		cheminAppli = args[0];
	}
	
	protected String classeCheminAbsolu;
	protected void _classeCheminAbsolu() throws Exception {
		classeCheminAbsolu = args[1];
	}

	protected String cheminSrcMainJava;
	protected void _cheminSrcMainJava() throws Exception {
		cheminSrcMainJava = cheminAppli + "/src/main/java";
	}

	protected String cheminSrcGenJava;
	protected void _cheminSrcGenJava() throws Exception {
		cheminSrcGenJava = cheminAppli + "/src/gen/java";
	}

	protected ArrayList<String> cheminsBibliotheque = new ArrayList<String>();
	protected void _cheminsBibliotheque() throws Exception {
		cheminsBibliotheque.add(cheminAppli + "/lib");
		cheminsBibliotheque.add(cheminAppli + "/lib-tomcat");
		cheminsBibliotheque.add(cheminAppli + "/lib-keycloak");
	}

	protected ArrayList<String> cheminsBin = new ArrayList<String>();
	protected void _cheminsBin() throws Exception {
		cheminsBin.add(cheminAppli + "/bin");
		cheminsBin.add(cheminAppli + "/src/main/resources");
	}

	protected String cheminConfiguration;
	protected void _cheminConfiguration() throws Exception {
		cheminConfiguration = cheminAppli + "/config/computate.config";
	}

	protected File fichierConfiguration;
	protected void _fichierConfiguration() throws Exception {
		fichierConfiguration = new File(cheminConfiguration);
	}

	/**  **/  
	protected Configurations configurations;
	protected void _configurations() throws Exception {
		configurations = new Configurations();
	}

	/**  **/
	protected INIConfiguration config;
	protected void _config() throws Exception {
		config = configurations.ini(fichierConfiguration);
	}

	/**	Le nom de la nomLangue. **/
	protected String nomLangue;
	protected void _nomLangue() throws Exception {
		nomLangue = config.getString(nomAppli + "..nomLangue");
	}

	protected String[] toutesLangues;
	protected void _toutesLangues() throws Exception {
		toutesLangues = new String[] { "frFR", "enUS" };
	}

	protected String[] autresLangues;
	protected void _autresLangues() throws Exception {
		autresLangues = ArrayUtils.removeElement(toutesLangues, nomLangue);
	}

	/**	Le nom de l'lappli. **/
	protected String nomAppli;
	protected void _nomAppli() throws Exception {
		nomAppli = config.getString("nomAppli"); 
	}

	/**	 **/
	protected String nomFichierConfig;
	protected void _nomFicherConfig() throws Exception {
		nomFichierConfig = config.getString(nomAppli + "..nomFichierConfig", nomAppli + ".config");
	}

	/**	 **/
	protected String cheminConfig;
	protected void _cheminConfig() throws Exception {
		cheminConfig = config.getString(nomAppli + "..cheminConfig", cheminAppli + "/config/" + nomFichierConfig);
	}

	/**	 **/
	protected String versionMaven;
	protected void _versionMaven() throws Exception {
		versionMaven = config.getString("maven..versionMaven", "3.5.3");
	}

	/**	 **/
	protected String versionZookeeper;
	protected void _versionZookeeper() throws Exception {
		versionZookeeper = config.getString("maven..versionZookeeper", "3.5.4");
	}

	/**	 **/
	protected String prefixePortZookeeper;
	protected void _prefixePortZookeeper() throws Exception {
		prefixePortZookeeper = config.getString("zookeeper..prefixePortZookeeper", "102");
	}

	/**	 **/
	protected String portClientZookeeper;
	protected void _portClientZookeeper() throws Exception {
		portClientZookeeper = config.getString("zookeeper..portClientZookeeper", prefixePortZookeeper + "81");
	}

	/**	 **/
	protected String portAdminZookeeper;
	protected void _portAdminZookeeper() throws Exception {
		portAdminZookeeper = config.getString("zookeeper..portAdminZookeeper", prefixePortZookeeper + "80");
	}

	/**	 **/
	protected String versionSolr;
	protected void _versionSolr() throws Exception {
		versionSolr = config.getString("zookeeper..versionSolr", "7.3.1");
	}

	/**	 **/
	protected String prefixePortSolr;
	protected void _prefixePortSolr() throws Exception {
		prefixePortSolr = config.getString("zookeeper..prefixePortSolr", "103");
	}

	/**	 **/
	protected String portSolr;
	protected void _portSolr() throws Exception {
		portSolr = config.getString("zookeeper..portSolr", prefixePortSolr + "83");
	}

	/**	 **/
	protected String urlSolr;
	protected void _urlSolr() throws Exception {
		urlSolr = config.getString("zookeeper..urlSolr", "http://localhost:" + portSolr + "/solr/" + nomAppli);
	}

	protected SolrClient clientSolr;
	protected void _clientSolr() throws Exception {
		clientSolr = new HttpSolrClient.Builder(urlSolr).build();
	}

	protected ArrayList<String> cheminsARegarder = new ArrayList<String>();
	protected void _cheminsARegarder() throws Exception {
		cheminsARegarder.add(cheminSrcMainJava);
	}

	protected ArrayList<String> cheminsSource = new ArrayList<String>();
	protected void _cheminsSource() throws Exception {
		cheminsSource.add(cheminSrcMainJava);
		cheminsSource.add(cheminSrcGenJava);
	}

	protected ArrayList<String> toutCheminsSource = new ArrayList<String>();
	protected void _toutCheminsSource() throws Exception {
		toutCheminsSource.add(cheminSrcMainJava);
		toutCheminsSource.add(cheminSrcGenJava);
	}

	protected ArrayList<String> cheminsCheminClasse = new ArrayList<String>();
	protected void _cheminsCheminClasse() throws Exception {
		for(String chemin : cheminsBin) {
			cheminsCheminClasse.add(chemin);
		}
		for(String chemin : cheminsBibliotheque) {
			cheminsCheminClasse.add(chemin + "/*");
		}
	}

	protected ArrayList<String> nomsMethodeTest = new ArrayList<String>();
	protected void _nomsMethodeTest() throws Exception {
	}

	protected JavaProjectBuilder bricoleur;
	protected void _bricoleur() throws Exception {
		bricoleur = new JavaProjectBuilder();
		for(String cheminSource : toutCheminsSource) {
			File répertoireSource = new File(cheminSource);
			bricoleur.addSourceFolder(répertoireSource);
		}
	}


	public void initRegarderClasseBase() throws Exception {
		_cheminAppli();
		_classeCheminAbsolu();
		_cheminSrcMainJava();
		_cheminSrcGenJava();
		_cheminsBibliotheque();
		_cheminsBin();
		_cheminConfiguration();
		_fichierConfiguration();
		_configurations();
		_config();
		_nomLangue();
		_toutesLangues();
		_autresLangues();
		_nomAppli();
		_nomFicherConfig();
		_cheminConfig();
		_versionMaven();
		_versionZookeeper();
		_prefixePortZookeeper();
		_portClientZookeeper();
		_portAdminZookeeper();
		_versionSolr();
		_prefixePortSolr();
		_portSolr();
		_urlSolr();
		_clientSolr();
		_cheminsARegarder();
		_cheminsSource();
		_toutCheminsSource();
		_cheminsCheminClasse();
		_nomsMethodeTest();
		_bricoleur();
	}

	public String regex(String motif, String texte) {
		String o = regex(motif, texte, 1);
		return o;
	}

	public String regex(String motif, String texte, Integer groupe) {
		String o = null;
		if(motif != null && texte != null) {
			Matcher m = Pattern.compile(motif, Pattern.MULTILINE).matcher(texte);
			boolean trouve = m.find();
			if(trouve)
				o = m.group(groupe);
		}
		return o;
	}

	public ArrayList<String> regexListe(String motif, String texte) {
		ArrayList<String> resultats = new ArrayList<String>();
		String o = null;
		if(motif != null && texte != null) {
			Matcher m = Pattern.compile(motif, Pattern.MULTILINE).matcher(texte);
			boolean trouve = m.find();
			while(trouve) {
				o = m.group(1);
				resultats.add(o);
				trouve = m.find();
			}
		}
		return resultats;
	}

	public String concat(String...valeurs) throws Exception { 
		String resultat = Stream.of(valeurs).collect(Collectors.joining());
		return resultat;
	}  

	////////////
	// etend //
	////////////
	
	protected boolean etendClasse(JavaClass classeQdox, String nomCanonique) {
//		for(JavaClass classeSuperQdox : classesSuperQdox) {
//			if(classeSuperQdox.getCanonicalName().equals(nomCanonique))
//				return true;
//		}
		boolean resultat = etendClasse(nomCanonique, classeQdox);
		return resultat;
	}
	protected boolean etendClasse(String nomCanoniqueRecherche, String nomCanoniqueActuel) {
		JavaClass classeQdox = bricoleur.getClassByName(nomCanoniqueActuel);
		return etendClasse(nomCanoniqueRecherche, classeQdox);
	}
	protected boolean etendClasse(String nomCanonique, JavaClass classeQdox) {
		if(nomCanonique != null && classeQdox != null) {
			if(classeQdox.getCanonicalName().equals(Object.class.getCanonicalName()))
				return false;
			if(classeQdox.getCanonicalName().equals(nomCanonique))
				return true;
			else if(!classeQdox.equals(classeQdox.getSuperClass()))
				return etendClasse(nomCanonique, classeQdox.getSuperJavaClass());
		}
		return false;
	}

	//////////////
	// contient //
	//////////////
	
	public Boolean contientChamp(List<JavaClass> classesSuperQdoxEtMoi, String nomChamp, Class<?> c) {
		JavaClass classeQdox = bricoleur.getClassByName(c.getCanonicalName());
		Boolean o = contientChamp(classesSuperQdoxEtMoi, nomChamp, classeQdox);
		return o;
	}
	
	public Boolean contientChamp(List<JavaClass> classesSuperQdoxEtMoi, String nomChamp, JavaClass...tableauParams) {
		ArrayList<JavaType> listeParams = new ArrayList<JavaType>();
		Collections.addAll(listeParams, tableauParams);
		for(JavaClass classeSuper : classesSuperQdoxEtMoi) {
			JavaField champRequeteSite = classeSuper.getFieldByName(nomChamp);
			JavaMethod methodeRequeteSite = classeSuper.getMethod("_" + nomChamp, listeParams, false);
			Boolean o = champRequeteSite != null || methodeRequeteSite != null;
			if(o)
				return true;
		}
		return false;
	}

	public Boolean contientMethodeSeul(JavaClass classeQdox, String nomMethode, JavaClass...tableauParams) {
		JavaMethod o = obtenirMethodeSeul(classeQdox, nomMethode, tableauParams);
		return o != null;
	}

	public Boolean contientMethode(JavaClass classeQdox, String nomMethode, JavaClass...tableauParams) {
		JavaMethod o = obtenirMethode(classeQdox, nomMethode, tableauParams);
		return o != null;
	}
	
	public Boolean contientAttribut(String nomEnsembleDomaine, String nomAttribut, JavaClass classeAttribut) {
		Boolean resultat = false;
		if(classeAttribut.getCanonicalName().startsWith(nomEnsembleDomaine.toString())) {
			JavaField attribut = classeAttribut.getFieldByName(nomAttribut);
			if(attribut == null) {
				resultat = contientAttribut(nomEnsembleDomaine, nomAttribut, classeAttribut.getSuperJavaClass());
			}
			else {
				resultat = true;
			}
		}
		else {
			resultat = false;
		}
		return resultat;
	}

	/////////////
	// obtenir //
	/////////////
	
	public JavaMethod obtenirMethode(JavaClass classeQdox, String nomMethode, JavaClass...tableauParams) {
		ArrayList<JavaType> listeParams = new ArrayList<JavaType>();
		Collections.addAll(listeParams, tableauParams);
		JavaMethod methode = classeQdox.getMethodBySignature(nomMethode, listeParams, true);
		return methode;
	}
	
	public JavaMethod obtenirMethode(List<JavaClass> classesSuperQdoxEtMoi, String nomMethode, JavaClass...tableauParams) {
		ArrayList<JavaType> listeParams = new ArrayList<JavaType>();
		Collections.addAll(listeParams, tableauParams);
		for(JavaClass classeSuper : classesSuperQdoxEtMoi) {
			JavaMethod methode = classeSuper.getMethodBySignature(nomMethode, listeParams);
			if(methode != null)
				return methode;
		}
		return null;
	}
	
	public JavaMethod obtenirMethodeSeul(JavaClass classeQdox, String nomMethode, JavaClass...tableauParams) {
		ArrayList<JavaType> listeParams = new ArrayList<JavaType>();
		Collections.addAll(listeParams, tableauParams);
		JavaMethod methode = classeQdox.getMethodBySignature(nomMethode, listeParams, false);
		return methode;
	}
}
