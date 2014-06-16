<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" >
	<head>
		<title>LISM</title>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<link rel="stylesheet" media="screen" type="text/css" title="Design" href="${pageContext.request.contextPath}/resources/css/style.css" />
		<!--[if IE 6]><link rel="stylesheet" media="screen" type="text/css" title="Design" href="${pageContext.request.contextPath}/inc/ie6.css" /> <![endif]-->
		<!--[if IE 7]> <style type="text/css">
			.groupe_lien_MH{display : inline;margin-left:0px;}
			.sublien_MH{height : 37px;width : 120px;}
		</style> <![endif]-->
		<script src="${pageContext.request.contextPath}/resources/js/jquery-1.7.1.min.js" type="text/javascript"></script>
		<!--[if IE 6]>
			<script type="text/javascript">
				$(function()
				{
					$(
					b$'.groupe_lien_MH').hover
					(s
						function()
						{
							$(this).addClass('groupe_lien_MH_hover');
						},
						function()
						{
							$(this).removeClass('groupe_lien_MH_hover');
						}
					);
				}
				);
			</script>
		<![endif]-->
		<script type="text/javascript">
			animation_complete=function(){jQuery(this).hide();}
			jquery_MH_deroulant=function()
			{ 
				$(".groupe_lien_MH").mouseenter
				(
					function () 
					{
						$groupe_sublien=jQuery(this).find(".groupe_sublien_MH");
						$sublien=jQuery(this).find(".sublien_MH a");
						$bottom=jQuery(this).find(".MH_deroulant_bottom");
						$top=jQuery(this).find(".MH_deroulant_top");
						if ($groupe_sublien.is(":hidden") || $sublien.is(":hidden") )
						{
							$sublien.hide();
							$bottom.hide();
							$top.hide();
							$groupe_sublien.css({'height':'0px','width':$sublien.innerWidth()}).show();
							//IE8 does not support fadind to 100% and on imbricated div
							//therefore each element must be faded individually to 99%
							$sublien.fadeTo(400,0.99);
							$bottom.fadeTo(400,0.99);
							$top.fadeTo(400,0.99);
							$groupe_sublien.animate({height: $sublien.size()*$sublien.innerHeight() + $bottom.innerHeight() + $top.innerHeight()}, 400);
						} 
					}
				);
				$(".groupe_lien_MH").mouseleave
				(
					function ()
					{
						$sublien=jQuery(this).find(".sublien_MH a");
						$groupe_sublien=jQuery(this).find(".groupe_sublien_MH");
						if (!$groupe_sublien.is(":hidden"))
						{
							jQuery(this).find(".groupe_sublien_MH").animate({height:'0px'},{duration : 400, complete : animation_complete});
							$sublien.animate({opacity:'hide'},{duration : 400});
							$bottom.animate({opacity:'hide'},{duration : 400});
							$top.animate({opacity:'hide'},{duration : 400});
						}
					}
				);
			}
		</script>
	</head>

	<body onload="jquery_MH_deroulant();">

		<div id="conteneur">

			<div id="CHG"></div><div id="CHD"></div><div id="BH"></div>
			<div id="BG"><div id="BD">

				<div id="corps">
					<div id="marge_interieure">

						<div id="banniere"><div id="logo"></div></div>

						<div id="MH">
							<div class="groupe_lien_MH">
								<a class="menu_MH" href="connexion">Accueil</a>
								<!-- <div class="groupe_sublien_MH">
									<div class="sublien_MH">
										<a href="#">Sous-menu 1</a>
									</div>
									<div class="sublien_MH">
										<a href="#">Sous-menu 2</a>
									</div>
									<div class="sublien_MH">
										<a href="#">Sous-menu 3</a>
									</div>
									<div class="MH_deroulant_bottom"></div>
								</div> -->
							</div>
							<c:if test="${utilisateur.role == 'etudiant'}">
							<div class="groupe_lien_MH">
								<a class="menu_MH">Cours</a>
								<div class="groupe_sublien_MH">
									<div class="sublien_MH">
										<a href="myCourses">Mes cours</a>
									</div>
									<div class="sublien_MH">
										<a href="courses">Inscription</a>
									</div>
									<div class="sublien_MH">
										<a href="#">Sous-menu 3</a>
									</div>
									<div class="MH_deroulant_bottom"></div>
								</div>
							</div>
							<div class="groupe_lien_MH">
								<a class="menu_MH" href="#">Evaluations</a>
								<div class="groupe_sublien_MH">
									<div class="sublien_MH">
										<a href="prochainEval" style="font-size: x-small;">Mes prochaines �valuations</a>
									</div>
									<div class="sublien_MH">
										<a href="evalSession">Inscription</a>
									</div>
									<div class="sublien_MH">
										<a href="mesResultats">Mes r�sultats</a>
									</div>
									<div class="MH_deroulant_bottom"></div>
								</div>
							</div>
							</c:if>
							<c:if test="${utilisateur.role == 'enseignant'}">
							<div class="groupe_lien_MH">
								<a class="menu_MH" href="#">Professeur</a>
								<div class="groupe_sublien_MH">
									<div class="sublien_MH">
										<a href="#">Ajouter notes</a>
									</div>
									<div class="sublien_MH">
										<a href="#">D�poser contenu</a>
									</div>
									<div class="sublien_MH">
										<a href="#" style="font-size: x-small;">Ajouter une �valuation</a>
									</div>
									<div class="sublien_MH">
										<a href="#">D�poser notes</a>
									</div>
									<div class="MH_deroulant_bottom"></div>
								</div>
							</div>
							</c:if>
							<c:if test="${utilisateur.role == 'administrateur'}">
							<div class="groupe_lien_MH">
								<a class="menu_MH" href="#">Gestion professeur</a>
								<div class="groupe_sublien_MH">
									<div class="sublien_MH">
										<a href="addEnseignant">Ajouter professeur</a>
									</div>
									<div class="sublien_MH">
										<a href="delEnseignant" style="font-size: x-small;">Supprimer professeur</a>
									</div>
									<div class="sublien_MH">
										<a href="#" style="font-size: x-small;">Ajouter cours � professeur</a>
									</div>
									<div class="MH_deroulant_bottom"></div>
								</div>
							</div>
							<div class="groupe_lien_MH">
								<a class="menu_MH" href="#">Gestion �tudiant</a>
								<div class="groupe_sublien_MH">
									<div class="sublien_MH">
										<a href="addEtudiant">Ajouter �tudiant</a>
									</div>
									<div class="sublien_MH">
										<a href="delEtudiant" style="font-size: x-small;">Supprimer �tudiant</a>
									</div>
									<!-- <div class="sublien_MH">
										<a href="#" style="font-size: x-small;">Ajouter cours � professeur</a>
									</div> -->
									<div class="MH_deroulant_bottom"></div>
								</div>
							</div>
							</c:if>
							<div class="groupe_lien_MH">
								<a class="menu_MH" href="#">Mon compte</a>
								<div class="groupe_sublien_MH">
									<div class="sublien_MH">
										<a href="#">Sous-menu 1</a>
									</div>
									<div class="sublien_MH">
										<a href="#">Sous-menu 2</a>
									</div>
									<div class="sublien_MH">
										<a href="deconnexion">D�connexion</a>
									</div>
									<div class="MH_deroulant_bottom"></div>
								</div>
							</div>
						</div>
						
						<div id="texte"><div id="overflow">
							<div class="cadre">
							
							<!-- D�but de la zone de texte -->