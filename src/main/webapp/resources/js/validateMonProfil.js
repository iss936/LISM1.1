function surligne(champ, erreur)
{
   if(erreur)
      champ.style.backgroundColor = "#FFD9CF";
   else
      champ.style.backgroundColor = "";
}

function verifConfirmationMdp(champ)
{
	if(champ.value != document.getElementById('newMdp').value)
   {
      surligne(champ, true);
      alert("Le mot de passe de confirmation est différent.");
      document.setMdp.newMdpConfirm.focus();
      return false;
   }
   else
   {
      surligne(champ, false);
      return true;
   }
}