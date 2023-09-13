package JavaGames;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SnakeGame extends JFrame {

    private Snake snake;
    private Timer timer;
    private boolean isGameOver;

    public SnakeGame() {
        setTitle("Snake Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(400, 400);

        snake = new Snake();
        isGameOver = false;

        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isGameOver) {
                    snake.move();
                    if (snake.checkCollision()) {
                        isGameOver = true;
                        timer.stop();
                        JOptionPane.showMessageDialog(SnakeGame.this, "Game Over");
                    }
                    repaint();
                }
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_UP) {
                    snake.changeDirection(Direction.UP);
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    snake.changeDirection(Direction.DOWN);
                } else if (keyCode == KeyEvent.VK_LEFT) {
                    snake.changeDirection(Direction.LEFT);
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    snake.changeDirection(Direction.RIGHT);
                }
            }
        });

        setFocusable(true);
        requestFocusInWindow();

        setVisible(true);
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        snake.draw(g);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SnakeGame();
            }
        });
    }
}

enum Direction {
    UP, DOWN, LEFT, RIGHT
}

class Snake {

    private static final int UNIT_SIZE = 20;
    private static final int MAX_UNITS = 400;
    private static final int BOARD_SIZE = 20;

    private int[] x; // x坐标数组，存储贪吃蛇身体每个部分的x坐标
    private int[] y; // y坐标数组，存储贪吃蛇身体每个部分的y坐标
    private int bodyParts; // 贪吃蛇身体的长度
    private Direction direction; // 贪吃蛇移动的方向
    private int foodX; // 食物的x坐标
    private int foodY; // 食物的y坐标

    public Snake() {
        x = new int[MAX_UNITS];
        y = new int[MAX_UNITS];
        bodyParts = 6;
        direction = Direction.RIGHT;

        for (int i = 0; i < bodyParts; i++) {
            x[i] = 0;
            y[i] = 0;
        }

        generateFood();
    }

    public void changeDirection(Direction newDirection) {
        // 根据新的方向改变贪吃蛇的移动方向，避免掉头或与当前方向相反
        if ((newDirection == Direction.LEFT && direction != Direction.RIGHT) ||
                (newDirection == Direction.RIGHT && direction != Direction.LEFT) ||
                (newDirection == Direction.UP && direction != Direction.DOWN) ||
                (newDirection == Direction.DOWN && direction != Direction.UP)) {
            direction = newDirection;
        }
    }

    public void move() {
        // 移动贪吃蛇身体的每个部分
        for (int i = bodyParts - 1; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        // 根据移动方向改变贪吃蛇头部的坐标
        if (direction == Direction.UP) {
            y[0] -= UNIT_SIZE;
        } else if (direction == Direction.DOWN) {
            y[0] += UNIT_SIZE;
        } else if (direction == Direction.LEFT) {
            x[0] -= UNIT_SIZE;
        } else if (direction == Direction.RIGHT) {
            x[0] += UNIT_SIZE;
        }

        // 检查贪吃蛇是否吃到食物
        if (x[0] == foodX && y[0] == foodY) {
            bodyParts++;
            generateFood();
        }
    }

    public boolean checkCollision() {
        // 检查贪吃蛇是否碰到边界或自身的身体部分
        if (x[0] < 0 || x[0] >= BOARD_SIZE * UNIT_SIZE || y[0] < 0 || y[0] >= BOARD_SIZE * UNIT_SIZE) {
            return true;
        }

        for (int i = bodyParts - 1; i > 0; i--) {
            if (x[0] == x[i] && y[0] == y[i]) {
                return true;
            }
        }

        return false;
    }

    public void draw(Graphics g) {
        // 绘制游戏界面
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, BOARD_SIZE * UNIT_SIZE, BOARD_SIZE * UNIT_SIZE);

        g.setColor(Color.GREEN);
        g.fillOval(foodX, foodY, UNIT_SIZE, UNIT_SIZE);

        for (int i = 0; i < bodyParts; i++) {
            if (i == 0) {
                g.setColor(Color.YELLOW);
            } else {
                g.setColor(Color.GREEN);
            }
            g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
        }
    }

    private void generateFood() {
        // 随机生成食物的位置
        foodX = (int) (Math.random() * BOARD_SIZE) * UNIT_SIZE;
        foodY = (int) (Math.random() * BOARD_SIZE) * UNIT_SIZE;
    }
}
