Benvenuto su Fox On The Road!

ISTRUZIONI PER L'ESECUZIONE
	Semplicemente eseguire lo script "Run.ps1" se si utilizza Windows (PowerShell) o "Run.sh" su *NIX-Like.
	Qualora non funzionasse, recarsi nella cartella "jar" ed eseguire manualmente l'archivio.
	Non alterare il contenuto delle altre cartelle a meno che non si stiano aggiungendo nuovi livelli o si stiano personalizzando la veste grafica e sonora dell'applicazione, in quanto sono necessarie per il caricamento delle risorse esterne.

ISTRUZIONI PER LA CREAZIONE DI NUOVE MAPPE
	Recarsi nella cartella "assets", e navigare nella sottocartella "LevelMaps".
	A questo punto creare un nuovo file x.txt, ove x è il numero di livello, ordinato rispetto agli altri (non si possono creare livelli fuori ordine, Es: 0.txt, 2.txt, 3.txt).
	Per la generazione della Mappa, seguire la seguente convenzione:
		- Il file di testo deve essere di 10 righe, altrimenti verrà visualizzato uno sfondo grigio, o non verrà visualizzata la mappa nella sua interezza;
		- Le colonne sono potenzialmente illimitate, l'utente potrà scegliere quanto lungo fare il livello;
		- Usare caratteri supportati, quali:
			- g -> Grass, crea un tile di tappeto erboso;
			- t -> Tree, inserisce un albero sopra la tile di tappeto erboso che gli spetterebbe;
			- r -> Rock, inserisce una roccia sopra la tile di tappeto erboso che gli spetterebbe;
			- c -> Coin, inserisce una moneta sopra la tile di tappeto erboso che gli spetterebbe;
			- a -> Lato sinistro della strada, crea una tile di strada;
			- s -> Lato destro della strada, crea una tile di strada;
			- f -> Finish, crea una tile per l'arrivo.
		  Nel caso venga utilizzato un carattere non supportato, il sistema dovrebbe essere in grado di utilizzare una texture non rappresentante alcuno degli elementi di cui sopra.

ISTRUZIONI PER LA PERSONALIZZAZIONE DELLE TEXTURE E DEGLI AUDIO
	Recarsi nella cartella "assets", e navigare nella sottocartella dell'elemento desiderato.
	PERSONALIZZAZIONE TEXTURE
		In questo caso le cartelle desiderate sono "Textures" e "Elements".
		Per cambiare elementi efficacemente, eseguire un backup del file originale aggiungendo un'estensione ".bak", in modo da poter ripristinare in maniera sicura la veste di default.
		I nuovi elementi dovranno avere stesse dimensioni in pixel, stessa estensione e stesso nome per funzionare correttamente, comprese le HitBox.
	PERSONALIZZAZIONE SONORA
		In questo caso recarsi nella cartella "Audio".
		Per cambiare elementi efficacemente, eseguire un backup del file originale aggiungendo un'estensione ".bak", in modo da poter ripristinare in maniera sicura la veste di default.
		I nuovi elementi devono essere in formato .wav per essere pienamente compatibili con i toolkit di default di Java, ed avere lo stesso nome dei file originali.