package br.com.andreramosdev.bis14.objects;

import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;

import br.com.andreramosdev.bis14.config.Assets;
import br.com.andreramosdev.bis14.interfaces.ShootEngineDelegate;

import static br.com.andreramosdev.bis14.config.DeviceSettings.screenResolution;

/**
 * Created by andre on 17/08/15.
 */
public class Shoot extends CCSprite {
    private ShootEngineDelegate delegate;
    float positionX, positionY;

    public Shoot(float positionX, float positionY) {
        super(Assets.SHOOT);
        this.positionX = positionX;
        this.positionY = positionY;
        setPosition(this.positionX, this.positionY);
        this.schedule("update");
    }

    public void update(float dt) {
        positionY += 2;
        this.setPosition(screenResolution(
                CGPoint.ccp(positionX, positionY)
        ));
    }

    public void setDelegate(ShootEngineDelegate delegate) {
        this.delegate = delegate;
    }

    public void start() {
        System.out.println("ShooT!!!!");
    }
}
