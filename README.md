# Air Hockey Plus ⚡

A classic 2-player air hockey game built with Java Swing, featuring multiple game modes and match history tracking.

## 📋 Description

Air Hockey Plus is a desktop arcade game that brings the excitement of air hockey to your computer. Players control paddles to hit a puck and score goals against their opponent. The game includes time-limited and goal-limited modes, real-time collision physics, and a complete match history system.

## ✨ Features

- 🎮 **Two Game Modes**
  - **Time Limited**: Race against the clock to score the most goals
  - **Goal Limited**: First player to reach the target score wins
  
- 🏆 **Complete Gameplay**
  - Smooth paddle controls using keyboard
  - Realistic ball physics and collision detection
  - Dynamic goal zones with margin variations
  - Real-time score tracking
  
- 📊 **Match History**
  - Track all previous games
  - View player names and final scores
  - See match completion status
  
- 🎨 **Clean UI**
  - Intuitive main menu
  - Game mode selection screen
  - Winner announcement screen
  - Match history viewer

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Java Runtime Environment (JRE)

### Installation

1. Clone the repository:
```bash
git clone https://github.com/koushamoeini/air-hockey-plus.git
```

2. Navigate to the project directory:
```bash
cd air-hockey-plus
```

3. Compile the Java files:
```bash
javac -d out src/*.java
```

4. Run the game:
```bash
java -cp out Main
```

### Alternative: Using IntelliJ IDEA

1. Open IntelliJ IDEA
2. Select "Open" and choose the project directory
3. Wait for the IDE to index the project
4. Right-click on `Main.java` in the `src` folder
5. Select "Run 'Main.main()'"

## 🎮 How to Play

### Controls

- **Blue Player (Top)**: Use arrow keys or WASD to move the paddle
- **Red Player (Bottom)**: Use arrow keys or WASD to move the paddle

### Game Modes

1. **Time Limited Mode**
   - Set a time limit for the match
   - Player with the most goals when time expires wins

2. **Goal Limited Mode**
   - Set a target score
   - First player to reach the goal wins

### Rules

- Hit the puck into your opponent's goal to score
- The puck bounces off walls and paddles
- Goals reset the puck to the center
- Match ends when time expires or goal limit is reached

## 🛠️ Technologies Used

- **Java SE** - Core programming language
- **Java Swing** - GUI framework
- **Java AWT** - Graphics and event handling
- **Java Timer** - Game loop and animation

## 📁 Project Structure

```
air-hockey-plus/
├── src/
│   ├── Main.java              # Application entry point
│   ├── GameFrame.java         # Main game logic and physics
│   ├── GamePanel.java         # Game rendering panel
│   ├── MainMenu.java          # Main menu interface
│   ├── SelectMode.java        # Game mode selection
│   ├── TimeDetails.java       # Game configuration
│   ├── History.java           # Match history viewer
│   ├── OneHistory.java        # Single match record
│   ├── Winner.java            # Winner announcement screen
│   └── ExitGame.java          # Exit confirmation
├── .gitignore
├── LICENSE
└── README.md
```

## 🤝 Contributing

Contributions are welcome! Feel free to:

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👤 Author

**Kousha Moeini**

- GitHub: [@koushamoeini](https://github.com/koushamoeini)

## 🙏 Acknowledgments

- Inspired by classic arcade air hockey games
- Built as a learning project for Java Swing and game development

---

**Enjoy the game!** ⚡🏒
