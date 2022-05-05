Installer Python 3.10.4 :

    Choisir "Windows Installer 64bit" 
    
   https://www.python.org/downloads/release/python-3104/
    

Mise en place de l'environnement virtuel pour le site web :
    
    Création du dossier d'environnement virtuel :
        python -m venv env 
    
    Se positionner dans le dossier BZH/    

    Activation de l'environnement virtuel (sur windows) :
        source env/Scripts/activate (Git bash de préférence, il contient certaines commandes Linux comme source)

    Installation la dépendence des modules Pythons via le fichier de requirements.txt :
        pip install -r requirements.txt

Mise en place du serveur local Django :
    
    1- Ouvrir un terminal
    2- Activer l'environnement virtuel : source env/Scripts/activate
    3- Se déplacer dans le dossier BZH/web_src 
    4- lancer la commande : Python manage.py runserver
    5- Accèder à l'adresse indiqué par le terminal sur un navigateur
