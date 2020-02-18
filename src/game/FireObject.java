package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class FireObject extends GameObject {
    protected static final int FIRE_RECURSION_DELAY = 10;

    protected Color FIRE_COLOUR = Color.YELLOW;
    protected int FIRE_DELAY = 500;
    protected boolean isFireLeftHit, isFireRightHit, isFireUpHit, isFireDownHit;

    protected FireObject(int x, int y) {
        super(x, y);
        isFireObject = true;

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isDead) {
                    try {
                        Thread.sleep(FIRE_DELAY);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    hit();
                }
            }
        });
        thread.start();
    }

    @Override
    protected Rectangle getBounds() {
        return super.getBounds();
    }

    @Override
    protected boolean isColliding(GameObject other) {
        return super.isColliding(other);
    }

    @Override
    protected void collisionHandling(GameObject other) {
        if (other.getClass() == BlockHard.class) {
            hit();

        } else if (other.getClass() == BlockSoft.class || other.getClass() == BlockItem.class
            || other instanceof BombObject) {
            other.hit();
            hit();

        } else if (!(other instanceof FireObject)) {
            other.hit();
        }
    }

    @Override
    protected void hit() {
        super.hit();
    }

    @Override
    protected void draw(Graphics2D g) {
        g.setColor(FIRE_COLOUR);
        g.drawRect(x, y, diameter, diameter);
        g.setColor(FIRE_COLOUR);
        g.fillRect(x, y, diameter, diameter);
    }

    protected abstract void emitFire(int x, int y, int range);
}
