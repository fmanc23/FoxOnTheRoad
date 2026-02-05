# 🦊 FoxOnTheRoad

A 2D level-based arcade game built in Java where the player controls a fox navigating through busy roads, developed as part of the **GUI Programming and Mobile Devices** course.

---

## 📖 About

**FoxOnTheRoad** is a multi-level arcade game inspired by the classic road-crossing genre. The player guides a fox across increasingly challenging roads filled with obstacles and traffic. The game features a **camera system that follows the character**, smooth level progression, and escalating difficulty.

---

## 🎮 Gameplay

- 🦊 Control a fox character trying to cross multiple roads
- 🚗 Avoid traffic and obstacles to survive
- 📈 Progress through levels with increasing difficulty
- 🎥 Dynamic camera that follows the player character
- 🏆 Level-based structure with distinct challenges

---

## 🎓 Academic Context

| | |
|---|---|
| **Course** | GUI Programming and Mobile Devices |
| **Degree** | BSc in Computer and Electronic Engineering |
| **University** | University of Perugia (UNIPG) |
| **Year** | 2020 – 2023 |

### Learning Objectives

- Designing and implementing **graphical user interfaces** in Java
- Working with **game loops**, rendering, and real-time input handling
- Implementing a **scrolling camera system** that tracks the player
- Managing **game states** (menu, playing, game over, level transitions)
- Applying **object-oriented design patterns** to game architecture (entities, levels, collision detection)

---

## 🛠️ Tech Stack

| Technology | Usage |
|---|---|
| **Java** | Core language |
| **Java Swing / AWT** | Graphics rendering and input handling |

---

## 🚀 Getting Started

### Prerequisites

- Java JDK 8 or higher

### Run

```bash
git clone https://github.com/fmanc23/FoxOnTheRoad.git
cd FoxOnTheRoad
javac *.java
java Main
```

> ⚠️ Adjust the main class name if different. Check the source files for the correct entry point.

---

## 🏗️ Architecture

```
FoxOnTheRoad/
├── src/
│   ├── ...           # Game engine (loop, rendering, camera)
│   ├── ...           # Entities (fox, obstacles, vehicles)
│   ├── ...           # Level management and progression
│   └── ...           # Input handling and collision detection
├── assets/           # Sprites, textures, audio (if any)
└── README.md
```

### Core Components

- **Game Loop**: fixed-timestep update cycle for consistent gameplay
- **Camera System**: viewport that tracks the fox's position across the level
- **Level Manager**: handles level loading, difficulty scaling, and transitions
- **Collision Detection**: determines interactions between the fox and obstacles

---

## 📸 Screenshots

> _Coming soon — screenshots and gameplay GIFs will be added here._

---

## 📜 License

Academic project — University of Perugia (UNIPG).
