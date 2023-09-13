package JavaGames;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Game2048 extends JPanel {

    private final int ROWS = 4;
    private final int COLS = 4;
    private final int TILE_SIZE = 150;
    private final int GAP = 10;

    private int[][] board;

    public Game2048() {
        setPreferredSize(new Dimension(COLS * (TILE_SIZE + GAP), ROWS * (TILE_SIZE + GAP)));
        setFocusable(true);

        // 初始化游戏板
        board = new int[ROWS][COLS];
        addNewTile();
        addNewTile();

        // 添加键盘监听器
        addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_W) {
                    moveTiles(Direction.UP);
                } else if (keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_S) {
                    moveTiles(Direction.DOWN);
                } else if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_A) {
                    moveTiles(Direction.LEFT);
                } else if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D) {
                    moveTiles(Direction.RIGHT);
                }
                repaint();
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

    // 添加新的方块
    private void addNewTile() {
        // 在空白的位置随机选择一个方块添加数字 2 或 4
        // 这里简化为直接添加数字 2
        int row, col;
        do {
            row = (int) (Math.random() * ROWS);
            col = (int) (Math.random() * COLS);
        } while (board[row][col] != 0);
        board[row][col] = 2;
    }

    // 移动方块
    private void moveTiles(Direction direction) {
        // 先根据移动方向进行行或列的遍历
        // 再对每个行或列中的方块进行合并或移动
        // 最后再添加新的方块
        // 这里只实现了向上移动的逻辑，其它方向类似，可以根据需要扩展

        switch (direction) {
            case DOWN:
            {
                System.out.println("DOWN");
                for (int col = 0; col < COLS; col++) {
                    for (int row = 0; row < ROWS; row++) {
                        if (board[row][col] != 0) {
                            for (int i = row + 1; i < ROWS; i++) {
                                if (board[i][col] == 0) {
                                    board[i][col] = board[row][col];
                                    board[row][col] = 0;
                                } else if (board[i][col] == board[row][col]) {
                                    board[i][col] *= 2;
                                    board[row][col] = 0;
                                    break;
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                }
                break;
            }
            case UP:
            {
                System.out.println("UP");
                break;
            }
            case LEFT:
            {
                System.out.println("LEFT");
                for (int row = 0; row < ROWS; row++) {
                    int[] currentRow = board[row];
                    int[] newRow = new int[ROWS];
                    int newIndex = 0;

                    for (int col = 0; col < COLS; col++) {
                        if (currentRow[col] != 0) {
                            if (newRow[newIndex] == 0) {
                                newRow[newIndex] = currentRow[col];
                            } else if (newRow[newIndex] == currentRow[col]) {
                                newRow[newIndex] *= 2;
                                newIndex++;
                            } else {
                                newIndex++;
                                newRow[newIndex] = currentRow[col];
                            }
                        }
                    }

                    board[row] = newRow;

                }
                break;
            }
            case RIGHT:
            {
                System.out.println("RIGHT");
                break;
            }
            // 实现其它方向的移动逻辑
        }
       //for(int i=0;i<10;i++)
        addNewTile();
    }

    // 绘制方块
    private void drawTile(Graphics2D g, int row, int col, int value) {
        int x = col * (TILE_SIZE + GAP);
        int y = row * (TILE_SIZE + GAP);

        g.setColor(getTileColor(value));
        g.fillRect(x, y, TILE_SIZE, TILE_SIZE);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 32));
        String text = value > 0 ? String.valueOf(value) : "";
        FontMetrics fm = g.getFontMetrics();
        int textWidth = fm.stringWidth(text);
        int textHeight = fm.getHeight();
        int textX = x + (TILE_SIZE - textWidth) / 2;
        int textY = y + (TILE_SIZE + textHeight) / 2;
        g.drawString(text, textX, textY);
    }

    // 获取方块对应的颜色
    private Color getTileColor(int value) {
        switch (value) {
            case 2:    return new Color(0xeeeeee);
            case 4:    return new Color(0xeee4da);
            case 8:    return new Color(0xede0c8);
            case 16:   return new Color(0xf2b179);
            case 32:   return new Color(0xf59563);
            case 64:   return new Color(0xf67c5f);
            case 128:  return new Color(0xf65e3b);
            case 256:  return new Color(0xedcf72);
            case 512:  return new Color(0xedcc61);
            case 1024: return new Color(0xedc850);
            case 2048: return new Color(0xedc53f);
            default:   return new Color(0xcdc1b4);
        }
    }

    // 绘制游戏界面
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 绘制游戏板
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                int value = board[row][col];
                drawTile(g2d, row, col, value);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("2048 Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(new Game2048());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private enum Direction {
        UP, DOWN, LEFT, RIGHT
    }
}
