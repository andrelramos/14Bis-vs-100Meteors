package br.com.andreramosdev.bis14.scenes;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.types.CGPoint;

import java.util.ArrayList;
import java.util.List;

import br.com.andreramosdev.bis14.config.Assets;
import br.com.andreramosdev.bis14.control.GameButtons;
import br.com.andreramosdev.bis14.engines.MeteorsEngine;
import br.com.andreramosdev.bis14.interfaces.MeteorsEngineDelegate;
import br.com.andreramosdev.bis14.interfaces.ShootEngineDelegate;
import br.com.andreramosdev.bis14.objects.Meteor;
import br.com.andreramosdev.bis14.objects.Player;
import br.com.andreramosdev.bis14.objects.Shoot;
import br.com.andreramosdev.bis14.screens.ScreenBackground;

import static br.com.andreramosdev.bis14.config.DeviceSettings.screenHeigth;
import static br.com.andreramosdev.bis14.config.DeviceSettings.screenResolution;
import static br.com.andreramosdev.bis14.config.DeviceSettings.screenWidth;

/**
 * Created by andre on 11/08/15.
 */
public class GameScene extends CCLayer implements MeteorsEngineDelegate, ShootEngineDelegate {
    private ScreenBackground background;
    private MeteorsEngine meteorsEngine;
    private CCLayer meteorsLayer;
    private List meteorsArray;
    private CCLayer playerLayer;
    private Player player;
    private CCLayer shootsLayer;
    private ArrayList shootsList;

    public GameScene() {
        this.background = new ScreenBackground(Assets.BACKGROUND);
        this.background.setPosition(screenResolution(CGPoint.ccp(screenWidth() / 2.0f, screenHeigth() / 2.0f)));
        this.addChild(this.background);

        this.meteorsLayer = CCLayer.node();
        this.addChild(this.meteorsLayer);

        this.playerLayer = CCLayer.node();
        this.addChild(this.playerLayer);

        this.shootsLayer = CCLayer.node();
        this.addChild(this.shootsLayer);

        this.setIsTouchEnabled(true);

        this.addGameObjects();

        GameButtons gameButtonsLayer = new GameButtons().gameButtons();
        this.addChild(gameButtonsLayer);

        gameButtonsLayer.setDelegate(this);

    }

    public static CCScene createGame() {
        CCScene scene = CCScene.node();
        GameScene layer = new GameScene();
        scene.addChild(layer);
        return scene;
    }

    private void addGameObjects() {
        this.meteorsArray = new ArrayList();
        this.meteorsEngine = new MeteorsEngine();
        this.player = new Player();
        this.playerLayer.addChild(player);
        this.shootsList = new ArrayList();
        this.player.setDelegate(this);
    }

    @Override
    public void createMeteor(Meteor meteor) {
        this.meteorsLayer.addChild(meteor);
        meteor.start();
        this.meteorsArray.add(meteor);
    }

    @Override
    public void onEnter() {
        super.onEnter();
        this.startEngines();
    }

    private void startEngines() {
        this.addChild(this.meteorsEngine);
        this.meteorsEngine.setDelegate(this);
    }

    @Override
    public void createShoot(Shoot shoot) {
        this.shootsLayer.addChild(shoot);
        shoot.setDelegate(this);
        shoot.start();
        this.shootsList.add(shoot);
    }

    public boolean shoot() {
        player.shoot();
        return true;
    }

    public void moveLeft() {
        player.moveLeft();
    }

    public void moveRight() {
        player.moveRight();
    }
}
