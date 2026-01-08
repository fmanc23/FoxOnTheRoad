🦊 Fox On The Road
Applicazione Desktop JFC/Swing – Progetto Universitario
Corso di Programmazione di Interfacce Grafiche e Dispositivi Mobili
A.A. 2021/2022 – Università degli Studi di Perugia

📌 Descrizione del Progetto
Fox On The Road è un videogioco desktop sviluppato in Java utilizzando JFC/Swing, ispirato al celebre gioco mobile Crossy Road.
L’obiettivo è guidare una volpe attraverso una serie di livelli pieni di ostacoli statici e dinamici, evitando collisioni e raccogliendo monete per aumentare le vite disponibili.

Il progetto è stato pensato per essere:

Multipiattaforma (testato su Windows e sistemi NIX-like)

Espandibile (nuovi livelli aggiungibili tramite file di testo)

Modulare (architettura Logic–View–Utilities)

🎮 Caratteristiche Principali
Controlli tramite WASD o frecce direzionali

Sistema di livelli progressivi + tutorial iniziale

Timer di livello con possibilità di pausa

Ostacoli statici (alberi, rocce) e dinamici (auto, camion)

Collisioni con gestione delle conseguenze

Monete che aumentano le vite

Texture animate per personaggio e veicoli

Suoni statici e dinamici

High Score salvati su file CSV

Mappa generata da file di testo con texture casuali

Movimento fluido grazie a un refresh grafico a 62.5 FPS

🧱 Architettura del Software
Il progetto segue una struttura Logic–View–Utilities, con comunicazione tramite interfacce e dependency injection.

📂 Logic
Gestisce tutta la logica del gioco:

Movimento della volpe

Gestione livelli e statistiche

Collisioni

Generazione della mappa logica

Gestione dei suoni dinamici e statici

Input da tastiera

Include il sotto-package Characters, che contiene:

Fox

Vehicle

Tree

Rock

Coin

EntityGroup

🎨 View
Gestisce la parte grafica:

GeneralGUI (finestra principale)

GameGUI (rendering del gioco)

StatGUI (statistiche e timer)

HighScoreGUI (gestione punteggi)

MapGraphics (generazione grafica della mappa)

🛠 Utilities
Funzioni di supporto:

Gestione path e asset

Lettura/scrittura file CSV e TXT

Riproduzione audio WAV

Caricamento mappe

🗺 Struttura dei Livelli
Ogni livello è definito da un file di testo di 10 righe, contenente:

Posizione degli ostacoli

Posizione delle monete

Tipologia di terreno

Entità dinamiche

Questo permette di aggiungere nuovi livelli senza modificare il codice.

🚀 Come Avviare il Gioco
Clona il repository:

bash
git clone https://github.com/tuo-username/fox-on-the-road.git
Importa il progetto in un IDE Java (IntelliJ, Eclipse, NetBeans…)

Assicurati di avere Java 8+

Esegui la classe:

Codice
src/utilities/Main.java
📁 Struttura del Repository
Codice
FoxOnTheRoad/
│
├── src/
│   ├── logic/
│   ├── view/
│   ├── utilities/
│   └── Main.java
│
├── Assets/
│   ├── Textures/
│   ├── Audio/
│   └── Misc/
│
├── Levels/
│   └── levelX.txt
│
└── README.md
🧪 Problemi Risolti Durante lo Sviluppo
Concorrenza nella gestione delle liste di entità

Sovrapposizione dei veicoli generati casualmente

Collisioni tra volpe e ostacoli statici

Fluidità del movimento e animazioni

Gestione dei pannelli dinamici (HighScoreGUI)

Composizione della mappa tramite BufferedImage

🔮 Sviluppi Futuri
Nuove tipologie di ostacoli e veicoli

Power-up e abilità speciali

Modalità endless

Sistema di punteggi online

Miglioramento del sound design

Porting su JavaFX o motori grafici più moderni

👥 Autori
Francesco Mancinelli – 329118

Tommaso Cosimi – 329956
