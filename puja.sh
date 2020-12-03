#fem add i posem els arxius modificats "git add arxiu.html"
if [[ -z "$1" ]];
then
	echo "No definit cap parametre"
else
	git commit -am "$1"
	git push origin master
fi

