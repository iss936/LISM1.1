function surligne(champ, erreur)
{
   if(erreur)
      champ.style.backgroundColor = "#FFD9CF";
   else
      champ.style.backgroundColor = "";
}

function verifPrenom(champ)
{
   var regex = /^[a-zA-Z\ \']+$/;
   if(!regex.test(champ.value))
   {
	  surligne(champ, true);
      alert("Le champ [Prénom] ne doit contenir que des lettres.");
      document.addEnseignant.prenom.focus();
      return false;
   }
   else
   {
      surligne(champ, false);
      return true;
   }
}

function verifNom(champ)
{
   var regex = /^[a-zA-Z\ \']+$/;
   if(!regex.test(champ.value))
   {
	  surligne(champ, true);
      alert("Le champ [Nom] ne doit contenir que des lettres.");
      document.addEnseignant.nom.focus();
      return false;
   }
   else
   {
      surligne(champ, false);
      return true;
   }
}

function verifLogin(champ)
{
	var regex = /^[0-9a-zA-Z]+$/;
	if(!regex.test(champ.value))
	{
		surligne(champ, true);
		alert("Le champ [Login] ne doit pas contenir de caractères spéciaux.");
		document.addEnseignant.login.focus();
		return false;
	}
	else
	   {
	      surligne(champ, false);
	      return true;
	   }
}
 
function verifConfirmationMdp(champ)
{
	if(champ.value != document.getElementById('mdp').value)
   {
      surligne(champ, true);
      alert("Le mot de passe de confirmation est différent.");
      document.addEnseignant.confirm.focus();
      return false;
   }
   else
   {
      surligne(champ, false);
      return true;
   }
}