package br.com.andreramosdev.bis14.scenes;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;

import br.com.andreramosdev.bis14.config.Assets;
import br.com.andreramosdev.bis14.control.MenuButtons;
import br.com.andreramosdev.bis14.screens.ScreenBackground;

import static br.com.andreramosdev.bis14.config.DeviceSettings.screenHeigth;
import static br.com.andreramosdev.bis14.config.DeviceSettings.screenResolution;
import static br.com.andreramosdev.bis14.config.DeviceSettings.screenWidth;

/**
 * Created by andre on 11/08/15.
 */
public class TitleScreen extends CCLayer {

    private ScreenBackground background;

    public TitleScreen() {
        this.background = new ScreenBackground(Assets.BACKGROUND);
        this.background.setPosition(screenResolution(CGPoint.ccp(screenWidth() / 2.0f, screenHeigth() / 2.0f)));
        this.addChild(this.background);

        //
        // Tbm é possível adicionar o background sem criar uma classe screen
        // código abaixo:
        //
        /* CCSprite background = CCSprite.sprite(Assets.BACKGROUND);
        background.setPosition(screenResolution(CGPoint.ccp(screenWidth() / 2.0f, screenHeigth() / 2.0f)));
        this.addChild(background); */

        CCSprite title = CCSprite.sprite(Assets.LOGO);
        title.setPosition(screenResolution(
                CGPoint.ccp(screenWidth() / 2, screenHeigth() - 130)
        ));

        this.addChild(title);

        MenuButtons menuLayer = new MenuButtons();
        this.addChild(menuLayer);
    }

    public CCScene scene() {
        CCScene scene = CCScene.node();
        scene.addChild(this);
        return scene;
    }

}
