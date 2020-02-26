package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import java.util.Random;

public class BlockItem extends BlockObject {
    private static final Random RNG = new Random();
    private static final Color BLOCKITEM_COLOUR = Color.CYAN;
    private static final Color BLOCKITEM_DEBUG_TEXT_COLOUR = Color.BLACK;
    private static final Color BLOCKITEM_UNIMPLEMENTED_COLOUR = Color.YELLOW;

    private final int X_CENTRE = x + 3;
    private final int Y_CENTRE = y + 15;

    private enum Item {
        BOMBUP, FIREUP, SKATEUP,
        KICK, PUNCH, THROW,
        FULLFIRE, POWERBOMB, SPIKEBOMB,
        HEART, DANGEROUSBOMB, REMOTEBOMB,
        BOMBDOWN, FIREDOWN, SKATEDOWN,
    }

    private Item item;

    public BlockItem(int x, int y) {
        super(x, y);
        this.BLOCK_COLOUR = BLOCKITEM_COLOUR;
        this.item = setItem();
    }

    @Override
    public Rectangle getBounds() {
        return super.getBounds();
    }

    @Override
    public boolean isColliding(GameObject other) {
        return super.isColliding(other);
    }

    @Override
    public void collisionHandling(GameObject other) {
        super.collisionHandling(other);
        if (other.getClass() == Player.class) {
            giveItem((Player)other);
            hit();
        }
    }

    @Override
    public void hit() {
        super.hit();
    }

    @Override
    public void draw(Graphics2D g) {
        super.draw(g);

        g.setColor(BLOCKITEM_DEBUG_TEXT_COLOUR);

        switch (item) {
            case BOMBUP:
                g.drawString("B+", X_CENTRE, Y_CENTRE);
                break;
            case FIREUP:
                g.drawString("F+", X_CENTRE, Y_CENTRE);
                break;
            case SKATEUP:
                g.drawString("S+", X_CENTRE, Y_CENTRE);
                break;

            case KICK:
                g.setColor(BLOCKITEM_UNIMPLEMENTED_COLOUR);
                g.drawString("KI", X_CENTRE, Y_CENTRE);
                break;
            case PUNCH:
                g.setColor(BLOCKITEM_UNIMPLEMENTED_COLOUR);
                g.drawString("PU", X_CENTRE, Y_CENTRE);
                break;
            case THROW:
                g.setColor(BLOCKITEM_UNIMPLEMENTED_COLOUR);
                g.drawString("TH", X_CENTRE, Y_CENTRE);
                break;

            case FULLFIRE:
                g.drawString("FF", X_CENTRE, Y_CENTRE);
                break;
            case POWERBOMB:
                g.drawString("PB", X_CENTRE, Y_CENTRE);
                break;
            case SPIKEBOMB:
                g.drawString("SB", X_CENTRE, Y_CENTRE);
                break;

            case HEART:
                g.drawString("H+", X_CENTRE, Y_CENTRE);
                break;
            case DANGEROUSBOMB:
                g.drawString("DB", X_CENTRE, Y_CENTRE);
                break;
            case REMOTEBOMB:
                g.drawString("RB", X_CENTRE, Y_CENTRE);
                break;

            case BOMBDOWN:
                g.drawString("B-", X_CENTRE, Y_CENTRE);
                break;
            case FIREDOWN:
                g.drawString("F-", X_CENTRE, Y_CENTRE);
                break;
            case SKATEDOWN:
                g.drawString("S-", X_CENTRE, Y_CENTRE);
                break;
        }
    }

    private Item setItem() {
        int randomNumber = RNG.nextInt(100);

        if (randomNumber < 60) {
            return setBasicItemUP();
        } else if (randomNumber >= 60 && randomNumber < 70) {
            return setUtilityItem();
        } else if (randomNumber >= 70 && randomNumber < 80) {
            return setBasicSpecialItem();
        } else if (randomNumber >= 80 && randomNumber < 90) {
            return setAdvancedSpecialItem();
        } else {
            return setBasicItemDOWN();
        }
    }

    private Item setBasicItemUP() {
        int randomNumber = RNG.nextInt(100);

        if (randomNumber < 33) {
            item = Item.BOMBUP;
        } else if (randomNumber >= 33 && randomNumber < 66) {
            item = Item.FIREUP;
        } else {
            item = Item.SKATEUP;
        }
        return item;
    }

    private Item setUtilityItem() {
        int randomNumber = RNG.nextInt(100);

        if (randomNumber < 33) {
            item = Item.KICK;
        } else if (randomNumber >= 33 && randomNumber < 66) {
            item = Item.PUNCH;
        } else {
            item = Item.THROW;
        }
        return item;
    }

    private Item setBasicSpecialItem() {
        int randomNumber = RNG.nextInt(100);

        if (randomNumber < 33) {
            item = Item.FULLFIRE;
        } else if (randomNumber >= 33 && randomNumber < 66) {
            item = Item.POWERBOMB;
        } else {
            item = Item.SPIKEBOMB;
        }
        return item;
    }

    private Item setAdvancedSpecialItem() {
        int randomNumber = RNG.nextInt(100);

        if (randomNumber < 33) {
            item = Item.HEART;
        } else if (randomNumber >= 33 && randomNumber < 66) {
            item = Item.DANGEROUSBOMB;
        } else {
            item = Item.REMOTEBOMB;
        }
        return item;
    }

    private Item setBasicItemDOWN() {
        int randomNumber = RNG.nextInt(100);

        if (randomNumber < 33) {
            item = Item.BOMBDOWN;
        } else if (randomNumber >= 33 && randomNumber < 66) {
            item = Item.FIREDOWN;
        } else {
            item = Item.SKATEDOWN;
        }
        return item;
    }

    private void giveItem(Player player) {
        switch (item) {
            case BOMBUP:
                player.bombUp();
                break;
            case FIREUP:
                player.fireUp();
                break;
            case SKATEUP:
                player.speedUp();
                break;

            case KICK:
                break;
            case PUNCH:
                break;
            case THROW:
                break;

            case FULLFIRE:
                player.fullFire();
                break;
            case POWERBOMB:
                player.powerBomb();
                break;
            case SPIKEBOMB:
                player.spikeBomb();
                break;

            case HEART:
                player.heartUp();
                break;
            case DANGEROUSBOMB:
                player.dangerousBomb();
                break;
            case REMOTEBOMB:
                player.remoteBomb();
                break;

            case BOMBDOWN:
                player.bombDown();
                break;
            case FIREDOWN:
                player.fireDown();
                break;
            case SKATEDOWN:
                player.speedDown();
                break;
        }
    }
}
