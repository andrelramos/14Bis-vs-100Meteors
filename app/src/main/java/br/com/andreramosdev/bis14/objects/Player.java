package br.com.andreramosdev.bis14.objects;

import org.cocos2d.nodes.CCSprite;

import br.com.andreramosdev.bis14.config.Assets;

import static br.com.andreramosdev.bis14.config.DeviceSettings.*;

/**
 * Created by andre on 13/08/15.
 */
public class Player  extends CCSprite {
    float positionX = screenWidth() / 2;
    float positionY = 50;

    public Player() {
        super(Assets.NAVE);
        setPosition(positionX, positionY);
    }

    /*public void setDelegate(ShootEngineDelegate delegate) {
        this.delegate = delegate;
    }*/
}
