package br.com.andreramosdev.bis14.objects;

import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;

import java.util.Random;

import static br.com.andreramosdev.bis14.config.DeviceSettings.screenHeigth;
import static br.com.andreramosdev.bis14.config.DeviceSettings.screenResolution;
import static br.com.andreramosdev.bis14.config.DeviceSettings.screenWidth;

/**
 * Created by andre on 11/08/15.
 */
public class Meteor extends CCSprite {
    private float x, y;

    public Meteor(String image) {
        super(image);
        x = new Random().nextInt(Math.round(screenWidth()));
        y = screenHeigth();
    }

    public void start() {
        this.schedule("update");
    }

    public void update(float dt) {
        y -= 1;
        this.setPosition(screenResolution(CGPoint.ccp(x, y)));
    }
}
