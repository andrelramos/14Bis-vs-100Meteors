package br.com.andreramosdev.bis14.objects;

import org.cocos2d.nodes.CCSprite;

import br.com.andreramosdev.bis14.config.Assets;
import br.com.andreramosdev.bis14.interfaces.ShootEngineDelegate;

import static br.com.andreramosdev.bis14.config.DeviceSettings.screenWidth;

/**
 * Created by andre on 13/08/15.
 */
public class Player  extends CCSprite {
    float positionX = screenWidth() / 2;
    float positionY = 50;
    private ShootEngineDelegate delegate;

    public Player() {
        super(Assets.NAVE);
        setPosition(positionX, positionY);
    }

    public void shoot() {
        delegate.createShoot(new Shoot(positionX, positionY));
    }

    public void setDelegate(ShootEngineDelegate delegate) {
        this.delegate = delegate;
    }

    public void moveLeft() {
        if(positionX > 30) {
            positionX -= 10;
        }
        setPosition(positionX, positionY);
    }

    public void moveRight() {
        if(positionX < screenWidth() - 30) {
            positionX += 10;
        }
        setPosition(positionX, positionY);
    }
}
