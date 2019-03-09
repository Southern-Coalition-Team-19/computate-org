package org.computate.enUS.java;

import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.util.ClientUtils;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

/**	
 *	For retrieving a Java class from Solr and writing the Java class to a file for each language. 
 **/
public class WriteApiClass extends WriteGenClass {

	protected AllWriter writerApiServiceImpl;

	protected AllWriter writerGenApiServiceImpl;

	protected AllWriter writerGenApiService;

	protected String classSimpleNameApiPackageInfo;

	protected String classSimpleNameGenApiServiceImpl;

	protected String classSimpleNameApiServiceImpl;

	protected String classSimpleNameGenApiService;

	protected String classCanonicalNameApiPackageInfo;

	protected String classCanonicalNameGenApiServiceImpl;

	protected String classCanonicalNameApiServiceImpl;

	protected String classCanonicalNameGenApiService;

	protected List<String> classApiMethods;

	protected List<String> classEntityVars;

	protected List<String> classMethodeVars;

	public void  apiCodeClassBegin(String languageName) throws Exception, Exception {
//		l();
//		tl(1, "public static final String VAL_nomCanonique", classSimpleName, " = \"", classCanonicalName, "\";");
//		tl(1, "public static final String VAL_virguleEspace = \", \";");
//		tl(1, "public static final String VAL_citation = \"\\\"\";");
//		tl(1, "public static final String VAL_citationDeuxPointsEspaceCitation = \"\\\": \\\"\";");
//		tl(1, "public static final String VAL_citationDeuxPointsEspace = \"\\\": \";");
//		tl(1, "public static final String VAL_citationLigne = \"\\\"\\n\";");
//		tl(1, "public static final String VAL_ligne = \"\\n\";");
//		tl(1, "public static final String VAL_citationVirguleEspaceCitation = \"\\\", \\\"\";");
//		tl(1, "public static final String VAL_citationDeuxPointsEspaceGuillmets = \"\\\": [\";");
//		tl(1, "public static final String VAL_guillmetsFin = \"]\";");
	}

	public void  writeGenApiService(String languageName) throws Exception, Exception {
		if(writerGenApiService != null) {
			writerGenApiService.l("package ", classPackageName, ";");
			writerGenApiService.l();
			writerGenApiService.l("import ", classPartsSiteContext.canonicalName, ";");
//			writerGenApiService.l("import ", classPackageName, ".", classSimpleName, "ApiServiceVertxEBProxy;");
			writerGenApiService.l("import io.vertx.codegen.annotations.ProxyGen;");
			writerGenApiService.l("import io.vertx.ext.web.api.generator.WebApiServiceGen;");
			writerGenApiService.l("import io.vertx.serviceproxy.ServiceBinder;");
			writerGenApiService.l("import io.vertx.core.AsyncResult;");
			writerGenApiService.l("import io.vertx.core.Handler;");
			writerGenApiService.l("import io.vertx.core.Vertx;");
			writerGenApiService.l("import io.vertx.core.json.JsonObject;");
			writerGenApiService.l("import io.vertx.core.json.JsonArray;");
			writerGenApiService.l("import io.vertx.ext.web.api.OperationRequest;");
			writerGenApiService.l("import io.vertx.ext.web.api.OperationResponse;");
			writerGenApiService.l();
			writerGenApiService.l("@WebApiServiceGen");
			writerGenApiService.l("@ProxyGen");
			writerGenApiService.s("public interface ", classSimpleNameGenApiService, " {");
			writerGenApiService.l();
			writerGenApiService.tl(1, "// A factory method to create an instance and a proxy. ");
			writerGenApiService.tl(1, "static void enregistrerService(SiteContext siteContext, Vertx vertx) {");
			writerGenApiService.tl(2, "new ServiceBinder(vertx).setAddress(", q(classSimpleName), ").register(", classSimpleNameGenApiService, ".class, new ", classSimpleNameApiServiceImpl, "(siteContext));");
			writerGenApiService.tl(1, "}");
			writerGenApiService.l();
			writerGenApiService.tl(1, "// A factory method to create an instance and a proxy. ");
			writerGenApiService.tl(1, "static ", classSimpleNameGenApiService, " creer(SiteContext siteContext, Vertx vertx) {");
			writerGenApiService.tl(2, "return new ", classSimpleNameApiServiceImpl, "(siteContext);");
			writerGenApiService.tl(1, "}");
			writerGenApiService.l();
			writerGenApiService.tl(1, "// A factory method to create an instance and a proxy. ");
			writerGenApiService.tl(1, "static ", classSimpleNameGenApiService, " creerProxy(Vertx vertx, String addresse) {");
			writerGenApiService.tl(2, "return new ", classSimpleNameGenApiService, "VertxEBProxy(vertx, addresse);");
			writerGenApiService.tl(1, "}");
			writerGenApiService.l();
			for(String classeApiMethode : classApiMethods) {
				String classApiOperationIdMethod = (String)classDoc.get("classApiOperationId" + classeApiMethode + "_frFR_stored_string");
				String classPageCanonicalNameMethod = (String)classDoc.get("classePageNomCanonique" + classeApiMethode + "_frFR_stored_string");

				if(classPageCanonicalNameMethod != null) {
					writerGenApiService.t(1, "public void ", classApiOperationIdMethod, "Id(");
					if(StringUtils.containsAny(classeApiMethode, "POST", "PUT", "PATCH"))
						writerGenApiService.s("JsonObject body, ");
					writerGenApiService.l("OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements);");
				}

				writerGenApiService.t(1, "public void ", classApiOperationIdMethod, "(");
				if(StringUtils.containsAny(classeApiMethode, "POST", "PUT", "PATCH"))
					writerGenApiService.s("JsonObject body, ");
				writerGenApiService.l("OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements);");
			}
			writerGenApiService.tl(0, "}");

			writerGenApiService.flushClose();
		}
	}

	public void  writeApiServiceImpl(String languageName) throws Exception, Exception {
		if(writerApiServiceImpl != null) {
			writerApiServiceImpl.l("package ", classPackageName, ";");
			writerApiServiceImpl.l();
			writerApiServiceImpl.l("import ", classPartsSiteContext.canonicalName, ";");
//			auteurGenApiService.l("import ", classPackageName, ".", classSimpleName, "ApiServiceVertxEBProxy;");
			writerApiServiceImpl.l();
			writerApiServiceImpl.l("public class ", classSimpleNameApiServiceImpl, " extends ", classSimpleNameGenApiServiceImpl, " {");
			writerApiServiceImpl.l();
			writerApiServiceImpl.tl(1, "public ", classSimpleNameApiServiceImpl, "(SiteContext siteContext) {");
			writerApiServiceImpl.tl(2, "super(siteContext);");
			writerApiServiceImpl.tl(1, "}");
			writerApiServiceImpl.l("}");

			writerApiServiceImpl.flushClose();
		}
	}

	public void  writeGenApiServiceImpl(String languageName) throws Exception, Exception {

		if(writerGenApiServiceImpl != null) {
			o = writerGenApiServiceImpl;
	
			l("package ", classPackageName, ";");
			l();
			writerGenApiServiceImpl.l("import ", classPartsAllWriter.canonicalName, ";");
			if(classImportsGenApi.size() > 0) { 
				for(String classeImportation : classImportsGenApi) {
					l("import ", classeImportation, ";");
				}
				l();
			}

			{
				SolrQuery searchSolr = new SolrQuery();   
				searchSolr.setQuery("*:*");
				searchSolr.setRows(1000000);
				String fqClassesSuperEtMoi = "(" + entiteClassesSuperEtMoiSansGen.stream().map(c -> ClientUtils.escapeQueryChars(c)).collect(Collectors.joining(" OR ")) + ")";
				searchSolr.addFilterQuery("partEstEntite_indexed_boolean:true");
				searchSolr.addFilterQuery("classeNomCanonique_" + languageName + "_indexed_string:" + fqClassesSuperEtMoi);
				QueryResponse searchReponse = clientSolrComputate.query(searchSolr);
				SolrDocumentList searchListe = searchReponse.getResults();
				Integer searchLignes = searchSolr.getRows();
	
				if(searchListe.size() > 0) {
					for(Long i = searchListe.getStart(); i < searchListe.getNumFound(); i+=searchLignes) {
						for(Integer j = 0; j < searchListe.size(); j++) {
							SolrDocument doc = searchListe.get(j);
							entityVar = (String)doc.get("entityVar_" + languageName + "_stored_string");
							entityVarCapitalise = (String)doc.get("entityVarCapitalise_" + languageName + "_stored_string");
							entiteSuffixeType = (String)doc.get("entiteSuffixeType_stored_string");
							entiteIndexe = (Boolean)doc.get("entiteIndexe_stored_boolean");
							entiteStocke = (Boolean)doc.get("entiteStocke_stored_boolean");
							entiteSolrNomCanonique = (String)doc.get("entiteSolrNomCanonique_stored_string");
							entiteSolrNomSimple = (String)doc.get("entiteSolrNomSimple_stored_string");
							entiteNomSimpleVertxJson = (String)doc.get("entiteNomSimpleVertxJson_stored_string");
							entiteNomCanoniqueVertxJson = (String)doc.get("entiteNomCanoniqueVertxJson_stored_string");
							entiteListeNomSimpleVertxJson = (String)doc.get("entiteListeNomSimpleVertxJson_stored_string");
							entiteListeNomCanoniqueVertxJson = (String)doc.get("entiteListeNomCanoniqueVertxJson_stored_string");
							entiteNomCanonique = (String)doc.get("entiteNomCanonique_" + languageName + "_stored_string");
							entiteNomCanoniqueGenerique = (String)doc.get("entiteNomCanoniqueGenerique_" + languageName + "_stored_string");
							entiteNomSimpleComplet = (String)doc.get("entiteNomSimpleComplet_" + languageName + "_stored_string");
							entiteNomSimpleCompletGenerique = (String)doc.get("entiteNomSimpleCompletGenerique_" + languageName + "_stored_string");
							entiteNomSimple = (String)doc.get("entiteNomSimple_" + languageName + "_stored_string");
	
							/////////////////
							// codeApiGet //
							/////////////////

							if(classeIndexe && entiteIndexe) {
								wApiGet.tl(3, "case \"", entityVar, "\":");
								wApiGet.tl(4, "return \"", entityVar, "_indexed", entiteSuffixeType, "\";");
							}
							
							///////////////////////
							// codeApiGenererGet //
							///////////////////////
							o = wApiGenerateGet;
							if(classeIndexe && entiteStocke) {
				//				tl(4, "if(", q(entityVar, "_stored", entiteSuffixeType), ".equals(entityVarStocke)) {");
								if(StringUtils.equalsAny(entiteNomCanonique, VAL_canonicalNameList, VAL_canonicalNameArrayList, VAL_canonicalNameSet, VAL_canonicalNameHashSet)) {
									if(VAL_canonicalNameBoolean.equals(entiteNomCanoniqueGenerique)) {
										l();
										tl(4, "{");
										tl(5, entiteNomSimpleComplet, " entiteValeurs = o.get", entityVarCapitalise, "();");
										tl(5, "w.t(3, entiteNumero++ == 0 ? \"\" : \", \");");
										tl(5, "w.s(\"\\\"", entityVar, "\\\": [\");");
										tl(5, "int k = 0;");
										tl(5, "while(entiteValeur != null) {");
										tl(6, "if(k > 0)");
										tl(7, "w.s(\", \");");
										tl(6, "w.s(((Boolean)entiteValeur).toString());");
										tl(6, "entiteValeur = entiteValeurs.iterator().hasNext() ? entiteValeurs.iterator().next() : null;");
										tl(5, "}");
										tl(5, "w.l(\"]\");");
										tl(4, "}");
									}
									else if(VAL_canonicalNameDate.equals(entiteNomCanoniqueGenerique)) {
										l();
										tl(4, "{");
										tl(5, entiteNomSimpleComplet, " entiteValeurs = o.get", entityVarCapitalise, "();");
										tl(5, "w.t(3, entiteNumero++ == 0 ? \"\" : \", \");");
										tl(5, "w.s(\"\\\"", entityVar, "\\\": [\");");
										tl(5, "int k = 0;");
										tl(5, "while(entiteValeur != null) {");
										tl(6, "if(k > 0)");
										tl(7, "w.s(\", \");");
										tl(6, "w.s(\"\\\"\");");
										tl(6, "w.s(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(((Date)entiteValeur).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()));");
										tl(6, "w.s(\"\\\"\");");
										tl(6, "entiteValeur = entiteValeurs.iterator().hasNext() ? entiteValeurs.iterator().next() : null;");
										tl(5, "}");
										tl(5, "w.l(\"]\");");
										tl(4, "}");
									}
									else if(VAL_canonicalNameTimestamp.equals(entiteNomCanoniqueGenerique)) {
										l();
										tl(4, "{");
										tl(5, entiteNomSimpleComplet, " entiteValeurs = o.get", entityVarCapitalise, "();");
										tl(5, "w.t(3, entiteNumero++ == 0 ? \"\" : \", \");");
										tl(5, "w.s(\"\\\"", entityVar, "\\\": [\");");
										tl(5, "int k = 0;");
										tl(5, "while(entiteValeur != null) {");
										tl(6, "if(k > 0)");
										tl(7, "w.s(\", \");");
										tl(6, "w.s(\"\\\"\");");
										tl(6, "w.s(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(((Date)entiteValeur).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()));");
										tl(6, "w.s(\"\\\"\");");
										tl(6, "entiteValeur = entiteValeurs.iterator().hasNext() ? entiteValeurs.iterator().next() : null;");
										tl(5, "}");
										tl(5, "w.l(\"]\");");
										tl(4, "}");
									}
									else if(VAL_canonicalNameZonedDateTime.equals(entiteNomCanoniqueGenerique)) {
										l();
										tl(4, "{");
										tl(5, entiteNomSimpleComplet, " entiteValeurs = o.get", entityVarCapitalise, "();");
										tl(5, "w.t(3, entiteNumero++ == 0 ? \"\" : \", \");");
										tl(5, "w.s(\"\\\"", entityVar, "\\\": [\");");
										tl(5, "int k = 0;");
										tl(5, "while(entiteValeur != null) {");
										tl(6, "if(k > 0)");
										tl(7, "w.s(\", \");");
										tl(6, "w.s(\"\\\"\");");
										tl(6, "w.s(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(((Date)entiteValeur).toInstant().atZone(ZoneId.systemDefault()).toZonedDateTime()));");
										tl(6, "w.s(\"\\\"\");");
										tl(6, "entiteValeur = entiteValeurs.iterator().hasNext() ? entiteValeurs.iterator().next() : null;");
										tl(5, "}");
										tl(5, "w.l(\"]\");");
										tl(4, "}");
									}
									else if(VAL_canonicalNameLocalDateTime.equals(entiteNomCanoniqueGenerique)) {
										l();
										tl(4, "{");
										tl(5, entiteNomSimpleComplet, " entiteValeurs = o.get", entityVarCapitalise, "();");
										tl(5, "w.t(3, entiteNumero++ == 0 ? \"\" : \", \");");
										tl(5, "w.s(\"\\\"", entityVar, "\\\": [\");");
										tl(5, "int k = 0;");
										tl(5, "while(entiteValeur != null) {");
										tl(6, "if(k > 0)");
										tl(7, "w.s(\", \");");
										tl(6, "w.s(\"\\\"\");");
										tl(6, "w.s(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(((Date)entiteValeur).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()));");
										tl(6, "w.s(\"\\\"\");");
										tl(6, "entiteValeur = entiteValeurs.iterator().hasNext() ? entiteValeurs.iterator().next() : null;");
										tl(5, "}");
										tl(5, "w.l(\"]\");");
										tl(4, "}");
									}
									else if(VAL_canonicalNameLocalDate.equals(entiteNomCanoniqueGenerique)) {
										l();
										tl(4, "{");
										tl(5, entiteNomSimpleComplet, " entiteValeurs = o.get", entityVarCapitalise, "();");
										tl(5, "w.t(3, entiteNumero++ == 0 ? \"\" : \", \");");
										tl(5, "w.s(\"\\\"", entityVar, "\\\": [\");");
										tl(5, "int k = 0;");
										tl(5, "while(entiteValeur != null) {");
										tl(6, "if(k > 0)");
										tl(7, "w.s(\", \");");
										tl(6, "w.s(\"\\\"\");");
										tl(6, "w.s(DateTimeFormatter.ISO_OFFSET_DATE.format(((Date)entiteValeur).toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));");
										tl(6, "w.s(\"\\\"\");");
										tl(6, "entiteValeur = entiteValeurs.iterator().hasNext() ? entiteValeurs.iterator().next() : null;");
										tl(5, "}");
										tl(5, "w.l(\"]\");");
										tl(4, "}");
									}
									else if(VAL_canonicalNameLong.equals(entiteNomCanoniqueGenerique)) {
										l();
										tl(4, "{");
										tl(5, entiteNomSimpleComplet, " entiteValeurs = o.get", entityVarCapitalise, "();");
										tl(5, "w.t(3, entiteNumero++ == 0 ? \"\" : \", \");");
										tl(5, "w.s(\"\\\"", entityVar, "\\\": [\");");
										tl(5, "int k = 0;");
										tl(5, "while(entiteValeur != null) {");
										tl(6, "if(k > 0)");
										tl(7, "w.s(\", \");");
										tl(6, "w.s(((Long)entiteValeur).toString());");
										tl(6, "entiteValeur = entiteValeurs.iterator().hasNext() ? entiteValeurs.iterator().next() : null;");
										tl(5, "}");
										tl(5, "w.l(\"]\");");
										tl(4, "}");
									}
									else if(VAL_canonicalNameBigDecimal.equals(entiteNomCanoniqueGenerique)) {
										l();
										tl(4, "{");
										tl(5, entiteNomSimpleComplet, " entiteValeurs = o.get", entityVarCapitalise, "();");
										tl(5, "w.t(3, entiteNumero++ == 0 ? \"\" : \", \");");
										tl(5, "w.s(\"\\\"", entityVar, "\\\": [\");");
										tl(5, "int k = 0;");
										tl(5, "while(entiteValeur != null) {");
										tl(6, "if(k > 0)");
										tl(7, "w.s(\", \");");
										tl(6, "w.s(BigDecimal.valueOf((Double)entiteValeur).toString());");
										tl(6, "entiteValeur = entiteValeurs.iterator().hasNext() ? entiteValeurs.iterator().next() : null;");
										tl(5, "}");
										tl(5, "w.l(\"]\");");
										tl(4, "}");
									}
									else if(VAL_canonicalNameDouble.equals(entiteNomCanoniqueGenerique)) {
										l();
										tl(4, "{");
										tl(5, entiteNomSimpleComplet, " entiteValeurs = o.get", entityVarCapitalise, "();");
										tl(5, "w.t(3, entiteNumero++ == 0 ? \"\" : \", \");");
										tl(5, "w.s(\"\\\"", entityVar, "\\\": [\");");
										tl(5, "int k = 0;");
										tl(5, "while(entiteValeur != null) {");
										tl(6, "if(k > 0)");
										tl(7, "w.s(\", \");");
										tl(6, "w.s(((Double)entiteValeur).toString());");
										tl(6, "entiteValeur = entiteValeurs.iterator().hasNext() ? entiteValeurs.iterator().next() : null;");
										tl(5, "}");
										tl(5, "w.l(\"]\");");
										tl(4, "}");
									}
									else if(VAL_canonicalNameFloat.equals(entiteNomCanoniqueGenerique)) {
										l();
										tl(4, "{");
										tl(5, entiteNomSimpleComplet, " entiteValeurs = o.get", entityVarCapitalise, "();");
										tl(5, "w.t(3, entiteNumero++ == 0 ? \"\" : \", \");");
										tl(5, "w.s(\"\\\"", entityVar, "\\\": [\");");
										tl(5, "int k = 0;");
										tl(5, "while(entiteValeur != null) {");
										tl(6, "if(k > 0)");
										tl(7, "w.s(\", \");");
										tl(6, "w.s(((Float)entiteValeur).toString());");
										tl(6, "entiteValeur = entiteValeurs.iterator().hasNext() ? entiteValeurs.iterator().next() : null;");
										tl(5, "}");
										tl(5, "w.l(\"]\");");
										tl(4, "}");
									}
									else if(VAL_canonicalNameInteger.equals(entiteNomCanoniqueGenerique)) {
										l();
										tl(4, "{");
										tl(5, entiteNomSimpleComplet, " entiteValeurs = o.get", entityVarCapitalise, "();");
										tl(5, "w.t(3, entiteNumero++ == 0 ? \"\" : \", \");");
										tl(5, "w.s(\"\\\"", entityVar, "\\\": [\");");
										tl(5, "int k = 0;");
										tl(5, "while(entiteValeur != null) {");
										tl(6, "if(k > 0)");
										tl(7, "w.s(\", \");");
										tl(6, "w.s(((Integer)entiteValeur).toString());");
										tl(6, "entiteValeur = entiteValeurs.iterator().hasNext() ? entiteValeurs.iterator().next() : null;");
										tl(5, "}");
										tl(5, "w.l(\"]\");");
										tl(4, "}");
									}
									else {
										l();
										tl(4, "{");
										tl(5, entiteNomSimpleComplet, " entiteValeurs = o.get", entityVarCapitalise, "();");
										tl(5, "w.t(3, entiteNumero++ == 0 ? \"\" : \", \");");
										tl(5, "w.s(\"\\\"", entityVar, "\\\": [\");");
										tl(5, "int k = 0;");
										tl(5, "while(entiteValeur != null) {");
										tl(6, "if(k > 0)");
										tl(7, "w.s(\", \");");
										tl(6, "w.s(\", \");");
										tl(6, "w.s(\"\\\"\");");
										tl(6, "w.s(((String)entiteValeur));");
										tl(6, "w.s(\"\\\"\");");
										tl(6, "entiteValeur = entiteValeurs.iterator().hasNext() ? entiteValeurs.iterator().next() : null;");
										tl(5, "}");
										tl(5, "w.l(\"]\");");
										tl(4, "}");
									}
								}
								else {
									l();
									tl(4, "entiteValeur = o.get", entityVarCapitalise, "();");
				//					tl(4, "entiteValeur = Optional.ofNullable(documentSolr.getFieldValues(", q(entityVar, "_stored", entiteSuffixeType), ")).map(Collection<Object>::stream).orElseGet(Stream::empty).findFirst().orElse(null);");
				//					tl(4, "entiteValeur = documentSolr.getFieldValues(", q(entityVar, "_stored", entiteSuffixeType), ").stream().findFirst().orElse(null);");
				//					tl(5, "entiteValeur = documentSolr.getFieldValues(", q(entityVar, "_stored", entiteSuffixeType), ").stream().findFirst().orElse(null);");
									tl(4, "if(entiteValeur != null)");
									if (VAL_canonicalNameBoolean.equals(entiteSolrNomCanonique)) {
				//						tl(5, "Object entiteStr = entiteValeur == null ? ", q("null"), " : entiteValeur;");
				
										// tomorrow put this line everywhere. 
										tl(5, "w.tl(3, entiteNumero++ == 0 ? ", q(), " : ", q(", "), ", ", q(q(entityVar), ": "), ", entiteValeur);");
									} else if (VAL_canonicalNameDate.equals(entiteSolrNomCanonique)) {
										if (VAL_canonicalNameTimestamp.equals(entiteNomCanonique)) {
				//							tl(5, "Object entiteStr = entiteValeur == null ? ", q("null"), " : DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(((Date)entiteValeur).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());");
											tl(5, "w.tl(3, entiteNumero++ == 0 ? ", q(), " : ", q(", "), ", ", q(q(entityVar), ": "), ", w.qjs(entiteValeur));");
										} else if (VAL_canonicalNameZonedDateTime.equals(entiteNomCanonique)) {
				//							tl(5, "Object entiteStr = entiteValeur == null ? ", q("null"), " : DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(((Date)entiteValeur).toInstant().atZone(ZoneId.systemDefault()).toZonedDateTime());");
											tl(5, "w.tl(3, entiteNumero++ == 0 ? ", q(), " : ", q(", "), ", ", q(q(entityVar), ": "), ", w.qjs(entiteValeur));");
										} else if (VAL_canonicalNameLocalDateTime.equals(entiteNomCanonique)) {
				//							tl(5, "Object entiteStr = entiteValeur == null ? ", q("null"), " : DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(((Date)entiteValeur).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());");
											tl(5, "w.tl(3, entiteNumero++ == 0 ? ", q(), " : ", q(", "), ", ", q(q(entityVar), ": "), ", w.qjs(entiteValeur));");
										} else if (VAL_canonicalNameLocalDate.equals(entiteNomCanonique)) {
				//							tl(5, "Object entiteStr = entiteValeur == null ? ", q("null"), " : DateTimeFormatter.ISO_OFFSET_DATE.format(((Date)entiteValeur).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());");
											tl(5, "w.tl(3, entiteNumero++ == 0 ? ", q(), " : ", q(", "), ", ", q(q(entityVar), ": "), ", w.qjs(entiteValeur));");
										} else {
				//							tl(5, "Object entiteStr = entiteValeur == null ? ", q("null"), " : DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(((Date)entiteValeur).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());");
											tl(5, "w.tl(3, entiteNumero++ == 0 ? ", q(), " : ", q(", "), ", ", q(q(entityVar), ": "), ", w.qjs(entiteValeur));");
										}
									} else if (VAL_canonicalNameLong.equals(entiteSolrNomCanonique)) {
				//						tl(5, "Object entiteStr = entiteValeur == null ? ", q("null"), " : entiteValeur;");
										tl(5, "w.tl(3, entiteNumero++ == 0 ? ", q(), " : ", q(", "), ", ", q(q(entityVar), ": "), ", entiteValeur);");
									} else if (VAL_canonicalNameDouble.equals(entiteSolrNomCanonique)) {
										if (VAL_canonicalNameBigDecimal.equals(entiteNomCanonique)) {
				//							tl(5, "Object entiteStr = entiteValeur == null ? ", q("null"), " : entiteValeur;");
											tl(5, "w.tl(3, entiteNumero++ == 0 ? ", q(), " : ", q(", "), ", ", q(q(entityVar), ": "), ", entiteValeur);");
										}
										else {
				//							tl(5, "Object entiteStr = entiteValeur == null ? ", q("null"), " : entiteValeur;");
											tl(5, "w.tl(3, entiteNumero++ == 0 ? ", q(), " : ", q(", "), ", ", q(q(entityVar), ": "), ", entiteValeur);");
										}
									} else if (VAL_canonicalNameFloat.equals(entiteSolrNomCanonique)) {
				//						tl(5, "Object entiteStr = entiteValeur == null ? ", q("null"), " : entiteValeur;");
										tl(5, "w.tl(3, entiteNumero++ == 0 ? ", q(), " : ", q(", "), ", ", q(q(entityVar), ": "), ", entiteValeur);");
									} else if (VAL_canonicalNameInteger.equals(entiteSolrNomCanonique)) {
				//						tl(5, "Object entiteStr = entiteValeur == null ? ", q("null"), " : entiteValeur;");
										tl(5, "w.tl(3, entiteNumero++ == 0 ? ", q(), " : ", q(", "), ", ", q(q(entityVar), ": "), ", entiteValeur);");
									}
									else {
				//						tl(5, "Object entiteStr = entiteValeur == null ? ", q("null"), " : entiteValeur;");
										tl(5, "w.tl(3, entiteNumero++ == 0 ? ", q(), " : ", q(", "), ", ", q(q(entityVar), ": "), ", w.qjs(entiteValeur));");
									}
								}
				//				tl(3, ");");
				//				tl(3, "}");
							}
						}
						searchSolr.setStart(i.intValue() + searchLignes);
						searchReponse = clientSolrComputate.query(searchSolr);
						searchListe = searchReponse.getResults();
					}
				}
			}
			wApiGet.flushClose();
			wApiGenerateGet.flushClose();
	
			o = writerGenApiServiceImpl;
			tl(0, "");
			writeComment(classComment, 0); 
			s("public class ", classSimpleNameGenApiServiceImpl);
			s(" implements ", classSimpleNameGenApiService);
			l(" {");
			l();
			tl(1, "private static final Logger LOGGER = LoggerFactory.getLogger(", classSimpleNameGenApiServiceImpl, ".class);");
			l();
			tl(1, "private static final String SERVICE_ADDRESS = \"", classSimpleNameApiServiceImpl, "\";");
			l();
			tl(1, "protected SiteContext siteContext;");
			l();
			tl(1, "public ", classSimpleNameGenApiServiceImpl, "(SiteContext siteContext) {");
			tl(2, "this.siteContext = siteContext;");
			tl(2, classSimpleNameGenApiService, " service = ", classSimpleNameGenApiService, ".createProxy(siteContext.getVertx(), SERVICE_ADDRESS);");
			tl(1, "}");

			for(String classApiMethod : classApiMethods) {
				String classPageCanonicalNameMethod = (String)classDoc.get("classePageNomCanonique" + classApiMethod + "_frFR_stored_string");
				String classPageSimpleNameMethod = (String)classDoc.get("classePageNomSimple" + classApiMethod + "_frFR_stored_string");
				String classApiOperationIdMethod = (String)classDoc.get("classApiOperationId" + classApiMethod + "_frFR_stored_string");
				String classApiUriMethode = (String)classDoc.get("classApiUri" + classApiMethod + "_frFR_stored_string");
				String classeApiTypeMediaMethode = (String)classDoc.get("classeApiTypeMedia" + classApiMethod + "_stored_string");
				l();
				tl(1, "// ", classApiMethod, " //");
				if(classPageCanonicalNameMethod != null) {
					l();
					tl(1, "@Override");
					t(1, "public void ", classApiOperationIdMethod, "Id(");
					if(StringUtils.containsAny(classApiMethod, "POST", "PUT", "PATCH"))
						s("JsonObject body, ");
					l("OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {");
					tl(2, classApiOperationIdMethod, "(operationRequest, eventHandler);");
					tl(1, "}");
				}
				l();
				tl(1, "@Override");
				t(1, "public void ", classApiOperationIdMethod, "(");
				if(StringUtils.containsAny(classApiMethod, "POST", "PUT", "PATCH"))
					s("JsonObject body, ");
				l("OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {");

				if(classApiMethod.contains("POST")) {
					tl(2, "try {");
					tl(3, "SiteRequest siteRequest = genererSiteRequestPour", classSimpleName, "(siteContext, operationRequest, body);");
					tl(3, "sql", classSimpleName, "(siteRequest, a -> {");
					tl(4, "if(a.succeeded()) {");
					tl(5, "create", classApiMethod, classSimpleName, "(siteRequest, b -> {");
					tl(6, "if(b.succeeded()) {");
					tl(7, classSimpleName, " ", StringUtils.uncapitalize(classSimpleName), " = b.result();");
					tl(7, "sql", classApiMethod, classSimpleName, "(", StringUtils.uncapitalize(classSimpleName), ", c -> {");
					tl(8, "if(c.succeeded()) {");
					tl(9, "definir", classSimpleName, "(", StringUtils.uncapitalize(classSimpleName), ", d -> {");
					tl(10, "if(d.succeeded()) {");
					tl(11, "attribuer", classSimpleName, "(", StringUtils.uncapitalize(classSimpleName), ", e -> {");
					tl(12, "if(e.succeeded()) {");
					tl(13, "indexer", classSimpleName, "(", StringUtils.uncapitalize(classSimpleName), ", f -> {");
					tl(14, "if(f.succeeded()) {");
					tl(15, "response200", classApiMethod, classSimpleName, "(", StringUtils.uncapitalize(classSimpleName), ", g -> {");
					tl(16, "if(f.succeeded()) {");
					tl(17, "SQLConnection sqlConnection = siteRequest.getConnexionSql();");
					tl(17, "sqlConnection.commit(h -> {");
					tl(18, "if(a.succeeded()) {");
					tl(19, "sqlConnection.close(i -> {");
					tl(20, "if(a.succeeded()) {");
					tl(21, "eventHandler.handle(Future.succeededFuture(g.result()));");
					tl(20, "} else {");
					tl(21, "erreur", classSimpleName, "(siteRequest, eventHandler, i);");
					tl(20, "}");
					tl(19, "});");
					tl(18, "} else {");
					tl(19, "erreur", classSimpleName, "(siteRequest, eventHandler, h);");
					tl(18, "}");
					tl(17, "});");
					tl(16, "} else {");
					tl(17, "erreur", classSimpleName, "(siteRequest, eventHandler, g);");
					tl(16, "}");
					tl(15, "});");
					tl(14, "} else {");
					tl(15, "erreur", classSimpleName, "(siteRequest, eventHandler, f);");
					tl(14, "}");
					tl(13, "});");
					tl(12, "} else {");
					tl(13, "erreur", classSimpleName, "(siteRequest, eventHandler, e);");
					tl(12, "}");
					tl(11, "});");
					tl(10, "} else {");
					tl(11, "erreur", classSimpleName, "(siteRequest, eventHandler, d);");
					tl(10, "}");
					tl(9, "});");
					tl(8, "} else {");
					tl(9, "erreur", classSimpleName, "(siteRequest, eventHandler, c);");
					tl(8, "}");
					tl(7, "});");
					tl(6, "} else {");
					tl(7, "erreur", classSimpleName, "(siteRequest, eventHandler, b);");
					tl(6, "}");
					tl(5, "});");
					tl(4, "} else {");
					tl(5, "erreur", classSimpleName, "(siteRequest, eventHandler, a);");
					tl(4, "}");
					tl(3, "});");
					tl(2, "} catch(Exception e) {");
					tl(3, "erreur", classSimpleName, "(null, eventHandler, Future.failedFuture(e));");
					tl(2, "}");
				}
				else if(classApiMethod.contains("PATCH")) {
					tl(2, "try {");
					tl(3, "SiteRequest siteRequest = genererSiteRequestPour", classSimpleName, "(siteContext, operationRequest, body);");
					tl(3, "sql", classSimpleName, "(siteRequest, a -> {");
					tl(4, "if(a.succeeded()) {");
					tl(5, "search", classSimpleName, "(siteRequest, false, true, ", "null", ", b -> {");
					tl(6, "if(b.succeeded()) {");
					tl(7, "ListeRecherche<", classSimpleName, "> liste", classSimpleName, " = b.result();");
					tl(7, "liste", classApiMethod, classSimpleName, "(liste", classSimpleName, ", c -> {");
					tl(8, "if(c.succeeded()) {");
					tl(9, "SQLConnection sqlConnection = siteRequest.getConnexionSql();");
					tl(9, "sqlConnection.commit(d -> {");
					tl(10, "if(a.succeeded()) {");
					tl(11, "sqlConnection.close(e -> {");
					tl(12, "if(a.succeeded()) {");
					tl(13, "eventHandler.handle(Future.succeededFuture(c.result()));");
					tl(12, "} else {");
					tl(13, "erreur", classSimpleName, "(siteRequest, eventHandler, e);");
					tl(12, "}");
					tl(11, "});");
					tl(10, "} else {");
					tl(11, "erreur", classSimpleName, "(siteRequest, eventHandler, d);");
					tl(10, "}");
					tl(9, "});");
					tl(8, "} else {");
					tl(9, "erreur", classSimpleName, "(siteRequest, eventHandler, c);");
					tl(8, "}");
					tl(7, "});");
					tl(6, "} else {");
					tl(7, "erreur", classSimpleName, "(siteRequest, eventHandler, b);");
					tl(6, "}");
					tl(5, "});");
					tl(4, "} else {");
					tl(5, "erreur", classSimpleName, "(siteRequest, eventHandler, a);");
					tl(4, "}");
					tl(3, "});");
					tl(2, "} catch(Exception e) {");
					tl(3, "erreur", classSimpleName, "(null, eventHandler, Future.failedFuture(e));");
					tl(2, "}");
				}
				else if(classApiMethod.contains("Recherche")) {
					if(classPageSimpleNameMethod == null) {
						tl(2, "try {");
						tl(3, "SiteRequest siteRequest = genererSiteRequestPour", classSimpleName, "(siteContext, operationRequest);");
						tl(3, "search", classSimpleName, "(siteRequest, false, true, ", "null", ", a -> {");
						tl(4, "if(a.succeeded()) {");
						tl(5, "ListeRecherche<", classSimpleName, "> liste", classSimpleName, " = a.result();");
						tl(5, "response200", classApiMethod, classSimpleName, "(liste", classSimpleName, ", b -> {");
						tl(6, "if(b.succeeded()) {");
						tl(7, "eventHandler.handle(Future.succeededFuture(b.result()));");
						tl(6, "} else {");
						tl(7, "erreur", classSimpleName, "(siteRequest, eventHandler, b);");
						tl(6, "}");
						tl(5, "});");
						tl(4, "} else {");
						tl(5, "erreur", classSimpleName, "(siteRequest, eventHandler, a);");
						tl(4, "}");
						tl(3, "});");
						tl(2, "} catch(Exception e) {");
						tl(3, "erreur", classSimpleName, "(null, eventHandler, Future.failedFuture(e));");
						tl(2, "}");
					}
					else {
						tl(2, "try {");
						tl(3, "SiteRequest siteRequest = genererSiteRequestPour", classSimpleName, "(siteContext, operationRequest);");
						tl(3, "sql", classSimpleName, "(siteRequest, a -> {");
						tl(4, "if(a.succeeded()) {");
						tl(5, "utilisateur", classSimpleName, "(siteRequest, b -> {");
						tl(6, "if(b.succeeded()) {");
						tl(7, "search", classSimpleName, "(siteRequest, false, true, ", q(classApiUriMethode), ", c -> {");
						tl(8, "if(c.succeeded()) {");
						tl(9, "ListeRecherche<", classSimpleName, "> liste", classSimpleName, " = c.result();");
						tl(9, "response200", classApiMethod, classSimpleName, "(liste", classSimpleName, ", d -> {");
						tl(10, "if(d.succeeded()) {");
						tl(11, "SQLConnection sqlConnection = siteRequest.getConnexionSql();");
						tl(11, "sqlConnection.commit(e -> {");
						tl(12, "if(e.succeeded()) {");
						tl(13, "sqlConnection.close(f -> {");
						tl(14, "if(f.succeeded()) {");
						tl(15, "eventHandler.handle(Future.succeededFuture(d.result()));");
						tl(14, "} else {");
						tl(15, "erreur", classSimpleName, "(siteRequest, eventHandler, f);");
						tl(14, "}");
						tl(13, "});");
						tl(12, "} else {");
						tl(13, "erreur", classSimpleName, "(siteRequest, eventHandler, e);");
						tl(12, "}");
						tl(11, "});");
						tl(10, "} else {");
						tl(11, "erreur", classSimpleName, "(siteRequest, eventHandler, d);");
						tl(10, "}");
						tl(9, "});");
						tl(8, "} else {");
						tl(9, "erreur", classSimpleName, "(siteRequest, eventHandler, c);");
						tl(8, "}");
						tl(7, "});");
						tl(6, "} else {");
						tl(7, "erreur", classSimpleName, "(siteRequest, eventHandler, b);");
						tl(6, "}");
						tl(5, "});");
						tl(4, "} else {");
						tl(5, "erreur", classSimpleName, "(siteRequest, eventHandler, a);");
						tl(4, "}");
						tl(3, "});");
						tl(2, "} catch(Exception e) {");
						tl(3, "erreur", classSimpleName, "(null, eventHandler, Future.failedFuture(e));");
						tl(2, "}");
					}
				}
				else if(classApiMethod.contains("GET")) {
					tl(2, "try {");
					tl(3, "SiteRequest siteRequest = genererSiteRequestPour", classSimpleName, "(siteContext, operationRequest);");
					tl(3, "search", classSimpleName, "(siteRequest, false, true, ", "null", ", a -> {");
					tl(4, "if(a.succeeded()) {");
					tl(5, "ListeRecherche<", classSimpleName, "> liste", classSimpleName, " = a.result();");
					tl(5, "response200", classApiMethod, classSimpleName, "(liste", classSimpleName, ", b -> {");
					tl(6, "if(b.succeeded()) {");
					tl(7, "eventHandler.handle(Future.succeededFuture(b.result()));");
					tl(6, "} else {");
					tl(7, "erreur", classSimpleName, "(siteRequest, eventHandler, b);");
					tl(6, "}");
					tl(5, "});");
					tl(4, "} else {");
					tl(5, "erreur", classSimpleName, "(siteRequest, eventHandler, a);");
					tl(4, "}");
					tl(3, "});");
					tl(2, "} catch(Exception e) {");
					tl(3, "erreur", classSimpleName, "(null, eventHandler, Future.failedFuture(e));");
					tl(2, "}");
				}
				else if(classApiMethod.contains("PUT")) {
					tl(2, "try {");
					tl(3, "SiteRequest siteRequest = genererSiteRequestPour", classSimpleName, "(siteContext, operationRequest, body);");
					tl(3, "sql", classSimpleName, "(siteRequest, a -> {");
					tl(4, "if(a.succeeded()) {");
					tl(5, "remplacer", classApiMethod, classSimpleName, "(siteRequest, b -> {");
					tl(6, "if(b.succeeded()) {");
					tl(7, classSimpleName, " ", StringUtils.uncapitalize(classSimpleName), " = b.result();");
					tl(7, "sql", classApiMethod, classSimpleName, "(", StringUtils.uncapitalize(classSimpleName), ", c -> {");
					tl(8, "if(c.succeeded()) {");
					tl(9, "definir", classSimpleName, "(", StringUtils.uncapitalize(classSimpleName), ", d -> {");
					tl(10, "if(d.succeeded()) {");
					tl(11, "attribuer", classSimpleName, "(", StringUtils.uncapitalize(classSimpleName), ", e -> {");
					tl(12, "if(e.succeeded()) {");
					tl(13, "indexer", classSimpleName, "(", StringUtils.uncapitalize(classSimpleName), ", f -> {");
					tl(14, "if(f.succeeded()) {");
					tl(15, "response200", classApiMethod, classSimpleName, "(", StringUtils.uncapitalize(classSimpleName), ", g -> {");
					tl(16, "if(g.succeeded()) {");
					tl(17, "SQLConnection sqlConnection = siteRequest.getConnexionSql();");
					tl(17, "sqlConnection.commit(h -> {");
					tl(18, "if(a.succeeded()) {");
					tl(19, "sqlConnection.close(i -> {");
					tl(20, "if(a.succeeded()) {");
					tl(21, "eventHandler.handle(Future.succeededFuture(g.result()));");
					tl(20, "} else {");
					tl(21, "erreur", classSimpleName, "(siteRequest, eventHandler, i);");
					tl(20, "}");
					tl(19, "});");
					tl(18, "} else {");
					tl(19, "erreur", classSimpleName, "(siteRequest, eventHandler, h);");
					tl(18, "}");
					tl(17, "});");
					tl(16, "} else {");
					tl(17, "erreur", classSimpleName, "(siteRequest, eventHandler, g);");
					tl(16, "}");
					tl(15, "});");
					tl(14, "} else {");
					tl(15, "erreur", classSimpleName, "(siteRequest, eventHandler, f);");
					tl(14, "}");
					tl(13, "});");
					tl(12, "} else {");
					tl(13, "erreur", classSimpleName, "(siteRequest, eventHandler, e);");
					tl(12, "}");
					tl(11, "});");
					tl(10, "} else {");
					tl(11, "erreur", classSimpleName, "(siteRequest, eventHandler, d);");
					tl(10, "}");
					tl(9, "});");
					tl(8, "} else {");
					tl(9, "erreur", classSimpleName, "(siteRequest, eventHandler, c);");
					tl(8, "}");
					tl(7, "});");
					tl(6, "} else {");
					tl(7, "erreur", classSimpleName, "(siteRequest, eventHandler, b);");
					tl(6, "}");
					tl(5, "});");
					tl(4, "} else {");
					tl(5, "erreur", classSimpleName, "(siteRequest, eventHandler, a);");
					tl(4, "}");
					tl(3, "});");
					tl(2, "} catch(Exception e) {");
					tl(3, "erreur", classSimpleName, "(null, eventHandler, Future.failedFuture(e));");
					tl(2, "}");
				}
				else if(classApiMethod.contains("DELETE")) {
					tl(2, "try {");
					tl(3, "SiteRequest siteRequest = genererSiteRequestPour", classSimpleName, "(siteContext, operationRequest);");
					tl(3, "sql", classSimpleName, "(siteRequest, a -> {");
					tl(4, "if(a.succeeded()) {");
					tl(5, "search", classSimpleName, "(siteRequest, false, true, ", "null", ", b -> {");
					tl(6, "if(b.succeeded()) {");
					tl(7, "ListeRecherche<", classSimpleName, "> liste", classSimpleName, " = b.result();");
					tl(7, "supprimer", classApiMethod, classSimpleName, "(siteRequest, c -> {");
					tl(8, "if(c.succeeded()) {");
					tl(9, "response200", classApiMethod, classSimpleName, "(siteRequest, d -> {");
					tl(10, "if(d.succeeded()) {");
					tl(11, "SQLConnection sqlConnection = siteRequest.getConnexionSql();");
					tl(11, "sqlConnection.commit(e -> {");
					tl(12, "if(e.succeeded()) {");
					tl(13, "sqlConnection.close(f -> {");
					tl(14, "if(f.succeeded()) {");
					tl(15, "eventHandler.handle(Future.succeededFuture(d.result()));");
					tl(14, "} else {");
					tl(15, "erreur", classSimpleName, "(siteRequest, eventHandler, f);");
					tl(14, "}");
					tl(13, "});");
					tl(12, "} else {");
					tl(13, "erreur", classSimpleName, "(siteRequest, eventHandler, e);");
					tl(12, "}");
					tl(11, "});");
					tl(10, "} else {");
					tl(11, "erreur", classSimpleName, "(siteRequest, eventHandler, d);");
					tl(10, "}");
					tl(9, "});");
					tl(8, "} else {");
					tl(9, "erreur", classSimpleName, "(siteRequest, eventHandler, c);");
					tl(8, "}");
					tl(7, "});");
					tl(6, "} else {");
					tl(7, "erreur", classSimpleName, "(siteRequest, eventHandler, b);");
					tl(6, "}");
					tl(5, "});");
					tl(4, "} else {");
					tl(5, "erreur", classSimpleName, "(siteRequest, eventHandler, a);");
					tl(4, "}");
					tl(3, "});");
					tl(2, "} catch(Exception e) {");
					tl(3, "erreur", classSimpleName, "(null, eventHandler, Future.failedFuture(e));");
					tl(2, "}");
				}
				tl(1, "}");

				if(classApiMethod.contains("Recherche")) {
//					l();
//					tl(1, "public Future<OperationResponse> listeRecherche", classSimpleName, "(ListeRecherche<", classSimpleName, "> liste", classSimpleName, ") {");
//					tl(2, "List<Future> futures = new ArrayList<>();");
//					tl(2, "liste", classSimpleName, ".getList().forEach(o -> {");
//					tl(3, "futures.add(");
//					tl(4, "sqlPATCH", classSimpleName, "(o).compose(");
//					tl(5, "b -> indexer", classSimpleName, "(o)");
//					tl(4, ")");
//					tl(3, ");");
//					tl(2, "});");
//					tl(2, "Future<OperationResponse> future = CompositeFuture.all(futures).compose( a -> ");
//					tl(3, "response200Recherche", classSimpleName, "(liste", classSimpleName, ")");
//					tl(2, ");");
//					tl(2, "return future;");
//					tl(1, "}");
				}
				if(classApiMethod.contains("POST")) {
					l();
					tl(1, "public void create", classApiMethod, classSimpleName, "(SiteRequest siteRequest, Handler<AsyncResult<", classSimpleName, ">> eventHandler) {");
					tl(2, "try {");
					tl(3, "SQLConnection sqlConnection = siteRequest.getConnexionSql();");
					tl(3, "String utilisateurId = siteRequest.getUtilisateurId();");
					l();
					tl(3, "sqlConnection.queryWithParams(");
					tl(5, "SiteContext.SQL_create");
					tl(5, ", new JsonArray(Arrays.asList(", classSimpleName, ".class.getCanonicalName(), utilisateurId))");
					tl(5, ", createAsync");
					tl(3, "-> {");
					tl(4, "JsonArray createLigne = createAsync.result().getResults().stream().findFirst().orElseGet(() -> null);");
					tl(4, "Long ", classVarPrimaryKey, " = createLigne.getLong(0);");
					tl(4, classSimpleName, " o = new ", classSimpleName, "();");
					tl(4, "o.set", StringUtils.capitalize(classVarPrimaryKey), "(", classVarPrimaryKey, ");");
					tl(4, "o.initLoin", classSimpleName, "(siteRequest);");
					tl(4, "eventHandler.handle(Future.succeededFuture(o));");
					tl(3, "});");
					tl(2, "} catch(Exception e) {");
					tl(3, "eventHandler.handle(Future.failedFuture(e));");
					tl(2, "}");
					tl(1, "}");
				}
				if(classApiMethod.contains("PATCH")) {
					l();
					tl(1, "public void liste", classApiMethod, classSimpleName, "(ListeRecherche<", classSimpleName, "> liste", classSimpleName, ", Handler<AsyncResult<OperationResponse>> eventHandler) {");
					tl(2, "List<Future> futures = new ArrayList<>();");
					tl(2, "liste", classSimpleName, ".getList().forEach(o -> {");
					tl(3, "futures.add(");
					tl(4, "sql", classApiMethod, classSimpleName, "(o).compose(");
					tl(5, "a -> definir", classApiMethod, classSimpleName, "(a).compose(");
					tl(6, "b -> indexer", classApiMethod, classSimpleName, "(b)");
					tl(5, ")");
					tl(4, ")");
					tl(3, ");");
					tl(2, "});");
					tl(2, "CompositeFuture.all(futures).setHandler( a -> {");
					tl(3, "if(a.succeeded()) {");
					tl(4, "response200", classApiMethod, classSimpleName, "(liste", classSimpleName, ", eventHandler);");
					tl(3, "} else {");
					tl(4, "erreur", classSimpleName, "(liste", classSimpleName, ".getSiteRequest_(), eventHandler, a);");
					tl(3, "}");
					tl(2, "});");
					tl(1, "}");
					l();
					tl(1, "public Future<", classSimpleName, "> sql", classApiMethod, classSimpleName, "(", classSimpleName, " o) {");
					tl(2, "Future<", classSimpleName, "> future = Future.future();");
					tl(2, "try {");
					tl(3, "SiteRequest siteRequest = o.getSiteRequest_();");
					tl(3, "SQLConnection sqlConnection = siteRequest.getConnexionSql();");
					tl(3, "Long ", classVarPrimaryKey, " = o.get", StringUtils.capitalize(classVarPrimaryKey), "();");
					tl(3, "JsonObject requeteJson = siteRequest.getJsonObject();");
					tl(3, "StringBuilder patchSql = new StringBuilder();");
					tl(3, "List<Object> patchSqlParams = new ArrayList<Object>();");
					tl(3, "Set<String> methodeNoms = requeteJson.fieldNames();");
					tl(3, classSimpleName, " o2 = new ", classSimpleName, "();");
					l();
					tl(3, "for(String methodeNom : methodeNoms) {");
					tl(4, "switch(methodeNom) {");
					s(wApiGeneratePatch.toString());
					tl(4, "}");
					tl(3, "}");
					tl(3, "sqlConnection.queryWithParams(");
					tl(5, "patchSql.toString()");
					tl(5, ", new JsonArray(patchSqlParams)");
					tl(5, ", patchAsync");
					tl(3, "-> {");
					tl(4, "o2.setSiteRequest_(o.getSiteRequest_());");
					tl(4, "o2.set", StringUtils.capitalize(classVarPrimaryKey), "(", classVarPrimaryKey, ");");
					tl(4, "future.complete(o2);");
					tl(3, "});");
					tl(3, "return future;");
					tl(2, "} catch(Exception e) {");
					tl(3, "return Future.failedFuture(e);");
					tl(2, "}");
					tl(1, "}");
					l();
					tl(1, "public Future<", classSimpleName, "> definir", classApiMethod, classSimpleName, "(", classSimpleName, " o) {");
					tl(2, "Future<", classSimpleName, "> future = Future.future();");
					tl(2, "try {");
					tl(3, "SiteRequest siteRequest = o.getSiteRequest_();");
					tl(3, "SQLConnection sqlConnection = siteRequest.getConnexionSql();");
					tl(3, "Long ", classVarPrimaryKey, " = o.get", StringUtils.capitalize(classVarPrimaryKey), "();");
					tl(3, "sqlConnection.queryWithParams(");
					tl(5, "SiteContext.SQL_definir");
					tl(5, ", new JsonArray(Arrays.asList(", classVarPrimaryKey, "))");
					tl(5, ", definirAsync");
					tl(3, "-> {");
					tl(4, "if(definirAsync.succeeded()) {");
					tl(5, "for(JsonArray definition : definirAsync.result().getResults()) {");
					tl(6, "o.definirPourClasse(definition.getString(0), definition.getString(1));");
					tl(5, "}");
					tl(5, "future.complete(o);");
					tl(4, "} else {");
					tl(3, "future.fail(definirAsync.cause());");
					tl(4, "}");
					tl(3, "});");
					tl(3, "return future;");
					tl(2, "} catch(Exception e) {");
					tl(3, "return Future.failedFuture(e);");
					tl(2, "}");
					tl(1, "}");
					l();
					tl(1, "public Future<Void> indexer", classApiMethod, classSimpleName, "(", classSimpleName, " o) {");
					tl(2, "Future<Void> future = Future.future();");
					tl(2, "try {");
					tl(3, "o.initLoinPourClasse(o.getSiteRequest_());");
					tl(3, "o.indexerPourClasse();");
					tl(4, "future.complete();");
					tl(3, "return future;");
					tl(2, "} catch(Exception e) {");
					tl(3, "return Future.failedFuture(e);");
					tl(2, "}");
					tl(1, "}");
				}
				if(classApiMethod.contains("PUT")) {
					l();
					tl(1, "public void remplacer", classApiMethod, classSimpleName, "(SiteRequest siteRequest, Handler<AsyncResult<", classSimpleName, ">> eventHandler) {");
					tl(2, "try {");
					tl(3, "SQLConnection sqlConnection = siteRequest.getConnexionSql();");
					tl(3, "String utilisateurId = siteRequest.getUtilisateurId();");
					tl(3, "Long pk = siteRequest.getRequetePk();");
					l();
					tl(3, "sqlConnection.queryWithParams(");
					tl(5, "SiteContext.SQL_vider");
					tl(5, ", new JsonArray(Arrays.asList(pk, ", classSimpleName, ".class.getCanonicalName(), pk, pk, pk))");
					tl(5, ", remplacerAsync");
					tl(3, "-> {");
					tl(4, classSimpleName, " o = new ", classSimpleName, "();");
					tl(4, "o.set", StringUtils.capitalize(classVarPrimaryKey), "(", classVarPrimaryKey, ");");
					tl(4, "eventHandler.handle(Future.succeededFuture(o));");
					tl(3, "});");
					tl(2, "} catch(Exception e) {");
					tl(3, "eventHandler.handle(Future.failedFuture(e));");
					tl(2, "}");
					tl(1, "}");
				}
				if(classApiMethod.contains("POST") || classApiMethod.contains("PUT")) {
					l();
					tl(1, "public void sql", classApiMethod, classSimpleName, "(", classSimpleName, " o, Handler<AsyncResult<OperationResponse>> eventHandler) {");
					tl(2, "try {");
					tl(3, "SiteRequest siteRequest = o.getSiteRequest_();");
					tl(3, "SQLConnection sqlConnection = siteRequest.getConnexionSql();");
					tl(3, "Long ", classVarPrimaryKey, " = o.get", StringUtils.capitalize(classVarPrimaryKey), "();");
					tl(3, "JsonObject jsonObject = siteRequest.getJsonObject();");
					tl(3, "StringBuilder postSql = new StringBuilder();");
					tl(3, "List<Object> postSqlParams = new ArrayList<Object>();");
					l();
					tl(3, "if(jsonObject != null) {");
					tl(4, "Set<String> entityVars = jsonObject.fieldNames();");
					tl(4, "for(String entityVar : entityVars) {");
					tl(5, "switch(entityVar) {");
					s(wApiGeneratePost.toString());
					tl(5, "}");
					tl(4, "}");
					tl(3, "}");
					tl(3, "sqlConnection.queryWithParams(");
					tl(5, "postSql.toString()");
					tl(5, ", new JsonArray(postSqlParams)");
					tl(5, ", postAsync");
					tl(3, "-> {");
					tl(4, "eventHandler.handle(Future.succeededFuture());");
					tl(3, "});");
					tl(2, "} catch(Exception e) {");
					tl(3, "eventHandler.handle(Future.failedFuture(e));");
					tl(2, "}");
					tl(1, "}");
				}
				if(classApiMethod.contains("GET")) {
				}
				if(classApiMethod.contains("DELETE")) {
					l();
					tl(1, "public void supprimer", classApiMethod, classSimpleName, "(SiteRequest siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {");
					tl(2, "try {");
					tl(3, "SQLConnection sqlConnection = siteRequest.getConnexionSql();");
					tl(3, "String utilisateurId = siteRequest.getUtilisateurId();");
					tl(3, "Long pk = siteRequest.getRequetePk();");
					l();
					tl(3, "sqlConnection.queryWithParams(");
					tl(5, "SiteContext.SQL_supprimer");
					tl(5, ", new JsonArray(Arrays.asList(pk, ", classSimpleName, ".class.getCanonicalName(), pk, pk, pk, pk))");
					tl(5, ", supprimerAsync");
					tl(3, "-> {");
					tl(4, "eventHandler.handle(Future.succeededFuture());");
					tl(3, "});");
					tl(2, "} catch(Exception e) {");
					tl(3, "eventHandler.handle(Future.failedFuture(e));");
					tl(2, "}");
					tl(1, "}");
				}
				l();
				t(1, "public void response200", classApiMethod, classSimpleName, "(");

				if(classApiMethod.contains("POST") || classApiMethod.contains("PUT"))
					s(classSimpleName, " o");
				else if(classApiMethod.contains("DELETE"))
					s("SiteRequest siteRequest");
				else
					s("ListeRecherche<", classSimpleName, "> liste", classSimpleName);

				l(", Handler<AsyncResult<OperationResponse>> eventHandler) {");

				tl(2, "try {");
				tl(3, "Buffer buffer = Buffer.buffer();");

				if(classApiMethod.contains("POST") || classApiMethod.contains("PUT")) {
					tl(3, "SiteRequest siteRequest = o.getSiteRequest_();");
				}
				else if(classApiMethod.contains("Recherche") || classApiMethod.contains("PATCH") || classApiMethod.contains("GET")) {
					tl(3, "SiteRequest siteRequest = liste", classSimpleName, ".getSiteRequest_();");
				}
				else {
				}

				t(3, "AllWriter w = AllWriter.create(");
				if(classApiMethod.contains("POST") || classApiMethod.contains("PUT"))
					s("o.getSiteRequest_()");
				else if(classApiMethod.contains("DELETE"))
					s("siteRequest");
				else
					s("liste", classSimpleName, ".getSiteRequest_()");
				l(", buffer);");
				tl(3, "siteRequest.setW(w);");


				if(classApiMethod.contains("GET")) {
					tl(3, "SolrDocumentList documentsSolr = liste", classSimpleName, ".getSolrDocumentList();");
					l();
				}
				if(classApiMethod.contains("Recherche")) {
				}

				if(classApiMethod.contains("Recherche") || classApiMethod.contains("GET")) {
				}
				else if(classApiMethod.contains("DELETE")) {
				}

				if(classApiMethod.contains("Recherche")) {
					if(classPageCanonicalNameMethod != null) {
						tl(3, classPageSimpleNameMethod, " page = new ", classPageSimpleNameMethod, "();");
						tl(3, "page.setPageUrl(\"", siteBaseUrl, classApiUri, "\");");
						tl(3, "SolrDocument pageDocumentSolr = new SolrDocument();");
						l();
						tl(3, "pageDocumentSolr.setField(", q("pageUri_frFR_stored_string"), ", ", q(classApiUriMethode), ");");
						tl(3, "page.setPageDocumentSolr(pageDocumentSolr);");
						tl(3, "page.setW(w);");
						tl(3, "page.setListe", classSimpleName, "(liste", classSimpleName, ");");
						tl(3, "page.initLoin", classPageSimpleNameMethod, "(siteRequest);");
						tl(3, "page.html();");
					}
					else {
						tl(3, "QueryResponse responseRecherche = liste", classSimpleName, ".getQueryResponse();");
						tl(3, "SolrDocumentList documentsSolr = liste", classSimpleName, ".getSolrDocumentList();");
						tl(3, "Long millisRecherche = Long.valueOf(responseRecherche.getQTime());");
						tl(3, "Long millisTransmission = responseRecherche.getElapsedTime();");
						tl(3, "Long numCommence = responseRecherche.getResults().getStart();");
						tl(3, "Long numTrouve = responseRecherche.getResults().getNumFound();");
						tl(3, "Integer numRetourne = responseRecherche.getResults().size();");
						tl(3, "String tempsRecherche = String.format(\"%d.%03d sec\", TimeUnit.MILLISECONDS.toSeconds(millisRecherche), TimeUnit.MILLISECONDS.toMillis(millisRecherche) - TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(millisRecherche)));");
						tl(3, "String tempsTransmission = String.format(\"%d.%03d sec\", TimeUnit.MILLISECONDS.toSeconds(millisTransmission), TimeUnit.MILLISECONDS.toMillis(millisTransmission) - TimeUnit.SECONDS.toSeconds(TimeUnit.MILLISECONDS.toSeconds(millisTransmission)));");
						tl(3, "Exception exceptionRecherche = responseRecherche.getException();");
						l();
						tl(3, "w.l(\"{\");");
						tl(3, "w.tl(1, ", q(q("numCommence"), ": "), ", numCommence);");
						tl(3, "w.tl(1, ", q(", ", q("numTrouve"), ": "), ", numTrouve);");
						tl(3, "w.tl(1, ", q(", ", q("numRetourne"), ": "), ", numRetourne);");
						tl(3, "w.tl(1, ", q(", ", q("tempsRecherche"), ": "), ", w.q(tempsRecherche));");
						tl(3, "w.tl(1, ", q(", ", q("tempsTransmission"), ": "), ", w.q(tempsTransmission));");
						tl(3, "w.tl(1, ", q(", ", q("liste"), ": ["), ");");
						tl(3, "for(int i = 0; i < liste", classSimpleName, ".size(); i++) {");
						tl(4, classSimpleName, " o = liste", classSimpleName, ".getList().get(i);");
						tl(4, "Object entiteValeur;");
						tl(4, "Integer entiteNumero = 0;");
	//					tl(4, "List<String> champNoms = new ArrayList<>(documentSolr.getFieldNames());");
						l();
						tl(4, "w.t(2);");
						tl(4, "if(i > 0)");
						tl(5, "w.s(", q(", "), ");");
						tl(4, "w.l(", q("{"), ");");
	//					tl(4, "for(int j = 0; j < champNoms.size(); j++) {");
	//					tl(5, "String entityVarStocke = champNoms.get(j);");
	//					tl(5, "List<Object> entiteValeurs = new ArrayList<>(documentSolr.getFieldValues(entityVarStocke));");
						s(wApiGenerateGet.toString());
	//					tl(4, "}");
						l();
						tl(4, "w.tl(2, ", q("}"), ");");
						tl(3, "}");
						tl(3, "w.tl(1, ", q("]"), ");");
						tl(3, "if(exceptionRecherche != null) {");
						tl(4, "w.tl(1, ", q(", ", q("exceptionRecherche"), ": "), ", w.q(exceptionRecherche.getMessage()));");
						tl(3, "}");
						tl(3, "w.l(\"}\");");
					}
				}
				if(classApiMethod.contains("GET")) {
					if(classPageCanonicalNameMethod != null) {
						tl(3, classPageSimpleNameMethod, " page = new ", classPageSimpleNameMethod, "();");
						tl(3, "page.setPageUrl(\"", siteBaseUrl, classApiUri, "\");");
						tl(3, "SolrDocument pageDocumentSolr = new SolrDocument();");
						tl(3, "SiteRequest siteRequest = liste", classSimpleName, ".getSiteRequest_();");
						l();
						tl(3, "pageDocumentSolr.setField(", q("pageUri_frFR_stored_string"), ", ", q(classApiUriMethode), ");");
						tl(3, "page.setPageDocumentSolr(pageDocumentSolr);");
						tl(3, "page.setW(w);");
						tl(3, "page.initLoin", classPageSimpleNameMethod, "(siteRequest);");
						tl(3, "page.html();");
					}
					else {
						tl(3, "if(liste", classSimpleName, ".size() > 0) {");
						tl(4, "SolrDocument documentSolr = documentsSolr.get(0);");
						tl(4, classSimpleName, " o = liste", classSimpleName, ".get(0);");
						tl(4, "Object entiteValeur;");
						tl(4, "Integer entiteNumero = 0;");
						l();
						tl(4, "w.l(", q("{"), ");");
	//					tl(4, "for(int j = 0; j < champNoms.size(); j++) {");
	//					tl(5, "String entityVarStocke = champNoms.get(j);");
	//					tl(5, "List<Object> entiteValeurs = new ArrayList<>(documentSolr.getFieldValues(entityVarStocke));");
						s(wApiGenerateGet.toString());
	//					tl(4, "}");
						l();
						tl(4, "w.l(", q("}"), ");");
						tl(3, "}");
					}
				}

				if((classApiMethod.contains("GET") || classApiMethod.contains("Recherche")) && classPageCanonicalNameMethod != null) {
					tl(3, "eventHandler.handle(Future.succeededFuture(new OperationResponse(200, \"OK\", buffer, new CaseInsensitiveHeaders())));");
				}
				else {
					tl(3, "eventHandler.handle(Future.succeededFuture(OperationResponse.completedWithJson(buffer)));");
				}

				tl(2, "} catch(Exception e) {");
				tl(3, "eventHandler.handle(Future.failedFuture(e));");
				tl(2, "}");
				tl(1, "}");
			}
	
			s(wApiEntities.toString());

			l();
			tl(1, "public String varIndexe", classSimpleName, "(String entityVar) {");
			tl(2, "switch(entityVar) {");
			{
				SolrQuery searchSolr = new SolrQuery();   
				searchSolr.setQuery("*:*");
				searchSolr.setRows(1000000);
				String fqClassesSuperEtMoi = "(" + entiteClassesSuperEtMoiSansGen.stream().map(c -> ClientUtils.escapeQueryChars(c)).collect(Collectors.joining(" OR ")) + ")";
				searchSolr.addFilterQuery("partEstEntite_indexed_boolean:true");
				searchSolr.addFilterQuery("classeNomCanonique_" + languageName + "_indexed_string:" + fqClassesSuperEtMoi);
				QueryResponse searchReponse = clientSolrComputate.query(searchSolr);
				SolrDocumentList searchListe = searchReponse.getResults();
				Integer searchLignes = searchSolr.getRows();
	
				if(searchListe.size() > 0) {
					for(Long i = searchListe.getStart(); i < searchListe.getNumFound(); i+=searchLignes) {
						for(Integer j = 0; j < searchListe.size(); j++) {
							SolrDocument entiteDocumentSolr = searchListe.get(j);
							entityVar = (String)entiteDocumentSolr.get("entityVar_" + languageName + "_stored_string");
							entiteSuffixeType = (String)entiteDocumentSolr.get("entiteSuffixeType_stored_string");
							entiteIndexe = (Boolean)entiteDocumentSolr.get("entiteIndexe_stored_boolean");

							if(classeIndexe && entiteIndexe) {
								tl(3, "case \"", entityVar, "\":");
								tl(4, "return \"", entityVar, "_indexed", entiteSuffixeType, "\";");
							}
						}
						searchSolr.setStart(i.intValue() + searchLignes);
						searchReponse = clientSolrComputate.query(searchSolr);
						searchListe = searchReponse.getResults();
					}
				}
			}

			tl(3, "default:");
			tl(4, "throw new RuntimeException(String.format(\"\\\"%s\\\" n'est pas une entité indexé. \", entityVar));");
			tl(2, "}");
			tl(1, "}");
			l();
			tl(1, "// Partagé //");
			l();
			tl(1, "public void erreur", classSimpleName, "(SiteRequest siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler, AsyncResult<?> resultatAsync) {");
			tl(2, "Throwable e = resultatAsync.cause();");
			tl(2, "ExceptionUtils.printRootCauseStackTrace(e);");
			tl(2, "OperationResponse operationResponse = new OperationResponse(400, \"BAD REQUEST\", ");
			tl(3, "Buffer.buffer().appendString(");
			tl(4, "new JsonObject() {{");
			tl(5, "put(\"erreur\", new JsonObject() {{");
			tl(5, "put(\"message\", e.getMessage());");
			tl(5, "}});");
			tl(4, "}}.encodePrettily()");
			tl(3, ")");
			tl(3, ", new CaseInsensitiveHeaders()");
			tl(2, ");");
			tl(2, "if(siteRequest != null) {");
			tl(3, "SQLConnection sqlConnection = siteRequest.getConnexionSql();");
			tl(3, "if(sqlConnection != null) {");
			tl(4, "sqlConnection.rollback(a -> {");
			tl(5, "if(a.succeeded()) {");
			tl(6, "sqlConnection.close(b -> {");
			tl(7, "if(a.succeeded()) {");
			tl(8, "eventHandler.handle(Future.succeededFuture(operationResponse));");
			tl(7, "} else {");
			tl(8, "eventHandler.handle(Future.succeededFuture(operationResponse));");
			tl(7, "}");
			tl(6, "});");
			tl(5, "} else {");
			tl(6, "eventHandler.handle(Future.succeededFuture(operationResponse));");
			tl(5, "}");
			tl(4, "});");
			tl(3, "} else {");
			tl(4, "eventHandler.handle(Future.succeededFuture(operationResponse));");
			tl(3, "}");
			tl(2, "} else {");
			tl(3, "eventHandler.handle(Future.succeededFuture(operationResponse));");
			tl(2, "}");
			tl(1, "}");
			l();
			tl(1, "public void sql", classSimpleName, "(SiteRequest siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {");
			tl(2, "try {");
			tl(3, "SQLClient clientSql = siteRequest.getSiteContext_().getClientSql();");
			l();
			tl(3, "clientSql.getConnection(sqlAsync -> {");
			tl(4, "if(sqlAsync.succeeded()) {");
			tl(5, "SQLConnection sqlConnection = sqlAsync.result();");
			tl(5, "sqlConnection.setAutoCommit(false, a -> {");
			tl(6, "if(a.succeeded()) {");
			tl(7, "siteRequest.setConnexionSql(sqlConnection);");
			tl(7, "eventHandler.handle(Future.succeededFuture());");
			tl(6, "} else {");
			tl(7, "eventHandler.handle(Future.failedFuture(a.cause()));");
			tl(6, "}");
			tl(5, "});");
			tl(4, "} else {");
			tl(5, "eventHandler.handle(Future.failedFuture(sqlAsync.cause()));");
			tl(4, "}");
			tl(3, "});");
			tl(2, "} catch(Exception e) {");
			tl(3, "eventHandler.handle(Future.failedFuture(e));");
			tl(2, "}");
			tl(1, "}");
			l();
	//		tl(1, "public SiteRequest genererSiteRequestPour", classSimpleName, "(SiteContext siteContext, RoutingContext contexteItineraire) {");
			tl(1, "public SiteRequest genererSiteRequestPour", classSimpleName, "(SiteContext siteContext, OperationRequest operationRequest) {");
			tl(2, "return genererSiteRequestPour", classSimpleName, "(siteContext, operationRequest, null);");
			tl(1, "}");
			l();
			tl(1, "public SiteRequest genererSiteRequestPour", classSimpleName, "(SiteContext siteContext, OperationRequest operationRequest, JsonObject body) {");
			tl(2, "Vertx vertx = siteContext.getVertx();");
			tl(2, "SiteRequest siteRequest = new SiteRequest();");
			tl(2, "siteRequest.setJsonObject(body);");
			tl(2, "siteRequest.setVertx(vertx);");
	//		tl(2, "siteRequest.setContexteItineraire(contexteItineraire);");
			tl(2, "siteRequest.setSiteContext_(siteContext);");
			tl(2, "siteRequest.setSiteConfig_(siteContext.getSiteConfig());");
			tl(2, "siteRequest.setOperationRequete(operationRequest);");
			tl(2, "siteRequest.initLoinSiteRequest(siteRequest);");
			l();
			tl(2, "return siteRequest;");
			tl(1, "}");
			l();
			tl(1, "public void utilisateur", classSimpleName, "(SiteRequest siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {");
			tl(2, "try {");
			tl(3, "SQLConnection sqlConnection = siteRequest.getConnexionSql();");
			tl(3, "String utilisateurId = siteRequest.getUtilisateurId();");
			tl(3, "if(utilisateurId == null) {");
			tl(4, "eventHandler.handle(Future.succeededFuture());");
			tl(3, "} else {");
			tl(4, "sqlConnection.queryWithParams(");
			tl(6, "SiteContext.SQL_selectC");
			tl(6, ", new JsonArray(Arrays.asList(", q(classPartsUtilisateurSite.canonicalName), ", utilisateurId))");
			tl(6, ", selectCAsync");
			tl(4, "-> {");
			tl(5, "if(selectCAsync.succeeded()) {");
//					tl(4, "entiteValeur = Optional.ofNullable(documentSolr.getFieldValues(", q(entityVar, "_stored", entiteSuffixeType), ")).map(Collection<Object>::stream).orElseGet(Stream::empty).findFirst().orElse(null);");
			tl(6, "JsonArray userValues = selectCAsync.result().getResults().stream().findFirst().orElse(null);");
			tl(6, "if(userValues == null) {");
			tl(7, "sqlConnection.queryWithParams(");
			tl(9, "SiteContext.SQL_create");
			tl(9, ", new JsonArray(Arrays.asList(UtilisateurSite.class.getCanonicalName(), utilisateurId))");
			tl(9, ", createAsync");
			tl(7, "-> {");
			tl(8, "JsonArray createLigne = createAsync.result().getResults().stream().findFirst().orElseGet(() -> null);");
			tl(8, "Long ", classVarPrimaryKey, "Utilisateur = createLigne.getLong(0);");
			tl(8, "UtilisateurSite utilisateurSite = new UtilisateurSite();");
			tl(8, "utilisateurSite.set", StringUtils.capitalize(classVarPrimaryKey), "(", classVarPrimaryKey, "Utilisateur);");
			l();
			tl(8, "sqlConnection.queryWithParams(");
			tl(10, "SiteContext.SQL_definir");
			tl(10, ", new JsonArray(Arrays.asList(", classVarPrimaryKey, "Utilisateur))");
			tl(10, ", definirAsync");
			tl(8, "-> {");
			tl(9, "if(definirAsync.succeeded()) {");
			tl(10, "try {");
			tl(11, "for(JsonArray definition : definirAsync.result().getResults()) {");
			tl(12, "utilisateurSite.definirPourClasse(definition.getString(0), definition.getString(1));");
			tl(11, "}");
			tl(11, "JsonObject utilisateurVertx = siteRequest.getOperationRequete().getUser();");
			tl(11, "JsonObject principalJson = KeycloakHelper.parseToken(utilisateurVertx.getString(\"access_token\"));");
			tl(11, "utilisateurSite.setUtilisateurNom(principalJson.getString(\"preferred_username\"));");
			tl(11, "utilisateurSite.setUtilisateurPrenom(principalJson.getString(\"given_name\"));");
			tl(11, "utilisateurSite.setUtilisateurNomFamille(principalJson.getString(\"family_name\"));");
			tl(11, "utilisateurSite.setUtilisateurId(principalJson.getString(\"sub\"));");
			tl(11, "utilisateurSite.initLoinPourClasse(siteRequest);");
			tl(11, "utilisateurSite.indexerPourClasse();");
			tl(11, "siteRequest.setUtilisateurSite(utilisateurSite);");
			tl(11, "eventHandler.handle(Future.succeededFuture());");
			tl(10, "} catch(Exception e) {");
			tl(11, "eventHandler.handle(Future.failedFuture(e));");
			tl(10, "}");
			tl(9, "} else {");
			tl(10, "eventHandler.handle(Future.failedFuture(definirAsync.cause()));");
			tl(9, "}");
			tl(8, "});");

			tl(7, "});");
			tl(6, "} else {");
			tl(7, "Long ", classVarPrimaryKey, "Utilisateur = userValues.getLong(0);");
			tl(7, "UtilisateurSite utilisateurSite = new UtilisateurSite();");
			tl(7, "utilisateurSite.set", StringUtils.capitalize(classVarPrimaryKey), "(", classVarPrimaryKey, "Utilisateur);");
			l();
			tl(7, "sqlConnection.queryWithParams(");
			tl(9, "SiteContext.SQL_definir");
			tl(9, ", new JsonArray(Arrays.asList(", classVarPrimaryKey, "Utilisateur))");
			tl(9, ", definirAsync");
			tl(7, "-> {");
			tl(8, "if(definirAsync.succeeded()) {");
			tl(9, "for(JsonArray definition : definirAsync.result().getResults()) {");
			tl(10, "utilisateurSite.definirPourClasse(definition.getString(0), definition.getString(1));");
			tl(9, "}");
			tl(9, "JsonObject utilisateurVertx = siteRequest.getOperationRequete().getUser();");
			tl(9, "JsonObject principalJson = KeycloakHelper.parseToken(utilisateurVertx.getString(\"access_token\"));");
			tl(9, "utilisateurSite.setUtilisateurNom(principalJson.getString(\"preferred_username\"));");
			tl(9, "utilisateurSite.setUtilisateurPrenom(principalJson.getString(\"given_name\"));");
			tl(9, "utilisateurSite.setUtilisateurNomFamille(principalJson.getString(\"family_name\"));");
			tl(9, "utilisateurSite.setUtilisateurId(principalJson.getString(\"sub\"));");
			tl(9, "utilisateurSite.initLoinPourClasse(siteRequest);");
			tl(9, "siteRequest.setUtilisateurSite(utilisateurSite);");
			tl(9, "eventHandler.handle(Future.succeededFuture());");
			tl(8, "} else {");
			tl(9, "eventHandler.handle(Future.failedFuture(definirAsync.cause()));");
			tl(8, "}");
			tl(7, "});");

			tl(6, "}");
			tl(5, "} else {");
			tl(6, "eventHandler.handle(Future.failedFuture(selectCAsync.cause()));");
			tl(5, "}");
			tl(4, "});");
			tl(3, "}");
			tl(2, "} catch(Exception e) {");
			tl(3, "eventHandler.handle(Future.failedFuture(e));");
			tl(2, "}");
			tl(1, "}");
			l();
			tl(1, "public void search", classSimpleName, "(SiteRequest siteRequest, Boolean peupler, Boolean stocker, String classApiUriMethode, Handler<AsyncResult<ListeRecherche<", classSimpleName, ">>> eventHandler) {");
			tl(2, "try {");
			tl(3, "OperationRequest operationRequest = siteRequest.getOperationRequete();");
			tl(3, "String entiteListeStr = siteRequest.getOperationRequete().getParams().getJsonObject(", q("query"), ").getString(", q("fl"), ");");
			tl(3, "String[] entiteListe = entiteListeStr == null ? null : entiteListeStr.split(", q(",\\s*"), ");");
			tl(3, "ListeRecherche<", classSimpleName, "> listeRecherche = new ListeRecherche<", classSimpleName, ">();");
			tl(3, "listeRecherche.setPeupler(peupler);");
			tl(3, "listeRecherche.setStocker(stocker);");
			tl(3, "listeRecherche.setQuery(\"*:*\");");
			tl(3, "listeRecherche.setC(", classSimpleName, ".class);");
			tl(3, "listeRecherche.setRows(1000000);");
			tl(3, "if(entiteListe != null)");
			tl(3, "listeRecherche.setFields(entiteListe);");
			tl(3, "listeRecherche.addSort(\"archive_indexed_boolean\", ORDER.asc);");
			tl(3, "listeRecherche.addSort(\"supprime_indexed_boolean\", ORDER.asc);");
			l();
			tl(3, "String pageUri = null;");
			tl(3, "String id = operationRequest.getParams().getJsonObject(\"path\").getString(\"id\");");
			tl(3, "if(", classeVarCleUnique, " != null) {");
			tl(4, "pageUri = classApiUriMethode + ", q("/"), " + id;");
			tl(4, "listeRecherche.addFilterQuery(\"pageUri_indexed_string:\" + ClientUtils.escapeQueryChars(pageUri));");
			tl(3, "}");
			l();
			tl(3, "operationRequest.getParams().getJsonObject(\"query\").forEach(queryParam -> {");
			tl(4, "String entityVar = null;");
			tl(4, "String valeurIndexe = null;");
			tl(4, "String varIndexe = null;");
			tl(4, "String valeurTri = null;");
			tl(4, "Integer searchDebut = null;");
			tl(4, "Integer searchNum = null;");
			tl(4, "String paramNom = queryParam.getKey();");
			tl(4, "Object paramValuesObject = queryParam.getValue();");
			tl(4, "JsonArray paramObjects = paramValuesObject instanceof JsonArray ? (JsonArray)paramValuesObject : new JsonArray().add(paramValuesObject);");
			l();
			tl(4, "for(Object paramObject : paramObjects) {");
			tl(5, "switch(paramNom) {");
	
			tl(6, "case \"q\":");
			tl(7, "entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, \":\"));");
			tl(7, "valeurIndexe = StringUtils.trim(StringUtils.substringAfter((String)paramObject, \":\"));");
			tl(7, "varIndexe = \"*\".equals(entityVar) ? entityVar : varIndexe", classSimpleName, "(entityVar);");
			tl(7, "listeRecherche.setQuery(varIndexe + \":\" + (\"*\".equals(valeurIndexe) ? valeurIndexe : ClientUtils.escapeQueryChars(valeurIndexe)));");
			tl(7, "break;");
	
			tl(6, "case \"fq\":");
			tl(7, "entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, \":\"));");
			tl(7, "valeurIndexe = StringUtils.trim(StringUtils.substringAfter((String)paramObject, \":\"));");
			tl(7, "varIndexe = varIndexe", classSimpleName, "(entityVar);");
			tl(7, "listeRecherche.addFilterQuery(varIndexe + \":\" + ClientUtils.escapeQueryChars(valeurIndexe));");
			tl(7, "break;");
	
			tl(6, "case \"sort\":");
			tl(7, "entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, \" \"));");
			tl(7, "valeurTri = StringUtils.trim(StringUtils.substringAfter((String)paramObject, \" \"));");
			tl(7, "varIndexe = varIndexe", classSimpleName, "(entityVar);");
			tl(7, "listeRecherche.addSort(varIndexe, ORDER.valueOf(valeurTri));");
			tl(7, "break;");
	
			tl(6, "case \"fl\":");
			tl(7, "entityVar = StringUtils.trim((String)paramObject);");
			tl(7, "varIndexe = varIndexe", classSimpleName, "(entityVar);");
			tl(7, "listeRecherche.addField(varIndexe);");
			tl(7, "break;");
	
			tl(6, "case \"start\":");
			tl(7, "searchDebut = (Integer)paramObject;");
			tl(7, "listeRecherche.setStart(searchDebut);");
			tl(7, "break;");
	
			tl(6, "case \"rows\":");
			tl(7, "searchNum = (Integer)paramObject;");
			tl(7, "listeRecherche.setRows(searchNum);");
			tl(7, "break;");
	
			tl(5, "}");
	
			tl(4, "}");
			tl(3, "});");
			tl(3, "listeRecherche.initLoinPourClasse(siteRequest);");
			tl(3, "eventHandler.handle(Future.succeededFuture(listeRecherche));");
			tl(2, "} catch(Exception e) {");
			tl(3, "eventHandler.handle(Future.failedFuture(e));");
			tl(2, "}");
			tl(1, "}");
			l();
			tl(1, "public void definir", classSimpleName, "(", classSimpleName, " o, Handler<AsyncResult<OperationResponse>> eventHandler) {");
			tl(2, "try {");
			tl(3, "SiteRequest siteRequest = o.getSiteRequest_();");
			tl(3, "SQLConnection sqlConnection = siteRequest.getConnexionSql();");
			tl(3, "Long ", classVarPrimaryKey, " = o.get", StringUtils.capitalize(classVarPrimaryKey), "();");
			tl(3, "sqlConnection.queryWithParams(");
			tl(5, "SiteContext.SQL_definir");
			tl(5, ", new JsonArray(Arrays.asList(", classVarPrimaryKey, "))");
			tl(5, ", definirAsync");
			tl(3, "-> {");
			tl(4, "if(definirAsync.succeeded()) {");
			tl(5, "for(JsonArray definition : definirAsync.result().getResults()) {");
			tl(6, "o.definirPourClasse(definition.getString(0), definition.getString(1));");
			tl(5, "}");
			tl(5, "eventHandler.handle(Future.succeededFuture());");
			tl(4, "} else {");
			tl(5, "eventHandler.handle(Future.failedFuture(definirAsync.cause()));");
			tl(4, "}");
			tl(3, "});");
			tl(2, "} catch(Exception e) {");
			tl(3, "eventHandler.handle(Future.failedFuture(e));");
			tl(2, "}");
			tl(1, "}");
			l();
			tl(1, "public void attribuer", classSimpleName, "(", classSimpleName, " o, Handler<AsyncResult<OperationResponse>> eventHandler) {");
			tl(2, "try {");
			tl(3, "SiteRequest siteRequest = o.getSiteRequest_();");
			tl(3, "SQLConnection sqlConnection = siteRequest.getConnexionSql();");
			tl(3, "Long ", classVarPrimaryKey, " = o.get", StringUtils.capitalize(classVarPrimaryKey), "();");
			tl(3, "sqlConnection.queryWithParams(");
			tl(5, "SiteContext.SQL_attribuer");
			tl(5, ", new JsonArray(Arrays.asList(", classVarPrimaryKey, ", ", classVarPrimaryKey, "))");
			tl(5, ", attribuerAsync");
			tl(3, "-> {");
			tl(4, "if(attribuerAsync.succeeded()) {");
			tl(5, "if(attribuerAsync.result() != null) {");
			tl(6, "for(JsonArray definition : attribuerAsync.result().getResults()) {");
			tl(7, "o.attribuerPourClasse(definition.getString(0), definition.getString(1));");
			tl(6, "}");
			tl(5, "}");
			tl(5, "eventHandler.handle(Future.succeededFuture());");
			tl(4, "} else {");
			tl(5, "eventHandler.handle(Future.failedFuture(attribuerAsync.cause()));");
			tl(4, "}");
			tl(3, "});");
			tl(2, "} catch(Exception e) {");
			tl(3, "eventHandler.handle(Future.failedFuture(e));");
			tl(2, "}");
			tl(1, "}");
			l();
			tl(1, "public void indexer", classSimpleName, "(", classSimpleName, " o, Handler<AsyncResult<OperationResponse>> eventHandler) {");
			tl(2, "SiteRequest siteRequest = o.getSiteRequest_();");
			tl(2, "try {");
			tl(3, "o.initLoinPourClasse(siteRequest);");
			tl(3, "o.indexerPourClasse();");
			tl(3, "eventHandler.handle(Future.succeededFuture());");
			tl(2, "} catch(Exception e) {");
			tl(3, "eventHandler.handle(Future.failedFuture(e));");
			tl(2, "}");
			tl(1, "}");
	
			tl(0, "}");

			writerGenApiServiceImpl.flushClose();
			System.out.println("Write: " + classPathGenApiServiceImpl); 
		}
	}
}
