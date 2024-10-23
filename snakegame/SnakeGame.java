import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.Random;

public class SnakeGame extends JPanel implements ActionListener {
    private final int WIDTH = 600;
    private final int HEIGHT = 400;
    private final int DOT_SIZE = 10;
    private final int ALL_DOTS = (WIDTH * HEIGHT) / (DOT_SIZE * DOT_SIZE);
    private final int DELAY = 100;

    private int[] x = new int[ALL_DOTS];
    private int[] y = new int[ALL_DOTS];
    private int dots;
    private int fruitX;
    private int fruitY;
    private boolean running;
    private char direction;
    private char nextDirection;
    private Timer timer;

    public SnakeGame() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new MyKeyAdapter());
        startGame();
    }

    private void startGame() {
        running = true;
        dots = 3;
        direction = 'R'; // Start moving right
        nextDirection = 'R';
        timer = new Timer(DELAY, this);
        timer.start();
        generateFruit();
    }

    private void generateFruit() {
        Random rand = new Random();
        fruitX = rand.nextInt(WIDTH / DOT_SIZE) * DOT_SIZE;
        fruitY = rand.nextInt(HEIGHT / DOT_SIZE) * DOT_SIZE;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g) {
        if (running) {
            g.setColor(Color.RED);
            g.fillOval(fruitX, fruitY, DOT_SIZE, DOT_SIZE);

            for (int i = 0; i < dots; i++) {
                if (i == 0) {
                    g.setColor(Color.GREEN); // Snake head
                } else {
                    g.setColor(Color.YELLOW); // Snake body
                }
                g.fillRect(x[i], y[i], DOT_SIZE, DOT_SIZE);
            }

            g.setColor(Color.WHITE);
            g.setFont(new Font("Helvetica", Font.BOLD, 14));
            g.drawString("Score: " + (dots - 3), 10, 15);
        } else {
            gameOver(g);
        }
    }

    private void gameOver(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Helvetica", Font.BOLD, 20));
        g.drawString("Game Over", WIDTH / 2 - 50, HEIGHT / 2);
        g.setFont(new Font("Helvetica", Font.BOLD, 14));
        g.drawString("Score: " + (dots - 3), WIDTH / 2 - 25, HEIGHT / 2 + 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkFruitCollision();
            checkCollision();
        }
        repaint();
    }

    private void move() {
        for (int i = dots; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (nextDirection) {
            case 'U':
                y[0] -= DOT_SIZE;
                break;
            case 'D':
                y[0] += DOT_SIZE;
                break;
            case 'L':
                x[0] -= DOT_SIZE;
                break;
            case 'R':
                x[0] += DOT_SIZE;
                break;
        }

        direction = nextDirection;
    }

    private void checkFruitCollision() {
        if (x[0] == fruitX && y[0] == fruitY) {
            dots++;
            generateFruit();
        }
    }

    private void checkCollision() {
        if (x[0] < 0 || x[0] >= WIDTH || y[0] < 0 || y[0] >= HEIGHT) {
            running = false;
        }

        for (int i = 1; i < dots; i++) {
            if (x[0] == x[i] && y[0] == y[i]) {
                running = false;
            }
        }

        if (!running) {
            timer.stop();
        }
    }

    private class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    if (direction != 'D') nextDirection = 'U';
                    break;
                case KeyEvent.VK_DOWN:
                    if (direction != 'U') nextDirection = 'D';
                    break;
                case KeyEvent.VK_LEFT:
                    if (direction != 'R') nextDirection = 'L';
                    break;
                case KeyEvent.VK_RIGHT:
                    if (direction != 'L') nextDirection = 'R';
                    break;
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        SnakeGame game = new SnakeGame();
        frame.add(game);
        frame.setTitle("Snake Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
